package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.CompoundOrder;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.CompoundOrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void  setup() {
		DBUtils.connect("src/test/resources/db.properties");
		// Use a different sql-data file to other tests, as this one contains a customer and item with which to create orders.
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/order-sql-data.sql");
		// TODO move this create statement to sql-data
		Order order = new Order(1L, "123 Fake-Street", false);
		DAO.create(order);
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(2L, 1L, "123 Fake-Street", false);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, "123 Fake-Street", false));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadEverything() {
		HashMap<CompoundOrder, List<CompoundOrderItem>> expectedMap = new HashMap<>();
		List<CompoundOrderItem> expectedList = new ArrayList<>();
		// TODO find way to test reading an order-item
		//new Order(1L, "123 Fake-Street", false);
		CompoundOrder co = new CompoundOrder(1L, 1L, 0.0, "123 Fake-Street", false);
		expectedMap.put(co, expectedList);
		assertEquals(expectedMap, DAO.readEverything()); 
	}
	
	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 1L, "124 Fake-Street", true);
		assertEquals(updated, DAO.update(updated));
	}
	
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
