drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(40) NULL DEFAULT NULL,
	`description` VARCHAR(40) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`cid` INT(11),
	PRIMARY KEY(`id`),
	FOREIGN KEY(`cid`) REFERENCES `ims`.`customers`(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`purchases` (
	`oid` INT(11),
	`iid` INT(11),
	PRIMARY KEY(`oid`,`iid`),
	FOREIGN KEY(`oid`) REFERENCES `ims`.`orders`(`id`),
	FOREIGN KEY(`iid`) REFERENCES `ims`.`items`(`id`)
);
