INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('LEELA', 'TURANGA');
INSERT INTO `ims`.`items` (`name`, `description`, `cost`) VALUES ('SLURM', 'SLURM-COLA', 1.99);
INSERT INTO `ims`.`orders` (`cid`, `address`,`fulfilled`) VALUES(1,'PLANET EXPRESS', false);
INSERT INTO `ims`.`order_items` (`oid`, `iid`) VALUES(1, 1);