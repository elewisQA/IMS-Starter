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
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(1L, 1L, "123 Fake-Street", false);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		// TODO add a before to insert an item
		// TODO add a before to insert a customer
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, "123 Fake-Street", false));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadEverything() {
		// TODO add a before here to insert an order-item
		HashMap<CompoundOrder, List<CompoundOrderItem>> expectedMap = new HashMap<>();
		List<CompoundOrderItem> expectedList = new ArrayList<>();
		CompoundOrderItem coi = new CompoundOrderItem(1L, 1L, 1L, "Slurm", 1.99);
		expectedList.add(coi);
		CompoundOrder co = new CompoundOrder(1L, 1L, 1.99, "123 Fake-Street", false);
		expectedMap.put(co, expectedList);
		assertEquals(expectedMap, DAO.readEverything()); 
	}
	
	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 2L, "124 Fake-Street", true);
		assertEquals(updated, DAO.update(updated));
	}
	
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
