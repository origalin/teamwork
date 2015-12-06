-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: Lenovo-PC    Database: cmass
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
-- Table structure for table `gatheringdocpolist`
--

DROP TABLE IF EXISTS `gatheringdocpolist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gatheringdocpolist` (
  `收款单号` char(8) NOT NULL,
  `日期` date DEFAULT NULL,
  `钱` double DEFAULT NULL,
  `快递员` varchar(45) DEFAULT NULL,
  `寄件单编号列表` longtext,
  `收款账号` varchar(45) DEFAULT NULL,
  `是否被审批` varchar(45) DEFAULT 'false',
  PRIMARY KEY (`收款单号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gatheringdocpolist`
--

LOCK TABLES `gatheringdocpolist` WRITE;
/*!40000 ALTER TABLE `gatheringdocpolist` DISABLE KEYS */;
INSERT INTO `gatheringdocpolist` VALUES ('12000001','2015-12-02',600,'刘备','0002113584,0002113585','zhangjian','false'),('12000002','2015-12-03',500,'关羽','1002584793','linqing','false'),('12000003','2015-12-04',770,'张飞','2001084736,2001084737,2001084738','lingpeitang','false');
/*!40000 ALTER TABLE `gatheringdocpolist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-06 10:53:57
