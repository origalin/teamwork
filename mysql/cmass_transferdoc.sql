CREATE DATABASE  IF NOT EXISTS `cmass` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cmass`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: cmass
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `transferdoc`
--

DROP TABLE IF EXISTS `transferdoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferdoc` (
  `id` char(45) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL,
  `planenum` char(45) DEFAULT NULL,
  `trainnum` char(45) DEFAULT NULL,
  `carnum` char(45) DEFAULT NULL,
  `tranceid` char(45) DEFAULT NULL,
  `corriage` char(45) DEFAULT NULL,
  `container` char(45) DEFAULT NULL,
  `from` char(45) DEFAULT NULL,
  `targetcity` char(45) DEFAULT NULL,
  `itemids` text,
  `price` double DEFAULT NULL,
  `checked` int(11) DEFAULT NULL,
  `paid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferdoc`
--

LOCK TABLES `transferdoc` WRITE;
/*!40000 ALTER TABLE `transferdoc` DISABLE KEYS */;
INSERT INTO `transferdoc` VALUES ('00251201511230000001','2015-11-26','c1212','','','123456','','12','南京','北京','2002512345 2002512346',1212,0,0);
/*!40000 ALTER TABLE `transferdoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-06 11:39:01
