# ************************************************************
# Sequel Pro SQL dump
# Version 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Värd: localhost (MySQL 5.7.10)
# Databas: AirlineBookingSystem
# Genereringstid: 2016-04-09 07:43:54 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Tabelldump adminpassengerview
# ------------------------------------------------------------

DROP VIEW IF EXISTS `adminpassengerview`;

CREATE TABLE `adminpassengerview` (
   `flight_id` CHAR(6) NOT NULL DEFAULT '',
   `date` VARCHAR(11) NOT NULL DEFAULT '',
   `passport_nr` VARCHAR(11) NOT NULL DEFAULT '',
   `firstname` VARCHAR(11) NOT NULL DEFAULT '',
   `lastname` VARCHAR(11) NOT NULL DEFAULT '',
   `passport_exp` VARCHAR(11) NULL DEFAULT NULL,
   `passport_ish` VARCHAR(11) NULL DEFAULT NULL,
   `date_of_birth` VARCHAR(11) NULL DEFAULT NULL
) ENGINE=MyISAM;



# Tabelldump Airport
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Airport`;

CREATE TABLE `Airport` (
  `airport_id` varchar(3) NOT NULL DEFAULT '',
  `airport_city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`airport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Airport` WRITE;
/*!40000 ALTER TABLE `Airport` DISABLE KEYS */;

INSERT INTO `Airport` (`airport_id`, `airport_city`)
VALUES
	('ARN','Stockholm'),
	('CPH','Kopenhamn'),
	('DBX','Dubai'),
	('HKG','Hong Kong'),
	('HND','Tokyo'),
	('KUL','Kuala Lumpur'),
	('PEK','Beijing'),
	('SIN','Singapore'),
	('SSS','Saratown');

/*!40000 ALTER TABLE `Airport` ENABLE KEYS */;
UNLOCK TABLES;


# Tabelldump Booking
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Booking`;

CREATE TABLE `Booking` (
  `flight_id` char(6) NOT NULL DEFAULT '',
  `date` varchar(11) NOT NULL DEFAULT '',
  `passenger` varchar(11) NOT NULL DEFAULT '',
  `user` varchar(11) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`flight_id`,`passenger`,`date`),
  KEY `r1` (`flight_id`,`date`),
  KEY `passenger` (`passenger`),
  KEY `user` (`user`),
  CONSTRAINT `passenger` FOREIGN KEY (`passenger`) REFERENCES `Passenger` (`passport_nr`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `r1` FOREIGN KEY (`flight_id`, `date`) REFERENCES `FLight` (`flight_id`, `date`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `User` (`username`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Booking` WRITE;
/*!40000 ALTER TABLE `Booking` DISABLE KEYS */;

INSERT INTO `Booking` (`flight_id`, `date`, `passenger`, `user`, `status`)
VALUES
	('AX0025','2016-04-11','111111','Adam',NULL),
	('AX0025','2016-04-11','222222','Adam',NULL),
	('AX0025','2016-04-11','333333','Adam',NULL),
	('AX0025','2016-04-11','444444','Adam',NULL),
	('AX0025','2016-04-11','555555','Adam',NULL),
	('AX0025','2016-04-11','666666','Adam',NULL);

/*!40000 ALTER TABLE `Booking` ENABLE KEYS */;
UNLOCK TABLES;


