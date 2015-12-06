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
-- Table structure for table `senddoc`
--

DROP TABLE IF EXISTS `senddoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `senddoc` (
  `id` char(45) NOT NULL,
  `date` date DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `sumprice` double DEFAULT NULL,
  `sname` char(45) DEFAULT NULL,
  `scity` char(45) DEFAULT NULL,
  `saddress` text,
  `sunit` char(45) DEFAULT NULL,
  `stelephone` char(45) DEFAULT NULL,
  `smobilephong` char(45) DEFAULT NULL,
  `rname` char(45) DEFAULT NULL,
  `rcity` char(45) DEFAULT NULL,
  `raddress` text,
  `runit` char(45) DEFAULT NULL,
  `rtelephone` char(45) DEFAULT NULL,
  `rmobilephone` char(45) DEFAULT NULL,
  `itemnum` int(11) DEFAULT NULL,
  `packagetype` int(11) DEFAULT NULL,
  `courier_type` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `wideth` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `item_type` char(45) DEFAULT NULL,
  `checked` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储所有的寄件单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `senddoc`
--

LOCK TABLES `senddoc` WRITE;
/*!40000 ALTER TABLE `senddoc` DISABLE KEYS */;
INSERT INTO `senddoc` VALUES ('2002512345','2015-11-23',2,12,'李雷','南京','仙林大道南128号','南京大学','12312321234','12312321234','张伟','北京','中山路121号','北京大学','17623454567','17623454567',1,1,2,23.1,1,2.2,0.9,'默认',0);
/*!40000 ALTER TABLE `senddoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-06 11:39:03
