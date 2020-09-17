package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long CID = 1L;
		final String ADDRESS = "123 Fake-Street";
		final Boolean FULFILLED = false;
		final Order created = new Order(CID, ADDRESS, FULFILLED);
		
		Mockito.when(utils.getLong()).thenReturn(CID);
		Mockito.when(utils.getString()).thenReturn(ADDRESS);
		Mockito.when(utils.getBoolean()).thenReturn(FULFILLED);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, "123 Fake-Street", false));
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test
	public void testUpdateDetails() {
		Order updated = new Order(1L, 1L, "PLANET EXPRESS", true);
		
		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(utils.getString()).thenReturn(updated.getAddress());
		Mockito.when(utils.getBoolean()).thenReturn(updated.getFulfilled());
		Mockito.when(dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, controller.updateDetails(updated.getOid()));
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getBoolean();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
}
