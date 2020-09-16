package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CompoundOrderTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(CompoundOrder.class).verify();
	}
	
}