# Tabelldump Flight
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Flight`;

CREATE TABLE `Flight` (
  `flight_id` char(6) NOT NULL DEFAULT '',
  `date` varchar(11) NOT NULL DEFAULT '',
  `departure_time` varchar(11) NOT NULL DEFAULT '',
  `duration` varchar(11) DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  `free_seats` int(11) NOT NULL,
  `origin` varchar(3) NOT NULL DEFAULT '',
  `destination` varchar(3) NOT NULL DEFAULT '',
  `price` varchar(11) DEFAULT NULL,
  `promotion` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`flight_id`,`date`),
  KEY `FK7D967090E789AAA4` (`origin`),
  KEY `FK7D967090CE6E3F8C` (`destination`),
  CONSTRAINT `FK7D967090CE6E3F8C` FOREIGN KEY (`destination`) REFERENCES `Airport` (`airport_id`),
  CONSTRAINT `FK7D967090E789AAA4` FOREIGN KEY (`origin`) REFERENCES `Airport` (`airport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Flight` WRITE;
/*!40000 ALTER TABLE `Flight` DISABLE KEYS */;

INSERT INTO `Flight` (`flight_id`, `date`, `departure_time`, `duration`, `capacity`, `free_seats`, `origin`, `destination`, `price`, `promotion`)
VALUES
	('AX0001','2016-04-11','10:00','2h10min',200,5,'PEK','DBX','1000','No'),
	('AX0001','2016-04-12','10:00','2h10min',200,5,'PEK','DBX','1000','No'),
	('AX0001','2016-04-13','10:00','2h10min',200,5,'PEK','DBX','1000','No'),
	('AX0002','2016-04-11','16:00','2h10min',200,5,'PEK','DBX','1000','No'),
	('AX0002','2016-04-12','16:00','2h10min',200,5,'PEK','DBX','1000','No'),
	('AX0002','2016-04-13','16:00','2h10min',200,5,'PEK','DBX','1000','No'),
	('AX0003','2016-04-11','10:00','2h10min',200,5,'PEK','HND','1000','No'),
	('AX0003','2016-04-12','10:00','2h10min',200,5,'PEK','HND','1000','No'),
	('AX0003','2016-04-13','10:00','2h10min',200,5,'PEK','HND','1000','No'),
	('AX0004','2016-04-11','16:00','2h10min',200,5,'PEK','HND','1000','No'),
	('AX0004','2016-04-12','16:00','2h10min',200,5,'PEK','HND','1000','No'),
	('AX0004','2016-04-13','16:00','2h10min',200,5,'PEK','HND','1000','No'),
	('AX0005','2016-04-11','10:00','2h10min',200,5,'PEK','HKG','1000','No'),
	('AX0005','2016-04-12','10:00','2h10min',200,5,'PEK','HKG','1000','No'),
	('AX0005','2016-04-13','10:00','2h10min',200,5,'PEK','HKG','1000','No'),
	('AX0006','2016-04-11','16:00','2h10min',200,5,'PEK','HKG','1000','No'),
	('AX0006','2016-04-12','16:00','2h10min',200,5,'PEK','HKG','1000','No'),
	('AX0006','2016-04-13','16:00','2h10min',200,5,'PEK','HKG','1000','No'),
	('AX0007','2016-04-11','10:00','2h10min',200,5,'PEK','SIN','1000','No'),
	('AX0007','2016-04-12','10:00','2h10min',200,5,'PEK','SIN','1000','No'),
	('AX0007','2016-04-13','10:00','2h10min',200,5,'PEK','SIN','1000','No'),
	('AX0008','2016-04-11','16:00','2h10min',200,5,'PEK','SIN','1000','No'),
	('AX0008','2016-04-12','16:00','2h10min',200,5,'PEK','SIN','1000','No'),
	('AX0008','2016-04-13','16:00','2h10min',200,5,'PEK','SIN','1000','No'),
	('AX0009','2016-04-11','10:00','2h10min',200,5,'PEK','KUL','1000','No'),
	('AX0009','2016-04-12','10:00','2h10min',200,5,'PEK','KUL','1000','No'),
	('AX0009','2016-04-13','10:00','2h10min',200,5,'PEK','KUL','1000','No'),
	('AX0010','2016-04-11','16:00','2h10min',200,5,'PEK','KUL','1000','No'),
	('AX0010','2016-04-12','16:00','2h10min',200,5,'PEK','KUL','1000','No'),
	('AX0010','2016-04-13','16:00','2h10min',200,5,'PEK','KUL','1000','No'),
	('AX0011','2016-04-11','10:00','2h10min',200,5,'DBX','PEK','1000','No'),
	('AX0011','2016-04-12','10:00','2h10min',200,5,'DBX','PEK','1000','No'),
	('AX0011','2016-04-13','10:00','2h10min',200,5,'DBX','PEK','1000','No'),
	('AX0012','2016-04-11','16:00','2h10min',200,5,'DBX','PEK','1000','No'),
	('AX0012','2016-04-12','16:00','2h10min',200,5,'DBX','PEK','1000','No'),
	('AX0012','2016-04-13','16:00','2h10min',200,5,'DBX','PEK','1000','No'),
	('AX0013','2016-04-11','10:00','2h10min',200,5,'DBX','HND','1000','No'),
	('AX0013','2016-04-12','10:00','2h10min',200,5,'DBX','HND','1000','No'),
	('AX0013','2016-04-13','10:00','2h10min',200,5,'DBX','HND','1000','No'),
	('AX0014','2016-04-11','16:00','2h10min',200,5,'DBX','HND','1000','No'),
	('AX0014','2016-04-12','16:00','2h10min',200,5,'DBX','HND','1000','No'),
	('AX0014','2016-04-13','16:00','2h10min',200,5,'DBX','HND','1000','No'),
	('AX0015','2016-04-11','10:00','2h10min',200,5,'DBX','HKG','1000','No'),
	('AX0015','2016-04-12','10:00','2h10min',200,5,'DBX','HKG','1000','No'),
	('AX0015','2016-04-13','10:00','2h10min',200,5,'DBX','HKG','1000','No'),
	('AX0016','2016-04-11','16:00','2h10min',200,5,'DBX','HKG','1000','No'),
	('AX0016','2016-04-12','16:00','2h10min',200,5,'DBX','HKG','1000','No'),
	('AX0016','2016-04-13','16:00','2h10min',200,5,'DBX','HKG','1000','No'),
	('AX0017','2016-04-11','10:00','2h10min',200,5,'DBX','SIN','1000','No'),
	('AX0017','2016-04-12','10:00','2h10min',200,5,'DBX','SIN','1000','No'),
	('AX0017','2016-04-13','10:00','2h10min',200,5,'DBX','SIN','1000','No'),
	('AX0018','2016-04-11','16:00','2h10min',200,5,'DBX','SIN','1000','No'),
	('AX0018','2016-04-12','16:00','2h10min',200,5,'DBX','SIN','1000','No'),
	('AX0018','2016-04-13','16:00','2h10min',200,5,'DBX','SIN','1000','No'),
	('AX0019','2016-04-11','10:00','2h10min',200,5,'DBX','KUL','1000','No'),
	('AX0019','2016-04-12','10:00','2h10min',200,5,'DBX','KUL','1000','No'),
	('AX0019','2016-04-13','10:00','2h10min',200,5,'DBX','KUL','1000','No'),
	('AX0020','2016-04-11','16:00','2h10min',200,5,'DBX','KUL','1000','No'),
	('AX0020','2016-04-12','16:00','2h10min',200,5,'DBX','KUL','1000','No'),
	('AX0020','2016-04-13','16:00','2h10min',200,5,'DBX','KUL','1000','No'),
	('AX0021','2016-04-11','10:00','2h10min',200,5,'HND','PEK','1000','No'),
	('AX0021','2016-04-12','10:00','2h10min',200,5,'HND','PEK','1000','No'),
	('AX0021','2016-04-13','10:00','2h10min',200,5,'HND','PEK','1000','No'),
	('AX0022','2016-04-11','16:00','2h10min',200,5,'HND','PEK','1000','No'),
	('AX0022','2016-04-12','16:00','2h10min',200,5,'HND','PEK','1000','No'),
	('AX0022','2016-04-13','16:00','2h10min',200,5,'HND','PEK','1000','No'),
	('AX0023','2016-04-11','10:00','2h10min',200,5,'HND','DBX','1000','No'),
	('AX0023','2016-04-12','10:00','2h10min',200,5,'HND','DBX','1000','No'),
	('AX0023','2016-04-13','10:00','2h10min',200,5,'HND','DBX','1000','No'),
	('AX0024','2016-04-11','16:00','2h10min',200,5,'HND','DBX','1000','No'),
	('AX0024','2016-04-12','16:00','2h10min',200,5,'HND','DBX','1000','No'),
	('AX0024','2016-04-13','16:00','2h10min',200,5,'HND','DBX','1000','No'),
	('AX0025','2016-04-11','10:00','2h10min',200,10,'HND','HKG','1000','Yes'),
	('AX0025','2016-04-12','10:00','2h10min',200,5,'HND','HKG','1000','Yes'),
	('AX0025','2016-04-13','10:00','2h10min',200,5,'HND','HKG','399','Yes'),
	('AX0026','2016-04-11','16:00','2h10min',200,5,'HND','HKG','1000','Yes'),
	('AX0026','2016-04-12','16:00','2h10min',200,5,'HND','HKG','1000','Yes'),
	('AX0026','2016-04-13','16:00','2h10min',200,5,'HND','HKG','1000','Yes'),
	('AX0027','2016-04-11','10:00','2h10min',200,5,'HND','SIN','1000','No'),
	('AX0027','2016-04-12','10:00','2h10min',200,5,'HND','SIN','1000','No'),
	('AX0027','2016-04-13','10:00','2h10min',200,5,'HND','SIN','1000','No'),
	('AX0028','2016-04-11','16:00','2h10min',200,5,'HND','SIN','1000','No'),
	('AX0028','2016-04-12','16:00','2h10min',200,5,'HND','SIN','1000','No'),
	('AX0028','2016-04-13','16:00','2h10min',200,5,'HND','SIN','1000','No'),
	('AX0029','2016-04-11','10:00','2h10min',200,5,'HND','KUL','1000','No'),
	('AX0029','2016-04-12','10:00','2h10min',200,5,'HND','KUL','1000','No'),
	('AX0029','2016-04-13','10:00','2h10min',200,5,'HND','KUL','1000','No'),
	('AX0030','2016-04-11','16:00','2h10min',200,5,'HND','KUL','1000','No'),
	('AX0030','2016-04-12','16:00','2h10min',200,5,'HND','KUL','1000','No'),
	('AX0030','2016-04-13','16:00','2h10min',200,5,'HND','KUL','1000','No'),
	('AX0031','2016-04-11','10:00','2h10min',200,5,'HKG','PEK','1000','No'),
	('AX0031','2016-04-12','10:00','2h10min',200,5,'HKG','PEK','1000','No'),
	('AX0031','2016-04-13','10:00','2h10min',200,5,'HKG','PEK','1000','No'),
	('AX0032','2016-04-11','16:00','2h10min',200,5,'HKG','PEK','1000','No'),
	('AX0032','2016-04-12','16:00','2h10min',200,5,'HKG','PEK','1000','No'),
	('AX0032','2016-04-13','16:00','2h10min',200,5,'HKG','PEK','1000','No'),
	('AX0033','2016-04-11','10:00','2h10min',200,5,'HKG','DBX','1000','No'),
	('AX0033','2016-04-12','10:00','2h10min',200,5,'HKG','DBX','1000','No'),
	('AX0033','2016-04-13','10:00','2h10min',200,5,'HKG','DBX','1000','No'),
	('AX0034','2016-04-11','16:00','2h10min',200,5,'HKG','DBX','1000','No'),
	('AX0034','2016-04-12','16:00','2h10min',200,5,'HKG','DBX','1000','No'),
	('AX0034','2016-04-13','16:00','2h10min',200,5,'HKG','DBX','1000','No'),
	('AX0035','2016-04-11','10:00','2h10min',200,5,'HKG','HND','1000','Yes'),
	('AX0035','2016-04-12','10:00','2h10min',200,5,'HKG','HND','1000','Yes'),
	('AX0035','2016-04-13','10:00','2h10min',200,5,'HKG','HND','399','Yes'),
	('AX0036','2016-04-11','16:00','2h10min',200,5,'HKG','HND','1000','Yes'),
	('AX0036','2016-04-12','16:00','2h10min',200,5,'HKG','HND','1000','Yes'),
	('AX0036','2016-04-13','16:00','2h10min',200,5,'HKG','HND','1000','Yes'),
	('AX0037','2016-04-11','10:00','2h10min',200,5,'HKG','SIN','1000','No'),
	('AX0037','2016-04-12','10:00','2h10min',200,5,'HKG','SIN','1000','No'),
	('AX0037','2016-04-13','10:00','2h10min',200,5,'HKG','SIN','1000','No'),
	('AX0038','2016-04-11','16:00','2h10min',200,5,'HKG','SIN','1000','No'),
	('AX0038','2016-04-12','16:00','2h10min',200,5,'HKG','SIN','1000','No'),
	('AX0038','2016-04-13','16:00','2h10min',200,5,'HKG','SIN','1000','No'),
	('AX0039','2016-04-11','10:00','2h10min',200,5,'HKG','KUL','200','Yes'),
	('AX0039','2016-04-12','10:00','2h10min',200,5,'HKG','KUL','1000','Yes'),
	('AX0039','2016-04-13','10:00','2h10min',200,5,'HKG','KUL','1000','Yes'),
	('AX0040','2016-04-11','16:00','2h10min',200,5,'HKG','KUL','1000','Yes'),
	('AX0040','2016-04-12','16:00','2h10min',200,5,'HKG','KUL','1000','Yes'),
	('AX0040','2016-04-13','16:00','2h10min',200,5,'HKG','KUL','1000','Yes'),
	('AX0041','2016-04-11','10:00','2h10min',200,5,'SIN','PEK','1000','No'),
	('AX0041','2016-04-12','10:00','2h10min',200,5,'SIN','PEK','1000','No'),
	('AX0041','2016-04-13','10:00','2h10min',200,5,'SIN','PEK','1000','No'),
	('AX0042','2016-04-11','16:00','2h10min',200,5,'SIN','PEK','1000','No'),
	('AX0042','2016-04-12','16:00','2h10min',200,5,'SIN','PEK','1000','No'),
	('AX0042','2016-04-13','16:00','2h10min',200,5,'SIN','PEK','1000','No'),
	('AX0043','2016-04-11','10:00','2h10min',200,5,'SIN','DBX','1000','No'),
	('AX0043','2016-04-12','10:00','2h10min',200,5,'SIN','DBX','1000','No'),
	('AX0043','2016-04-13','10:00','2h10min',200,5,'SIN','DBX','1000','No'),
	('AX0044','2016-04-11','16:00','2h10min',200,5,'SIN','DBX','1000','No'),
	('AX0044','2016-04-12','16:00','2h10min',200,5,'SIN','DBX','1000','No'),
	('AX0044','2016-04-13','16:00','2h10min',200,5,'SIN','DBX','1000','No'),
	('AX0045','2016-04-11','10:00','2h10min',200,5,'SIN','HND','1000','No'),
	('AX0045','2016-04-12','10:00','2h10min',200,5,'SIN','HND','1000','No'),
	('AX0045','2016-04-13','10:00','2h10min',200,5,'SIN','HND','1000','No'),
	('AX0046','2016-04-11','16:00','2h10min',200,5,'SIN','HND','1000','No'),
	('AX0046','2016-04-12','16:00','2h10min',200,5,'SIN','HND','1000','No'),
	('AX0046','2016-04-13','16:00','2h10min',200,5,'SIN','HND','1000','No'),
	('AX0047','2016-04-11','10:00','2h10min',200,5,'SIN','HKG','1000','No'),
	('AX0047','2016-04-12','10:00','2h10min',200,5,'SIN','HKG','1000','No'),
	('AX0047','2016-04-13','10:00','2h10min',200,5,'SIN','HKG','1000','No'),
	('AX0048','2016-04-11','16:00','2h10min',200,5,'SIN','HKG','1000','No'),
	('AX0048','2016-04-12','16:00','2h10min',200,5,'SIN','HKG','1000','No'),
	('AX0048','2016-04-13','16:00','2h10min',200,5,'SIN','HKG','1000','No'),
	('AX0049','2016-04-11','10:00','2h10min',200,5,'SIN','KUL','1000','No'),
	('AX0049','2016-04-12','10:00','2h10min',200,5,'SIN','KUL','1000','No'),
	('AX0049','2016-04-13','10:00','2h10min',200,5,'SIN','KUL','1000','No'),
	('AX0050','2016-04-11','16:00','2h10min',200,5,'SIN','KUL','1000','No'),
	('AX0050','2016-04-12','16:00','2h10min',200,5,'SIN','KUL','1000','No'),
	('AX0050','2016-04-13','16:00','2h10min',200,5,'SIN','KUL','1000','No'),
	('AX0051','2016-04-11','10:00','2h10min',200,5,'KUL','PEK','1000','No'),
	('AX0051','2016-04-12','10:00','2h10min',200,5,'KUL','PEK','1000','No'),
	('AX0051','2016-04-13','10:00','2h10min',200,5,'KUL','PEK','1000','No'),
	('AX0052','2016-04-11','16:00','2h10min',200,5,'KUL','PEK','1000','No'),
	('AX0052','2016-04-12','16:00','2h10min',200,5,'KUL','PEK','1000','No'),
	('AX0052','2016-04-13','16:00','2h10min',200,5,'KUL','PEK','1000','No'),
	('AX0053','2016-04-11','10:00','2h10min',200,5,'KUL','DBX','1000','No'),
	('AX0053','2016-04-12','10:00','2h10min',200,5,'KUL','DBX','1000','No'),
	('AX0053','2016-04-13','10:00','2h10min',200,5,'KUL','DBX','1000','No'),
	('AX0054','2016-04-11','16:00','2h10min',200,5,'KUL','DBX','1000','No'),
	('AX0054','2016-04-12','16:00','2h10min',200,5,'KUL','DBX','1000','No'),
	('AX0054','2016-04-13','16:00','2h10min',200,5,'KUL','DBX','1000','No'),
	('AX0055','2016-04-11','10:00','2h10min',200,5,'KUL','HND','1000','No'),
	('AX0055','2016-04-12','10:00','2h10min',200,5,'KUL','HND','1000','No'),
	('AX0055','2016-04-13','10:00','2h10min',200,5,'KUL','HND','1000','No'),
	('AX0056','2016-04-11','16:00','2h10min',200,5,'KUL','HND','1000','No'),
	('AX0056','2016-04-12','16:00','2h10min',200,5,'KUL','HND','1000','No'),
	('AX0056','2016-04-13','16:00','2h10min',200,5,'KUL','HND','1000','No'),
	('AX0057','2016-04-11','10:00','2h10min',200,5,'KUL','HKG','1000','No'),
	('AX0057','2016-04-12','10:00','2h10min',200,5,'KUL','HKG','1000','No'),
	('AX0057','2016-04-13','10:00','2h10min',200,5,'KUL','HKG','1000','No'),
	('AX0058','2016-04-11','16:00','2h10min',200,5,'KUL','HKG','1000','No'),
	('AX0058','2016-04-12','16:00','2h10min',200,5,'KUL','HKG','1000','No'),
	('AX0058','2016-04-13','16:00','2h10min',200,5,'KUL','HKG','1000','No'),
	('AX0059','2016-04-11','10:00','2h10min',200,5,'KUL','SIN','1000','No'),
	('AX0059','2016-04-12','10:00','2h10min',200,5,'KUL','SIN','1000','No'),
	('AX0059','2016-04-13','10:00','2h10min',200,5,'KUL','SIN','1000','No'),
	('AX0060','2016-04-11','16:00','2h10min',200,5,'KUL','SIN','1000','No'),
	('AX0060','2016-04-12','16:00','2h10min',200,5,'KUL','SIN','1000','No'),
	('AX0060','2016-04-13','16:00','2h10min',200,5,'KUL','SIN','1000','No');

/*!40000 ALTER TABLE `Flight` ENABLE KEYS */;
UNLOCK TABLES;


# Tabelldump mybookingselement
# ------------------------------------------------------------

DROP VIEW IF EXISTS `mybookingselement`;

CREATE TABLE `mybookingselement` (
   `flight_id` CHAR(6) NOT NULL DEFAULT '',
   `date` VARCHAR(11) NOT NULL DEFAULT '',
   `departure_time` VARCHAR(11) NOT NULL DEFAULT '',
   `duration` VARCHAR(11) NULL DEFAULT NULL,
   `origin` VARCHAR(3) NOT NULL DEFAULT '',
   `destination` VARCHAR(3) NOT NULL DEFAULT '',
   `firstname` VARCHAR(11) NOT NULL DEFAULT '',
   `lastname` VARCHAR(11) NOT NULL DEFAULT '',
   `passport_nr` VARCHAR(11) NOT NULL DEFAULT '',
   `user` VARCHAR(11) NULL DEFAULT NULL
) ENGINE=MyISAM;



# Tabelldump Passenger
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Passenger`;

