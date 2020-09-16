package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.persistence.domain.CompoundOrder;
import com.qa.ims.persistence.domain.OrderUpdateDomain;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		HashMap<CompoundOrder, List<OrderItem>> fullOrders = orderDAO.readEverything();
		for (Map.Entry<CompoundOrder, List<OrderItem>> order : fullOrders.entrySet()) {
			// Display Order information via CompoundOrder's toString()
			LOGGER.info(order.getKey().toString());
			// Iterate through OrderItems list
			if (order.getValue() != null) {
				for (OrderItem item : order.getValue()) {
					LOGGER.info(" > " + item.toString());
				}
			} else {
				LOGGER.info(" > No Items in order");
			}
		}
		return orders;
	}
	
	@Override
	public Order create() {
		LOGGER.info("Please enter a Customer id");
		Long cid = utils.getLong();
		LOGGER.info("Please enter an address");
		String address = utils.getString();
		LOGGER.info("Please enter a fulfilled state");
		Boolean fulfilled = utils.getBoolean();
		Order order = orderDAO.create(new Order(cid, address, fulfilled));
		return order;
	}
	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long oid = utils.getLong();
		
		OrderUpdateDomain domain;
		
		while(true) {
			LOGGER.info("What would you like to modify?");
			OrderUpdateDomain.printDomains();
			
			domain = OrderUpdateDomain.getDomain(utils);
			Order toReturn = null;
			
			switch(domain) {
			case DETAILS:
				toReturn = updateDetails(oid);
				break;
			case ITEMS:
				updateOrderItems(oid);
				break;
			case RETURN:
				return toReturn;
			default:
				break;
			}
		}
	}
	
	public Order updateDetails(Long oid) {
		LOGGER.info("Please enter a customer-id");
		Long cid = utils.getLong();
		LOGGER.info("Please enter an address");
		String address = utils.getString();
		LOGGER.info("Please enter a fulfilled state");
		Boolean fulfilled = utils.getBoolean();
		Order order = orderDAO.update(new Order(oid, cid, address, fulfilled));
		LOGGER.info("Order updated");
		return order;
	}
	
	public void updateOrderItems(Long oid) {
		OrderItemDAO oiDao = new OrderItemDAO();
		OrderItemController oiController = new OrderItemController(oiDao, utils, oid);
		while (true) {
			LOGGER.info("What would you like to do with Order no." + oid + "'s items:");
			
			Action.printActions();
			Action action = Action.getAction(utils);
			
			if (action == Action.RETURN) {
				return;
			} else {
				switch (action) {
				case CREATE:
					oiController.create();
					break;
				case READ:
					oiController.readAll();
					break;
				case UPDATE:
					oiController.update();
					break;
				case DELETE:
					oiController.delete();
					break;
				case RETURN:
					break;
				default:
					break;
				}
			}
		}
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Order deleted.");
		return orderDAO.delete(id);
	}
}
