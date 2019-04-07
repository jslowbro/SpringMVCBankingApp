DROP SCHEMA IF EXISTS `web_banking_app`;

CREATE SCHEMA `web_banking_app`;

use `web_banking_app`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL, 
  `balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `transfer`;

CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `timestamp` timestamp DEFAULT NULL,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_FROM_idx` (`from_id`),
  FOREIGN KEY (`from_id`) REFERENCES `client` (`id`),
  KEY `FK_TO_idx` (`to_id`),
  FOREIGN KEY (`to_id`) REFERENCES `client` (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
