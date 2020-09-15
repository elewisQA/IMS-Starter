package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getFormatterLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item i : items) {
			LOGGER.info(i.toString());
		}
		return items;
	}
	
	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String name = utils.getString().toUpperCase();
		LOGGER.info("Please enter a description");
		String description = utils.getString().toUpperCase();
		LOGGER.info("Please enter a cost");
		Long cost = utils.getLong();
		Item item = itemDAO.create(new Item(name, description, cost));
		LOGGER.info("Item created");
		return item;
	}
	
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a name");
		String name = utils.getString().toUpperCase();
		LOGGER.info("Please enter a description");
		String description = utils.getString().toUpperCase();
		LOGGER.info("Please enter a cost");
		Long cost = utils.getLong();
		Item item = itemDAO.update(new Item(id, name, description, cost));
		LOGGER.info("Item updated");
		return item;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Item deleted.");
		return itemDAO.delete(id);
		
	}
}
