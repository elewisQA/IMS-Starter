package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(2L, "Diet Slurm", "New Diet Slurm!", 2.99);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Slurm", "Slurm Cola!", 1.99));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "Slurm", "Slurm Cola!", 1.99),
				DAO.readItem(ID));
	
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "Slurm Classic", "Original Slurm Recipe!", 1.55);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
