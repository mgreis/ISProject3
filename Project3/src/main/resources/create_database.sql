
CREATE TABLE IF NOT EXISTS `smartphone` (
	`ID` bigint(20) NOT NULL AUTO_INCREMENT,
	`VERSION` bigint(20) NOT NULL,
	`TIMESTAMP` bigint(20) NOT NULL,
	`CRAWLER` varchar(100) NOT NULL,
	`URL` varchar(200) NOT NULL,
	`TITLE` varchar(100) NOT NULL,
	`PRICE` double NOT NULL,
	`PROCESSOR` varchar(200) DEFAULT NULL,
	`SCREENTYPE` varchar(200) DEFAULT NULL,
	`SCREENSIZE` varchar(200) DEFAULT NULL,
	`OTHER` varchar(200) DEFAULT NULL,
	PRIMARY KEY (`ID`),
	UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS `subscription` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`email` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
	`clientName` varchar(255) NOT NULL,
	`favoriteBrand` varchar(255) NOT NULL,
	`minimumPrice` double NOT NULL,
	`maximumPrice` double NOT NULL,
	`validated` tinyint(1) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB ;
