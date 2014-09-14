CREATE DATABASE  IF NOT EXISTS `dbestudohibernate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbestudohibernate`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: dbestudohibernate
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `automovel_opcional`
--

DROP TABLE IF EXISTS `automovel_opcional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `automovel_opcional` (
  `id_automovel` int(11) NOT NULL,
  `id_opcional` int(11) NOT NULL,
  KEY `FK_ikgwpci28fb1oq07wuoo4kthp` (`id_opcional`),
  KEY `FK_pwmonu64vh9cmx5pb211ns0nu` (`id_automovel`),
  CONSTRAINT `FK_ikgwpci28fb1oq07wuoo4kthp` FOREIGN KEY (`id_opcional`) REFERENCES `opcional` (`id`),
  CONSTRAINT `FK_pwmonu64vh9cmx5pb211ns0nu` FOREIGN KEY (`id_automovel`) REFERENCES `automovel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automovel_opcional`
--

LOCK TABLES `automovel_opcional` WRITE;
/*!40000 ALTER TABLE `automovel_opcional` DISABLE KEYS */;
INSERT INTO `automovel_opcional` VALUES (1,1);
/*!40000 ALTER TABLE `automovel_opcional` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-14  0:55:37
