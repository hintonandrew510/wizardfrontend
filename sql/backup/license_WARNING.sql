-- MySQL dump 10.13  Distrib 8.0.41, for macos15 (x86_64)
--
-- Host: db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com    Database: license
-- ------------------------------------------------------
-- Server version	8.0.30

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '4c2d3e3a-1f56-11ee-8cd6-8ebb36f9406e:1-110,
5a6b6274-9b52-11ed-aaf7-f61d73e9f38c:1-38,
6762b270-89ec-11ed-900a-d2ce8660d259:1-117,
86249c48-b3da-11ee-abf9-46e0eaa417b5:1-49,
89e5d8e5-84e0-11ef-9c94-dab5dfb916a7:1-22,
9784ed32-e7e3-11ef-af6b-d2068a92e569:1-16,
baab35d6-fe18-11ef-b37f-b6245952df85:1-15,
f141ed60-00dc-11ef-9d8d-4a35da1f47cc:1-46';

--
-- Table structure for table `WARNING`
--

DROP TABLE IF EXISTS `WARNING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WARNING` (
  `id` int NOT NULL,
  `warning` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `Bitcoin_Address` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `Email` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WARNING`
--

LOCK TABLES `WARNING` WRITE;
/*!40000 ALTER TABLE `WARNING` DISABLE KEYS */;
INSERT INTO `WARNING` VALUES (1,'To recover your lost Database and avoid leaking it: Send us 0.1 Bitcoin (BTC) to our Bitcoin address 16wssaUQ1thukJvwV9YRBKzxzy18n47dY8 and contact us by Email with your Server IP or Domain name and a Proof of Payment. If you are unsure if we have your data, contact us and we will send you a proof. Your Database is downloaded and backed up on our servers. Backups that we have right now: license, PLEASE_READ_ME_XBG, andrew, PLEASE_READ_ME_FFF, PLEASE_READ_ME_FXF, PLEASE_READ_ME_XXS, PLEASE_READ_ME_ZYX . If we dont receive your payment in the next 10 Days, we will make your database public or use them otherwise.','16wssaUQ1thukJvwV9YRBKzxzy18n47dY8','contact@mydatabase.to');
/*!40000 ALTER TABLE `WARNING` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-17  9:04:35
