
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
	`email` varchar(255),
	`clientName` varchar(255) NOT NULL,
	`channel` varchar(255) NOT NULL,
	`favoriteBrand` varchar(255) NOT NULL,
	`minimumPrice` double NOT NULL,
	`maximumPrice` double NOT NULL,
	`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`uuid` varchar(255) CHARACTER SET latin1 NOT NULL,
	`active` tinyint(1) NOT NULL DEFAULT 0,
	PRIMARY KEY (`id`),
	UNIQUE KEY `u_uuid` (`uuid`)
) ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS `Statistics` (
	`ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
	`FIELD` VARCHAR(255) NOT NULL ,
	`NUMBEROF` BIGINT(20) NOT NULL , 
	PRIMARY KEY (`ID`),
	UNIQUE KEY `ID` (`ID`)
) ENGINE = InnoDB;

INSERT INTO `statistics`(`FIELD`, `NUMBEROF`) VALUES ('UPDATES',0);
INSERT INTO `statistics`(`FIELD`, `NUMBEROF`) VALUES ('SMARTPHONES',0);
INSERT INTO `statistics`(`FIELD`, `NUMBEROF`) VALUES ('EMAILS',0);
INSERT INTO `statistics`(`FIELD`, `NUMBEROF`) VALUES ('TWITTS',0);


