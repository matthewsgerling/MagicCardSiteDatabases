-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: magiccards
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card_holder`
--

DROP TABLE IF EXISTS `card_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `card_holder` (
  `card_holder_id` int(11) NOT NULL AUTO_INCREMENT,
  `holder_name` varchar(30) NOT NULL,
  PRIMARY KEY (`card_holder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_holder`
--

LOCK TABLES `card_holder` WRITE;
/*!40000 ALTER TABLE `card_holder` DISABLE KEYS */;
INSERT INTO `card_holder` VALUES (1,'Bill'),(2,'Bill'),(3,'Bill'),(4,'Bill'),(5,'Test'),(6,'Matthew Gerling'),(7,'Eric Gerling');
/*!40000 ALTER TABLE `card_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_stats`
--

DROP TABLE IF EXISTS `card_stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `card_stats` (
  `card_type` varchar(20) NOT NULL,
  `card_name` varchar(45) NOT NULL,
  `mana_cost` int(11) NOT NULL,
  `card_stats_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`card_stats_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_stats`
--

LOCK TABLES `card_stats` WRITE;
/*!40000 ALTER TABLE `card_stats` DISABLE KEYS */;
INSERT INTO `card_stats` VALUES ('Creature','Wall Of Mist',2,28),('Creature','Onakke Ogre',3,29),('Basic Land','Forest',0,30);
/*!40000 ALTER TABLE `card_stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deck_details`
--

DROP TABLE IF EXISTS `deck_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `deck_details` (
  `deck_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `deck_name` varchar(30) NOT NULL,
  `deck_created` date NOT NULL,
  `card_holder_id` int(11) NOT NULL,
  PRIMARY KEY (`deck_details_id`),
  KEY `deck_details_ibfk_1` (`card_holder_id`),
  CONSTRAINT `deck_details_ibfk_1` FOREIGN KEY (`card_holder_id`) REFERENCES `card_holder` (`card_holder_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deck_details`
--

LOCK TABLES `deck_details` WRITE;
/*!40000 ALTER TABLE `deck_details` DISABLE KEYS */;
INSERT INTO `deck_details` VALUES (3,'Matts Deck','2019-02-20',6),(4,'another test','2019-10-10',7);
/*!40000 ALTER TABLE `deck_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_of_cards`
--

DROP TABLE IF EXISTS `list_of_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `list_of_cards` (
  `list_of_cards_id` int(11) NOT NULL AUTO_INCREMENT,
  `deck_details_id` int(11) NOT NULL,
  `card_stats_id` int(11) NOT NULL,
  PRIMARY KEY (`list_of_cards_id`),
  KEY `list_of_cards_ibfk_2` (`deck_details_id`),
  KEY `list_of_cards_ibfk_1_idx` (`card_stats_id`),
  CONSTRAINT `list_of_cards_ibfk_1` FOREIGN KEY (`card_stats_id`) REFERENCES `card_stats` (`card_stats_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `list_of_cards_ibfk_2` FOREIGN KEY (`deck_details_id`) REFERENCES `deck_details` (`deck_details_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_of_cards`
--

LOCK TABLES `list_of_cards` WRITE;
/*!40000 ALTER TABLE `list_of_cards` DISABLE KEYS */;
INSERT INTO `list_of_cards` VALUES (1,3,28),(2,3,29),(3,4,29),(4,4,30),(5,3,30);
/*!40000 ALTER TABLE `list_of_cards` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-20 14:16:36
