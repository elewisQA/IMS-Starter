package com.qa.ims.persistence.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum OrderUpdateDomain {
	DETAILS("Information about this order"),
	ITEMS("Items in this order"),
	RETURN("To return to order operations");
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private String description;
	
	private OrderUpdateDomain(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	public static void printDomains() {
		for (OrderUpdateDomain domain : OrderUpdateDomain.values()) {
			LOGGER.info(domain.getDescription());
		}
	}
	
	public static OrderUpdateDomain getDomain(Utils utils) {
		OrderUpdateDomain domain;
		while (true) {
			try {
				domain = OrderUpdateDomain.valueOf(utils.getString());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}
}
