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
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `agentid` int NOT NULL AUTO_INCREMENT,
  `password` varchar(50) NOT NULL,
  `contact_id` int NOT NULL,
  `address` varchar(500) NOT NULL,
  `googleprofile` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`agentid`),
  UNIQUE KEY `address` (`address`),
  UNIQUE KEY `address_2` (`address`),
  UNIQUE KEY `address_3` (`address`),
  UNIQUE KEY `address_4` (`address`),
  UNIQUE KEY `address_5` (`address`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'ddd',-888,'a2ao@aol.com',NULL),(2,'dddd',-888,'chassidy.hinton@gmail.com',NULL),(4,'t',-888,'test@aol.com','{\"slidesId\":\"1sJhbrWXIsdXss5wPBSbrR1Mq2yq5avksOY38BD0URPE\",\"sheetsId\":\"1qPdtsSRtfkZTX-q1d0TXAvRB34VHhB38wlEANyAiVSA\",\"generatedFolderId\":\"1iNlhQp5AaRb2hJ2hz5V9mYN2C4YxgWVz\",\"targetMarketingWant26to35ToWant36to45\":\"gaa4a52d53f_0_10\",\"targetMarketingWant36to45ToWant46to55\":\"gaa4a52d53f_0_105\",\"targetMarketingWant46to55ToWant55Plus\":\"gaa4a52d53f_0_130\",\"targetMarketingWant19to25ToWant26to35\":\"gaa4a52d53f_0_55\",\"targetMarketingWant12to18ToWant19to25\":\"gaa4a52d53f_0_80\"}'),(101,'Waterbottle1235',4,'justin@modloutdoor.com1',NULL),(102,'Waterbottle123',4,'justin@modloutdoor.com','{\"slidesId\":\"1TBwQUfm94nu-VutRIdmoqvF2RyAlDPPfa7N1HEJsn-4\",\"sheetsId\":\"1x1j7_aECkbQiRRr04bVbOkXcE_d0JFkkTUBGwATlGbc\",\"generatedFolderId\":\"16Wrn_99Hzrn8gR5AWo9J4j9S4BrDzomw\",\"targetMarketingWant26to35ToWant36to45\":\"gaa4a52d53f_0_10\",\"targetMarketingWant36to45ToWant46to55\":\"gaa4a52d53f_0_105\",\"targetMarketingWant46to55ToWant55Plus\":\"gaa4a52d53f_0_130\",\"targetMarketingWant19to25ToWant26to35\":\"gaa4a52d53f_0_55\",\"targetMarketingWant12to18ToWant19to25\":\"gaa4a52d53f_0_80\"}'),(103,'Facemask123',4,'stephanie@forthefeel.com',NULL),(104,'Waterbottle1236',4,'justin@modloutdoor.com2',NULL),(107,'rr',31,'aahinton@waketech.edu',NULL),(108,'1',31,'andrew.hinton@ncsecu.org',NULL),(110,'Realestate',-888,'TriangleHomeswithLaura@gmail.com',NULL),(113,'Denver123',4,'taylor.bookstaff@gmail.com',NULL),(114,'Jags#1',4,'spencer.guld@guldresource.com',NULL),(129,'Dude',43,'ggrant@mainline.com',NULL),(130,'bball',43,'wc@mainline.com',NULL),(137,'Topproducer',42,'bigseller@wwww.com',NULL),(138,'Sold',42,'lauracpeed1@gmail.com',NULL),(139,'Sold',42,'lauracpeed@gmail.com',NULL),(140,'Dog',44,'rocky@wabc.com',NULL),(141,'Jdog',44,'jguld@wabc.com',NULL),(142,'Skittles123',44,'natalie.guld@guldresource.com',NULL),(146,'t',41,'test1@aol.com',NULL),(147,'JGirlfriend',42,'tbookstaff@wabc.com',NULL),(148,'heheh',31,'triplem.q@gmail.com',NULL),(152,'Sustainable',45,'swagner@guldresource.com',NULL),(153,'doc',45,'maxdoc@evms.com',NULL),(174,'1234',46,'drphilipjay@comcast.net',NULL),(177,'1234',8,'drphilipjay@gmail.com',NULL),(221,'Child1',47,'spencerJ.guld@guldresource.com','{\"slidesId\":\"1ZgAltwfGmxfODLm8ONoiFYGf3-JXiAtUj_ipqhF_bs0\",\"sheetsId\":\"18FrvQKa93Fy_ey6yeY7hB3yD9wVb8jbf74xIp5dgb8A\",\"generatedFolderId\":\"16Wrn_99Hzrn8gR5AWo9J4j9S4BrDzomw\",\"targetMarketingWant26to35ToWant36to45\":\"gaa4a52d53f_0_10\",\"targetMarketingWant36to45ToWant46to55\":\"gaa4a52d53f_0_105\",\"targetMarketingWant46to55ToWant55Plus\":\"gaa4a52d53f_0_130\",\"targetMarketingWant19to25ToWant26to35\":\"gaa4a52d53f_0_55\",\"targetMarketingWant12to18ToWant19to25\":\"gaa4a52d53f_0_80\"}'),(222,'Child2',47,'StephanieE.guld@guldresource.com',NULL),(223,'Child3',47,'JustinH.guld@guldresource.com',NULL),(236,'Superstar',4,'tdendy@abc57.com',NULL),(255,'Topmanager',33,'dscutari@gmail.com',NULL),(256,'Tiger',37,'JonathanRivers287@gmail.com','{\"slidesId\":\"1YMMa_ZEE4RftErraBiDKNfpAFn1X-nqr2gMrmsyhH4k\",\"sheetsId\":\"1KUnnhoGAjSr2jKgaPJk9jmhG2ZcV8nn7Dni4OmJ-zqM\",\"generatedFolderId\":\"1vXtFUzGX5MqfCHtEqdJKsoHVbRUSILX2?ths\\u003dtrue\",\"targetMarketingWant26to35ToWant36to45\":\"gaa4a52d53f_0_10\",\"targetMarketingWant36to45ToWant46to55\":\"gaa4a52d53f_0_105\",\"targetMarketingWant46to55ToWant55Plus\":\"gaa4a52d53f_0_130\",\"targetMarketingWant19to25ToWant26to35\":\"gaa4a52d53f_0_55\",\"targetMarketingWant12to18ToWant19to25\":\"gaa4a52d53f_0_80\"}'),(259,'1234',37,'cs82mail@gmail.com','{\"slidesId\":\"1qZwecwheGe4AS-d2c8LhcAzB0QUfSRMsD-HXRAoMwxU\",\"sheetsId\":\"1rrOGnX3JDjItVQciXS4YrjEes_IrzjqE5zQZkaCmbcs\",\"generatedFolderId\":\"1rTKVnIIWcGobTJ0W0DLkdautTNRIZFEf\",\"targetMarketingWant26to35ToWant36to45\":\"gaa4a52d53f_0_10\",\"targetMarketingWant36to45ToWant46to55\":\"gaa4a52d53f_0_105\",\"targetMarketingWant46to55ToWant55Plus\":\"gaa4a52d53f_0_130\",\"targetMarketingWant19to25ToWant26to35\":\"gaa4a52d53f_0_55\",\"targetMarketingWant12to18ToWant19to25\":\"gaa4a52d53f_0_80\"}'),(264,'Superstar',37,'Jonathan.Rivers@wxtx.com',NULL),(273,'1234',37,'christopher.scott@wtvm.com',NULL),(305,'z',-777,'z@aol.com',NULL),(306,'1234',52,'lsands@dbcradio.com',NULL),(307,'1sdlwbnc',32,'brichardson@wwaytv3.com','{\"slidesId\":\"1sJhbrWXIsdXss5wPBSbrR1Mq2yq5avksOY38BD0URPE\",\"sheetsId\":\"1qPdtsSRtfkZTX-q1d0TXAvRB34VHhB38wlEANyAiVSA\",\"generatedFolderId\":\"1iNlhQp5AaRb2hJ2hz5V9mYN2C4YxgWVz\",\"targetMarketingWant26to35ToWant36to45\":\"gaa4a52d53f_0_10\",\"targetMarketingWant36to45ToWant46to55\":\"gaa4a52d53f_0_105\",\"targetMarketingWant46to55ToWant55Plus\":\"gaa4a52d53f_0_130\",\"targetMarketingWant19to25ToWant26to35\":\"gaa4a52d53f_0_55\",\"targetMarketingWant12to18ToWant19to25\":\"gaa4a52d53f_0_80\"}');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
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

-- Dump completed on 2025-03-17  9:04:37
