package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAOTest {
	
	private final OrderItemDAO DAO = new OrderItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/orderitem-sql-data.sql");
	}
	
	@Test
	public void testReadAll() {
		List<OrderItem> expectedList = new ArrayList<>();
		OrderItem orderItem = new OrderItem(1L, 1L, 1L);
		expectedList.add(orderItem);
		assertEquals(expectedList, DAO.readAll());
	}
	
	@Test 
	public void testReadWhere() { 
		List<OrderItem> expectedList = new ArrayList<>();
		OrderItem orderItem = new OrderItem(1L, 1L, 1L);
		expectedList.add(orderItem);
		assertEquals(expectedList, DAO.readWhere(orderItem.getOid()));
	}
	
	@Test
	public void testReadLatest() {
		List<OrderItem> expectedList = new ArrayList<>();
		OrderItem orderItem = new OrderItem(1L, 1L, 1L);
		expectedList.add(orderItem);
		assertEquals(expectedList, DAO.readAll());
	}

	@Test
	public void testCreate() { 
		OrderItem created = new OrderItem(2L, 1L, 1L);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void readOrderItem() {
		OrderItem created = new OrderItem(1L, 1L, 1L);
		assertEquals(created, DAO.readOrderItem(1L));
	}
	
	@Test
	public void testUpdate() {
		OrderItem item = new OrderItem(1L, 1L, 1L);
		assertEquals(item, DAO.update(item));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
