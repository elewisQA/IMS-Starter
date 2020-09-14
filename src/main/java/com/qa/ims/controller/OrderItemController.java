package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemDAO orderItemDAO;
	private Utils utils;
	private Long oid;
	
	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils, Long oid) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
		this.oid = oid;
	}

	@Override 
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem.toString());
		}
		return orderItems;
	}
	
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter an Item id");
		Long iid = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long qty = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(this.oid, iid, qty));
		return orderItem;
	}
	
	@Override
	public OrderItem update() {
		LOGGER.info("Please enter an item-id");
		Long iid = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long qty = utils.getLong();
		OrderItem order = orderItemDAO.update(new OrderItem(oid, iid, qty));
		LOGGER.info("Order-Item updated");
		return order;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the item-id of the order you would like to delete");
		Long iid = utils.getLong();
		LOGGER.info("Order-Item deleted.");
		return orderItemDAO.delete(iid);
	}
}