CREATE TABLE `Passenger` (
  `passport_nr` varchar(11) NOT NULL DEFAULT '',
  `firstname` varchar(11) NOT NULL DEFAULT '',
  `lastname` varchar(11) NOT NULL DEFAULT '',
  `passport_exp` varchar(11) DEFAULT NULL,
  `passport_ish` varchar(11) DEFAULT NULL,
  `date_of_birth` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`passport_nr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Passenger` WRITE;
/*!40000 ALTER TABLE `Passenger` DISABLE KEYS */;

INSERT INTO `Passenger` (`passport_nr`, `firstname`, `lastname`, `passport_exp`, `passport_ish`, `date_of_birth`)
VALUES
	('111111','Adam','Myren','','',''),
	('222222','Sara','Nero','','',''),
	('333333','Ola ','Lindh','','',''),
	('444444','Erik','Sundgren','','',''),
	('555555','Johan','Larsson','','',''),
	('666666','Mats','Axelsson','','',''),
	('777777','Simon','Sundell','','',''),
	('888888','Tobias','Bengtsson','','','');

/*!40000 ALTER TABLE `Passenger` ENABLE KEYS */;
UNLOCK TABLES;


# Tabelldump promotion
# ------------------------------------------------------------

DROP VIEW IF EXISTS `promotion`;

CREATE TABLE `promotion` (
   `origin_city` VARCHAR(20) NULL DEFAULT NULL,
   `origin_id` VARCHAR(3) NOT NULL DEFAULT '',
   `destination_id` VARCHAR(3) NOT NULL DEFAULT '',
   `destination_city` VARCHAR(20) NULL DEFAULT NULL,
   `price` VARCHAR(11) NULL DEFAULT NULL
) ENGINE=MyISAM;



# Tabelldump User
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `username` varchar(11) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '',
  `email` varchar(40) DEFAULT NULL,
  `admin` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;

INSERT INTO `User` (`username`, `password`, `email`, `admin`)
VALUES
	('Adam','hej123','adammyren92@gmail.com','false'),
	('admin','admin','admin@airlinebooking.com','true');

/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;




# Replace placeholder table for promotion with correct view syntax
# ------------------------------------------------------------

DROP TABLE `promotion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `promotion`
AS SELECT
   `a1`.`airport_city` AS `origin_city`,
   `a1`.`airport_id` AS `origin_id`,
   `a2`.`airport_id` AS `destination_id`,
   `a2`.`airport_city` AS `destination_city`,max(`flight`.`price`) AS `price`
FROM ((`flight` join `airport` `a1` on((`flight`.`origin` = `a1`.`airport_id`))) join `airport` `a2` on((`a2`.`airport_id` = `flight`.`destination`))) where (`flight`.`promotion` = 'Yes') group by `flight`.`destination`,`flight`.`origin`;


# Replace placeholder table for adminpassengerview with correct view syntax
# ------------------------------------------------------------

DROP TABLE `adminpassengerview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `adminpassengerview`
AS SELECT
   `booking`.`flight_id` AS `flight_id`,
   `booking`.`date` AS `date`,
   `booking`.`passenger` AS `passport_nr`,
   `passenger`.`firstname` AS `firstname`,
   `passenger`.`lastname` AS `lastname`,
   `passenger`.`passport_exp` AS `passport_exp`,
   `passenger`.`passport_ish` AS `passport_ish`,
   `passenger`.`date_of_birth` AS `date_of_birth`
FROM (`booking` join `passenger` on((`booking`.`passenger` = `passenger`.`passport_nr`)));


# Replace placeholder table for mybookingselement with correct view syntax
# ------------------------------------------------------------

DROP TABLE `mybookingselement`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mybookingselement`
AS SELECT
   `flight`.`flight_id` AS `flight_id`,
   `flight`.`date` AS `date`,
   `flight`.`departure_time` AS `departure_time`,
   `flight`.`duration` AS `duration`,
   `flight`.`origin` AS `origin`,
   `flight`.`destination` AS `destination`,
   `passenger`.`firstname` AS `firstname`,
   `passenger`.`lastname` AS `lastname`,
   `passenger`.`passport_nr` AS `passport_nr`,
   `booking`.`user` AS `user`
FROM ((`flight` join `booking` on(((`booking`.`date` = `flight`.`date`) and (`booking`.`flight_id` = `flight`.`flight_id`)))) join `passenger` on((`booking`.`passenger` = `passenger`.`passport_nr`)));

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
