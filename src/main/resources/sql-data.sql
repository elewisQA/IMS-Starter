INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('JORDAN', 'HARRISON');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('BENDER', 'RODRIGUEZ');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('LEELA', 'TURANGA');
INSERT INTO `ims`.`items` (`name`, `description`, `cost`) VALUES ('SLURM', 'Amazing Slurm drink!', 1.99);
INSERT INTO `ims`.`items` (`name`, `description`, `cost`) VALUES ('EXECUTIVE POWDER', 'NEW: Torgo`s Executive Powder!', 5.99);
INSERT INTO `ims`.`items` (`name`, `description`, `cost`) VALUES ('ROBOT OIL', 'Mom Co. Brand Robot Oil', 2.99);
INSERT INTO `ims`.`items` (`name`, `description`, `cost`) VALUES ('MOLTEN BORON', 'Nobody doesn`t like Molten Boron!', 14.99);
INSERT INTO `ims`.`items` (`name`, `description`, `cost`) VALUES ('THOMPSONS TEETH', 'The only teeth strong enough to eat other teeth', 2.55);
INSERT INTO `ims`.`orders` (`cid`, `address`, `fulfilled`) VALUES (1, '123 house', FALSE);
INSERT INTO `ims`.`orders` (`cid`, `address`, `fulfilled`) VALUES (2, 'Planet Express', TRUE);
INSERT INTO `ims`.`order_items` (`oid`, `iid`, `qty`) VALUES (1, 1, 5);
INSERT INTO `ims`.`order_items` (`oid`, `iid`, `qty`) VALUES (2, 3, 4);
INSERT INTO `ims`.`order_items` (`oid`, `iid`, `qty`) VALUES (2, 4, 1);