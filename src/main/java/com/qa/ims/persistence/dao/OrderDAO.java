package com.qa.ims.persistence.dao;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.CompoundOrderItem;
import com.qa.ims.persistence.domain.CompoundOrder;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("id");
		Long cid = resultSet.getLong("cid");
		String address = resultSet.getString("address");
		Boolean fulfilled = resultSet.getBoolean("fulfilled");
		return new Order(oid, cid, address, fulfilled);
	}
	
	public CompoundOrder modelCompoundFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("id");
		Long cid = resultSet.getLong("cid");
		Double cost = resultSet.getDouble("SUM(items.cost)");
		String address = resultSet.getString("address");
		Boolean fulfilled = resultSet.getBoolean("fulfilled");
		return new CompoundOrder(oid, cid, cost, address, fulfilled);
	}
	
	public CompoundOrderItem modelCompoundOrderItemFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long iid = resultSet.getLong("iid");
		Long oid = resultSet.getLong("oid");
		String name = resultSet.getString("name");
		Double cost = resultSet.getDouble("cost");
		return new CompoundOrderItem(id, oid, iid, name, cost);
	}
	
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			List<CompoundOrder> cOrders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public HashMap<CompoundOrder, List<CompoundOrderItem>> readEverything() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement orderStatement = connection.createStatement();
				// Get everything from Order_items table
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(""
						+ "SELECT order_items.id, order_items.iid, order_items.oid, items.name, items.cost "
						+ "FROM order_items, items "
						+ "WHERE order_items.iid = items.id")) {
			// Storage Objects
			List<Order> orders = readAll();
			HashMap<Long, List<CompoundOrderItem>> ordersMap =  new HashMap<>();
			
			// Populate Map
			for (Order order : orders) {
				ordersMap.put(order.getOid(), new ArrayList<CompoundOrderItem>());
			}
			
			// Iterate through Results - putting into map with key Order-ID
			while (resultSet.next()) {
				CompoundOrderItem oi = modelCompoundOrderItemFromResultSet(resultSet);
				ordersMap.get(oi.getOid()).add(oi); // Put into List where OID matches key
			}
			
			// Calculate Cost of each order
			HashMap<CompoundOrder, List<CompoundOrderItem>> compoundOrdersMap = new HashMap<>();
			for (Order order : orders) {
				Double cost = 0.0;
				for (CompoundOrderItem item : ordersMap.get(order.getOid())) {
					cost += item.getCost();
				}
				compoundOrdersMap.put(new CompoundOrder(order, cost), 
						ordersMap.get(order.getOid()));
			}
			return compoundOrdersMap;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new HashMap<>();
	}
		
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(""
						+ "SELECT orders.id, orders.cid, order_items.iid, SUM(items.cost), orders.address, orders.fulfilled "
						+ "FROM orders, order_items, items "
						+ "WHERE orders.id = order_items.oid "
						+ "AND order_items.iid = items.id "
						+ "ORDER BY orders.id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(cid, address, fulfilled) VALUES(" 
				+ order.getCid() + ",'" + order.getAddress() + "'," + order.getFulfilled() + ")");
			return readLatest();
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order readOrder(Long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders WHERE id = " + oid);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE orders SET cid = " + order.getCid() 
			+ ", address = '" + order.getAddress() + "', fulfilled = " + order.getFulfilled());
			return readOrder(order.getOid());
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public int delete(long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from order_items where oid = " + oid); // Foreign Key constraint
			return statement.executeUpdate("delete from orders where id = " + oid);
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Generic Exception - Something went seriously wrong.");
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}
