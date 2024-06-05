-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ebs_final
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin1','6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b'),(2,'admin6','e7f6c011776e8db7cd330b54174fd76f7d0216b612387a5ffcfb81e6f0919683'),(3,'admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `meter_no` int NOT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `units` varchar(20) DEFAULT NULL,
  `totalbill` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`,`meter_no`),
  KEY `meter_no` (`meter_no`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`meter_no`) REFERENCES `customer` (`meter_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,19574328,1,2024,'80',282000,'đã thanh toán','2024-05-29'),(2,19574328,2,2024,'90',320000,'chưa thanh toán',NULL),(3,19574328,3,2024,'95',433680,'chưa thanh toán',NULL),(4,19886208,1,2024,'95',334500,'chưa thanh toán',NULL),(5,19886208,4,2024,'95',478000,'chưa thanh toán',NULL),(6,19886208,2,2024,'95',337500,'chưa thanh toán',NULL),(7,19886208,3,2024,'95',433680,'chưa thanh toán',NULL),(8,19008055,1,2024,'75',264500,'chưa thanh toán',NULL),(9,19008055,2,2024,'76',271000,'chưa thanh toán',NULL),(10,19008055,3,2024,'76',348180,'chưa thanh toán',NULL),(11,19008055,4,2024,'76',383000,'chưa thanh toán',NULL),(12,19081653,1,2024,'88',310000,'chưa thanh toán',NULL),(13,19081653,2,2024,'88',313000,'chưa thanh toán',NULL),(14,19081653,3,2024,'88',402180,'chưa thanh toán',NULL),(15,19081653,4,2024,'88',443000,'chưa thanh toán',NULL),(16,19384101,1,2024,'120',422000,'đã thanh toán','2024-05-30'),(17,19775546,1,2024,'134',471000,'đã thanh toán','2024-05-30'),(18,19025429,1,2024,'541',1895500,'đã thanh toán','2024-05-30'),(19,19500505,1,2024,'214',751000,'đã thanh toán','2024-05-30'),(20,19384101,2,2024,'214',754000,'đã thanh toán','2024-05-30'),(21,19775546,2,2024,'214',754000,'chưa thanh toán',NULL),(22,19500505,2,2024,'214',754000,'chưa thanh toán',NULL),(23,19686140,1,2024,'93',1339320,'đã thanh toán','2024-05-31'),(24,19769257,1,2024,'96',1382520,'chưa thanh toán',NULL);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `meter_no` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`meter_no`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19903298 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (19008055,2,'Nguyen Hong Linh','47 Cong Hoa','linh47@gmail.com','754-956-133'),(19025429,1,'Huynh Lap','856 Dien Bien Phu','laphuynh@gmail.com','232-577-789'),(19081653,2,'Nguyen Truc Ly','90 Truong Van Thanh','lyly@gmail.com','785-909-312'),(19384101,1,'Nguyen Thi Nhu Y','45 Tan Lap','nhuy45@gmail.com','432-877-123'),(19500505,1,'Tran Thanh','234 Dong Khoi','tahnh@gmail.com','877-332-688'),(19574328,2,'Nguyen Huu Tin','448 Le Van Viet ','huutin@gmail.com','123-456-890'),(19686140,5,'cus1','cus1','cus1','cus1'),(19769257,5,'A Kha','SG','akha123@gmail.com','096851472'),(19775546,1,'Nguyen Ngoc Tram','123 Vo Thi Sau','tram6@gmail.com','564-675-088'),(19886208,2,'Truong Chi Nhan','56 CMT8','chinhan@gmail.com','097-773-324'),(19903297,1,'Nguyễn Thị Lan','50 HCM','lan@gmail.com','0104959156');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit_price` float NOT NULL,
  `service_charge` float NOT NULL,
  `service_tax` float NOT NULL,
  `fixed_tax` float NOT NULL,
  `month` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
INSERT INTO `tax` VALUES (1,12000,1000,0.1,0.2,1,2024),(2,3500,25000,0.2,0.1,2,2024),(3,4500,20600,0.3,0.3,3,2024),(4,5000,30000,0.1,0.4,4,2024),(5,3000,30200,0.2,0.1,5,2024),(6,4300,30900,0.3,0.2,6,2024),(8,4300,21000,0.4,0.3,7,2024),(9,5300,11000,0.1,0.6,8,2024),(10,4300,13000,0.15,0.7,9,2024),(11,4300,65000,0.25,0.15,10,2024),(12,4300,55000,0.2,0.23,11,2024),(13,4300,65000,0.3,0.31,12,2024);
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1','dat','6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b'),(2,'user2','Pham Thanh Phuc','da84be0866eaf0fb0dc3540a84af7aa42d4e0375404807c6d1b9fba8bac2de57'),(3,'use3','Phan Van Tri','9ac4c53ed8ea5864bb1d12113404efe77382a21d649e231dc8dcabaac2609dad'),(4,'user4','Nguyen Van Troi','5b78632da15c2aeab4dcb4729c73e75a884963615d04cb3c3eb31d988920a245'),(5,'user','user','04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');
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

-- Dump completed on 2024-06-05  9:47:55
