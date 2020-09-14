package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
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
		for (Order order : orders) {
			LOGGER.info(order.toString());
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
		Boolean fulfilled = true; //TODO - implement utils.getBoolean();
		Order order = orderDAO.create(new Order(cid, address, fulfilled));
		return order;
	}
	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long oid = utils.getLong();
		LOGGER.info("Please enter a customer-id");
		Long cid = utils.getLong();
		LOGGER.info("Please enter an address");
		String address = utils.getString();
		LOGGER.info("Please enter a fulfilled state");
		Boolean fulfilled = true; //TODO - implement utils.getBoolean();
		Order order = orderDAO.update(new Order(oid, cid, address, fulfilled));
		LOGGER.info("Order updated");
		return order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Order deleted.");
		return orderDAO.delete(id);
	}
}
