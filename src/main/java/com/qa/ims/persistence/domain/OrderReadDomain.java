package com.qa.ims.persistence.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum OrderReadDomain {
	ALL("All orders"),
	HISTORY("All fulfilled orders"),
	CUSTOMER("All orders by a specific customer"),
	ONE("A specific order"),
	COST("Cost of a specific order"),
	RETURN("Return to order operations");
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private String description;
	
	private OrderReadDomain(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
	
	public static void printDomains() {
		for (OrderReadDomain domain : OrderReadDomain.values()) {
			LOGGER.info(domain.getDescription());
		}
	}
	
	public static OrderReadDomain getDomain(Utils utils) {
		OrderReadDomain domain;
		while (true) {
			try {
				domain = OrderReadDomain.valueOf(utils.getString().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}

}
