-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: jobdb
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int DEFAULT NULL,
  `employer_id` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_apply_user_employer_idx` (`employer_id`),
  KEY `fk_apply_user_candidate_idx` (`candidate_id`),
  CONSTRAINT `fk_apply_user_candidate` FOREIGN KEY (`candidate_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_apply_user_employer` FOREIGN KEY (`employer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment_type`
--

DROP TABLE IF EXISTS `employment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employment_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment_type`
--

LOCK TABLES `employment_type` WRITE;
/*!40000 ALTER TABLE `employment_type` DISABLE KEYS */;
INSERT INTO `employment_type` VALUES (1,'intern'),(2,'fresher'),(3,'junior'),(4,'senior '),(5,'Thực tập sinh'),(6,'Thực tập sinh');
/*!40000 ALTER TABLE `employment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `faculty` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Information Technology'),(2,'Medicine'),(3,'Engineering'),(4,'Biology'),(5,'Economics'),(6,'Psychology'),(7,'Geography'),(9,'History');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employer_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `employment_type_id` int NOT NULL,
  `salary` int NOT NULL,
  `description` text,
  `company` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `emailcompany` varchar(100) NOT NULL,
  `otherinfomation` varchar(255) DEFAULT NULL,
  `date_posted` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fl_work_user_idx` (`employer_id`),
  KEY `fk_job_employment_type_idx` (`employment_type_id`),
  CONSTRAINT `fk_job_employment_type` FOREIGN KEY (`employment_type_id`) REFERENCES `employment_type` (`id`),
  CONSTRAINT `fk_work_user` FOREIGN KEY (`employer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,1,'a',1,5000000,NULL,'Cty TNHH chode','123 chuong cho','0123456987','chuongcho@123.com',NULL,'2023-09-05'),(2,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(3,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(4,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(5,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(6,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(7,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(8,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(9,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(10,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(11,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(12,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(13,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(14,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(15,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(16,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(17,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(18,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(19,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(20,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(21,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(22,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(23,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(24,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(25,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(26,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(27,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(28,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(29,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(30,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(31,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(32,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(33,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(34,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(35,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(36,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(37,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(38,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(39,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(40,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(41,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(42,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(43,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(44,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(45,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(46,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(47,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(48,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(49,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(50,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(51,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(52,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(53,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(54,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(55,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(56,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(57,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(58,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(59,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(60,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(61,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(62,2,'a,',1,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(63,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(64,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(65,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(66,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(67,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(68,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(69,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(70,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(71,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(72,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(73,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(74,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(75,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(76,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(77,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(78,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(79,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(80,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(81,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(82,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(83,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(84,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(85,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(86,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(87,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(88,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(89,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(90,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(91,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(92,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(93,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(94,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(95,2,'a,',2,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(96,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(97,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(98,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(99,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(100,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(101,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(102,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(103,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(104,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(105,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(106,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(107,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(108,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(109,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(110,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(111,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(112,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(113,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(114,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(115,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(116,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(117,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(118,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(119,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(120,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(121,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(122,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(123,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(124,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(125,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(126,2,'a,',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(127,2,'a,fffffvvvv',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(128,2,'a,fffffvvvv',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(129,2,'a,fffffvvvv',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(130,2,'a,fffffvvvv',3,5000000,NULL,'a','aaa','01100000','aaa0a0a0a0a',NULL,'2023-09-07'),(131,2,'Khang Nguyá»n',2,0,'a','ABC','svab','0856676838','nguyenmanhkhang2002@gmail.com','a','2023-09-09'),(132,2,'Khang Nguyá»n',3,0,'a','ABC','svab','0856676838','nguyenmanhkhang2002@gmail.com','a','2023-09-09'),(133,2,'Khang Nguyá»n',3,111,'a','ABC','svab','0856676838','nguyenmanhkhang2002@gmail.com','Ã¢aaa','2023-09-09');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permission` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'Add Job'),(2,'Delete Job'),(3,'Edit Job'),(4,'Edit Role'),(5,'Delete Role'),(6,'Add Role'),(7,'Delete User'),(8,'Change User Role');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `candidate_id` int NOT NULL,
  `employer_id` int NOT NULL,
  `star` int NOT NULL,
  `comment` text,
  PRIMARY KEY (`id`),
  KEY `fk_rating_student_idx` (`candidate_id`),
  KEY `fk_rating_employer_idx` (`employer_id`),
  CONSTRAINT `fk_rating_employer` FOREIGN KEY (`employer_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_rating_student` FOREIGN KEY (`candidate_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,3,2,1,'bad'),(2,3,2,1,'bad'),(3,3,2,1,'bad'),(4,3,2,1,'bad'),(5,3,2,1,'bad'),(6,3,2,1,'bad');
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_ADMIN'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`role_id`),
  KEY `id_idx1` (`permission_id`),
  CONSTRAINT `fk_rp_permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `fk_rp_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,2,1),(10,2,2),(11,2,3);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NOT NULL,
  `skill` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_skill_user_idx` (`userid`),
  CONSTRAINT `fk_skill_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `birth` date NOT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role_id` int DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  `faculty_id` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `filecv` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `curentposition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `education` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `country` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `urlinfo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`role_id`),
  KEY `fk_user_faculty_idx` (`faculty_id`),
  CONSTRAINT `fk_user_faculty` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Khang','Nguyễn','link','nguyenmanhkhang2002@gmail.com','0123456789','Nam','2002-02-02','Khang0202','012Khang012',1,NULL,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Khang','Nguyễn','link','aa@aa.aa','0123456','Nam','2002-02-02','Khang0101','0123456',3,NULL,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Khang','Nguyễn','link','aa@aa.aa','0123456','Nam','2002-02-02','Khang0101','0123456',2,NULL,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Nguyá»n','Khang',NULL,'asdf','0856676838','aaaa','2023-09-08','aaaaaaaaa','aaaaaaaaaaaaaaaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694185362/e8yjxbrjtflhvhqsqg9a.png','nguyenmanhkhang2002@gmail.com','0856676838','aaaa','2023-09-08','aaaaaaaaa','aaancass',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694185476/h9duayqgcw01nnzhdxry.png','nguyenmanhkhang2002@gmail.com','0856676838','aaa','2023-09-08','aaaaaa','aaaaaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694186261/ify3kcx1tdvgxqcd33u7.png','nguyenmanhkhang2002@gmail.com','0856676838','aaaa','2023-09-01','aaaaaa','aaaaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694187349/yswxcwonvlw6l9xvjt4t.png','nguyenmanhkhang2002@gmail.com','0856676838','aaaa','2023-09-01','aaa','aaaaaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694187967/ewjuywowjahjblrw0tau.png','nguyenmanhkhang2002@gmail.com','0856676838','aaa','2023-09-01','aaaaaaaaa','$2a$10$9pGJV8P6Xqjt9AYg7vGQpOZ1WkXkkvhnSCpHwL0OG/02KSm4nGorq',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694188780/ahqfzu4ofxaetkqwgayc.png','nguyenmanhkhang2002@gmail.com','0856676838','aaa','2023-09-01','aaaaaaaaa','$2a$10$ctPUl6nXcwR.kFxgO1wveuroswNW047L4aFIjHLMC3iSxlxfXS7nu',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694197369/alssqw7a4fsobvruon0n.png','nguyenmanhkhang2002@gmail.com','0856676838','aaaa','2023-09-01','aaaaaaaaa','$2a$10$QLCGO9BqVIDy1uJteHkdyuWm2mq8WfNk.vg.ii2D68iq0Gp6JKQzm',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694201739/cwfu0nnaq7trlmhpe5nl.png','nguyenmanhkhang2002@gmail.com','0856676838','Nam','2002-02-02','Khang012012','$2a$10$dhOxiSIoLMQSJ2lHF5O6K.SALtpWqz0.J2uXK4Zg02HRDrrfU/rlS',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694270447/pgbvvmq0j5zslotf3x6y.png','nguyenmanhkhang2002@gmail.com','0856676838','Nam','2023-09-01','Khang1234','123456',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694274992/od7pxsmjjrbkamptjmb9.png','nguyenmanhkhang2002@gmail.com','0856676838','aâ','2023-09-01','a','$2a$10$aV8PAIGIL6Z3xkmzyYyKbuGZ03ONvo4QT23eUjhoK/2pNoQRlvS8K',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'Nguyễn','Khang','https://res.cloudinary.com/dxxwcby8l/image/upload/v1694277619/wy6jpwvrrwylwsjiaxli.png','nguyenmanhkhang2002@gmail.com','0856676838','Nam','2023-09-01','abc','$2a$10$DF1tBj4dDe9vWaC7SXdzKuDPHmcps2xox/PcnJ7atgS.oRKh.IPLG',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-10  5:00:07
