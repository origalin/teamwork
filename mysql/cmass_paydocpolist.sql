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
-- Table structure for table `paydocpolist`
--

DROP TABLE IF EXISTS `paydocpolist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paydocpolist` (
  `付款单号` char(8) NOT NULL,
  `日期` date NOT NULL,
  `钱` double DEFAULT NULL,
  `付款人` varchar(45) DEFAULT NULL,
  `付款账号` varchar(45) DEFAULT NULL,
  `付款类型` varchar(45) DEFAULT NULL,
  `备注` varchar(45) DEFAULT NULL,
  `是否被审批` varchar(45) DEFAULT 'false',
  PRIMARY KEY (`付款单号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paydocpolist`
--

LOCK TABLES `paydocpolist` WRITE;
/*!40000 ALTER TABLE `paydocpolist` DISABLE KEYS */;
INSERT INTO `paydocpolist` VALUES ('11000001','2015-12-02',500,'Michael Jackson','lizhimu','租金','南京市中转中心0250租金','false'),('11000002','2015-12-03',100,'Michael Jordan','linqing','运费','车辆代号为为0025000010，从南京运往上海的运费','false'),('11000003','2015-12-04',600,'刘钦','zhangjian','工资','快递员丁二玉的工资','false');
/*!40000 ALTER TABLE `paydocpolist` ENABLE KEYS */;
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
