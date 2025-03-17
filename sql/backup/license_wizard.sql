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
-- Table structure for table `wizard`
--

DROP TABLE IF EXISTS `wizard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wizard` (
  `wizardid` int NOT NULL AUTO_INCREMENT,
  `agentid` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `encrypt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`wizardid`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wizard`
--

LOCK TABLES `wizard` WRITE;
/*!40000 ALTER TABLE `wizard` DISABLE KEYS */;
INSERT INTO `wizard` VALUES (1,3,'test',NULL),(2,4,'test','cOH6ZVGH26QP/jR3KcUOVA=='),(3,4,'Test Wizard','jJNLMI/+ClgZ1krsPtqHlg=='),(4,4,'Test','GLhtgyfawBNmiV/BNu95aA=='),(5,4,'Test Wizard','oaMjHhcQJ0yBRF4Xcsdmxw=='),(6,4,'Test','WR2hN0yztXmFLp4efVUKxA=='),(7,4,'Premium Auto Centers 7-19-19','OGrfdUYel9Mh3GJr4Hm9BQ=='),(8,4,'Premium Auto Centers 8-12-19','MMIN9m2K4ASw4bQsmnyJxA=='),(9,4,'Test Wizard 8-15-19','Dqe3lw7wn4vk8/18xotiGA=='),(10,4,'TinaTest09','edMESGHv4Y/P8ltv6HWTwQ=='),(11,4,'Test Wizard 8-23-19','FKIl3MjULJsbt//A3D786w=='),(12,4,'Test Wizard 9-4-19','aHTNSI9UxxRkzgZAs9joGA=='),(13,4,'Test Wizard 9-5-19','O6Ghr8+L7xNQvHvOCOUURw=='),(14,4,'zzz','mPlLdzoHYp1LkpA5idd47A=='),(16,4,'Test Wizard 9-20-19','jVcHtMrFtjRrECY06hccKw=='),(17,4,'Test Wizard 9-24-19','xBso90M3nEdP2/iZ3PLJag=='),(18,4,'test 27 Sept. 2019','FPhSvsKsRPlHP0WYRyuHiw=='),(19,4,'Test Wizard 9-27-19','SA3TA9A4VvcK974S0L4QQg=='),(20,4,'Test Wizard 10-7-19','WnBUh9Bw+890lO37oQ+5cQ=='),(21,4,'Test Wizard 10-28-19','0yewzKC8ChlU0b4RwbOW2w=='),(22,4,'Test Wizard 11-23-19','bE5xLKB6/41xd+igJRJmCg=='),(23,4,'Test Wizard - Library 11-23-19','jmXzADdketOAYAgsSh9EIg=='),(24,4,'Test Wizard 12-7-19','i6oIrimw9Y73+uZL1aDQFA=='),(25,4,'Test Wizard 12-9-19','k4/ll7kxdkzq4lA8glR8Pw=='),(26,4,'Example Wizard - Demo 12-11-19 Numb','6HsBuc+zx+bLpm+ebiU3kw=='),(27,4,'Test Wizard 12-21-19','eWjLvo4gRH42EAYBdOQcyA=='),(28,4,'Test Wizard 1-10-20','Xe0z1G0bkuiuNnD3J5jPcw=='),(29,4,'TEST WIZARD 2 - 1/10/20','UdXIchXsOkCu1spu9fV4Lw=='),(30,4,'test','y08ZUwmnQrvD34/mO/NEIA=='),(31,4,'rrr','0sIDkTPOC4N84BUyXFhg4g=='),(32,4,'radio','b1AEt4QfHNCI8LOu9YRZ5w=='),(33,4,'Test Wizard 2-18-20','3p5GkfQesCvaBaSt39JrsA=='),(34,4,'Test Wizard 3-2-20','BvRDVtEMERScIUe69EdUsQ=='),(35,4,'Test Wizard 3-14-20','EkjVRK62M/PJyUkak6cHBQ=='),(36,4,'Partial Test 3-27-20','hGDy2jUjx80MoG52a4tQUQ=='),(37,4,'AAA Test Wizard 5-18-20','SzPx0k0wsCxqaC2Wqg0dDw=='),(38,4,'Test Wizard 6-3-20','Q/rXzAcn8rWsn7Cy5VDoJA=='),(39,4,'Test Wizard 6-9-20','S+yoANtww8b77ieaUHo8HA=='),(40,4,'Partial Wizard Test - 6-9-20','83Qmxi08oy9epu0KLHBRyg=='),(41,4,'Test Wizard - 6-15-20','IcXLKQ2cZz2zP9q+cOzzYQ=='),(42,4,'Test Wizard 6-24-20','o8Y6AmY11NOLhgvNseyN0g=='),(43,4,'Partial Test - 6-25-20','unRzq9F498+aTGcFg+n5Nw=='),(44,4,'Partial Test - 6-26-20','dAEyiVK0KWcJGHOYcI0Olw=='),(45,4,'Partial Test 6-26 2','8bHEHrTxtxhM1q3qsSCaUQ=='),(46,4,'Partial Test 6-26 2','fpy5ya4FE9D03qLAyRNQOg=='),(47,4,'newone','byOnKlkAJG/+m2ISv/52lw=='),(48,4,'Test Wizard 7/24/20','xTAoORZRyGG7uViHMFgjFg=='),(49,4,'Test Wizard 8/3/20','lob459oq7mAmuPSPAjzaDg=='),(50,4,'Test ','4CzirwWkka+fWn8TiOWQDA=='),(51,4,'Partial Test 8/4/20','WpGJsuseJwhjrUrOU+DyBw=='),(52,4,'Partial Test 8/4/20','XwR7e3jiZ4AGxb2rLBxn+g=='),(53,4,'Partial Test 8/4/20','k7TUJaN8Fe7Irvlmyw+TJg=='),(54,4,'Smiley\'s - 2020 - 2021 Marketing Plan ','LE7FkVh/WYbnNnaBVOdKWw=='),(55,110,'Test Laura Wizard','hCCqVYl2IBYUarf2qlusaQ=='),(56,4,'Test Wizard 8-17-20','EOqGDgQX124XdfXM5A6zUw=='),(57,114,'Spencer Test Wizard 8/23/20 ','bguJTxWSwHUxULtXhYpYig=='),(58,4,'Victoria Q','z6tKG9nIHHE4FHaPBhn8iw=='),(59,4,'Test Wizard 8-30-20','8Gd2nmkuDYfw+WERpw7neQ=='),(60,4,'dddddd','6I+6Yhwu/Xb+yf8V+a8cdw=='),(61,4,'Gwen Hinton1','JvhWkgjBPfqpuD416q68Lg=='),(62,4,'Test Wizard 9/2/20','/3W2QUIaVB3BB6AuzM7MFg=='),(63,4,'aaadfafadfad','EgTwoYJwQII7rnoFdZsTBg=='),(64,4,'Test Wizard 9/5/20','heiLGOORIXkRDGpA7Cnggw=='),(65,4,'Test Wizard 9/5/20 New Agent ','f17kX8r+N8iA+nN/RVrVJw=='),(66,4,'Test Wizard 9/5/20 New Agent 2 ','eag1IaCGpqt573bjtYISBA=='),(67,4,'zzzz','fy0HnrbrhEJIxRLMJ3GooA=='),(68,4,'eeweweqe','YOAPp3M7SnC4DylLBUxQUw=='),(69,4,'Test Wizard 9/9/20','msiJ30OQJUg9WmhrMQdX1g=='),(70,137,'Big Seller Wizard - Spencer staff','d1qosxUqyESvMpfv17rnRw=='),(71,138,'Test Laura Wizard 2','akfChIAljjgxGBSHyNPOvw=='),(72,138,'Rocky SCR','JG/j1OGDgU3OvcqLLS0wdg=='),(73,140,'Rocky SCR1','NzDKjjSWnlJ6BOucnm093g=='),(74,147,'Test Wizard Taylor 9-12-20','Uhw1riHJ+6Yw1UqTVsvDQw=='),(75,137,'Test Wizard Big Seller 9-12-20','pdNBoeAG+Un43TH75E9J3A=='),(77,4,'Test Wizard 9-13-20','BSLShz7mmI1/BqtsdiNb6Q=='),(78,4,'Test Wizard 9/13/20','r9h56y2njrMcUR/DDWWpCw=='),(79,148,'media matters','Vj8kZ2gsckFzzN0ZeMxDGg=='),(80,153,'Test Wizard 9-18-20 - 2','kA/Vc8JOD9gzuxur6+zYcw=='),(81,102,'Test Wizard 9/18/20 - Justin under Michael ','xNmHcKL94lmROBnWw3tPBg=='),(82,1,'Full Test Wizard - Radio 9/20/20','f3+cVcDD90Pf4FqNz6/6tA=='),(83,4,'copyOf_aaa','ELy4LdJpn4kHI8oFwCvhfw=='),(84,137,'Full Test Wizard - Television 9/20/20','mmXHJykjndU7VaM7+WSSqw=='),(85,157,'Chassidy Nicole Hinton1','WS2j05oMZ+O0sWLOvC0uyw=='),(86,137,'Andrew','3BgDA7q8UW6Pj1wyNvE3MA=='),(87,161,'rrr','MPUKON62S+ZGcmfoLjFy5g=='),(88,137,'alex','4r9E7vtg6Ku5CzYKBs9tfw=='),(89,137,'rrr','1X+4EKc6L266c34AWaqTqA=='),(90,137,'Full TV Test Wizard - 10/1/20','aExtmZs6wRvctyWqWq821w=='),(91,137,'Partial Test Wizard 10-2-20','M+ueKuzfAZwRsMWBGRVS6A=='),(92,137,'Partial Test Wizard 10-2-20',NULL),(93,137,'Partial Test Wizard 10-2-20','RIO8tELmfkeEoc6c9HHcQA=='),(94,138,'Partial Test Wizard 10-2-20','5JrmDE3mrVR042XQ5F0Qpw=='),(95,138,'Partial test wizard 2 - 10-2-20','JcE3SwBphtgUqDjmu/WZ/w=='),(96,138,'New Wizard ','/Nx7R3NDqxiGY12afjeRUA=='),(98,137,'Partial Test Wizard 10-6-20',NULL),(99,137,'Full TV Test Wizard - 10/6/20',NULL),(100,102,'Partial Test Wizard 10-10-20','KJg9QfScbcRg3pcRS+xyLg=='),(101,177,'PJ\'s Men\'swear','pBFNRevMdg4tn7kzKYVHgQ=='),(102,177,'PJ\'s Men\'swear','IXN9wFuUOgzOVhHFpfy5pw=='),(103,174,'Test Wizard - Philip ','FLZ1s3p33oHUbqO+R2ybiw=='),(108,137,'Partial Test Wizard 10-25-20','S7YY5CEYkKBQYhNsAi7z+w=='),(109,174,'Partial scr 10/30/20','LhslpvA2elx0wYrh5qew5w=='),(110,137,'partial SCR 2 - 10/30/20','O6MZ3Iu5osFPv+7W94fmUQ=='),(111,4,'gwenhinton','hP8gY5s9ExvG2kzK1A+XeA=='),(112,4,'dddasdfas','OrwN3IQ3GbXwSwy5LGhTgA=='),(113,102,'Test Wizard 1-26-21','4O8kcg1FJDBGczSjRtSn8w=='),(114,102,'Test Wizard 1-26-21','EflmwhiSS0t7BseB7phzvQ=='),(115,102,'Test Wizard 5-25-21','tu/KmkLscfoTXzv4ZgwtdA=='),(116,221,'Test Wizard 10-9-21','mPPVwPTaKM/lhHcKEWP4wg=='),(117,221,'Smiley\'s 2021 - 2022 Marketing Plan ','q5x3MjtMrg1N5LbN5WQ2Hw=='),(118,221,'Template ','xfHwuw6U4w+aDmrdb+Aqdg=='),(119,221,'Template','L5eEdUspNf4xZ/Mu+ILQCQ=='),(120,236,'Test Wizard 2-11-21','uGYHDINcHb8C7VSbykoN0Q=='),(121,146,'Test 2-25-22','6Pzjfr+hfRZoUuzkYRh8TA=='),(122,221,'Test Wizard 5-21-22','vdHnay5HdSC/W8hi1War4g=='),(123,256,'martin','gVlOkmLkq91ZSUBxgyVA1g=='),(124,256,'aa','Phf76gygLQ6c86frdL8dEw=='),(125,259,'Test','Oo+lwTDJH4tLCqRSn3uTsg=='),(126,264,'Test 10-7-22','Bud6OLzcY6LC4mco+r5r/g=='),(127,256,'Test 10-7-22','GEsYCnu7HIY781RuJfioYg=='),(128,307,'Test Wizard 8-31-23','hIYLJ3MRhIJuhPvl7yJXqA=='),(129,307,'Premium Auto Centers - Test Wizard 9-1-23','8mqV6pcVx4rbHvkM/Ds2CA=='),(130,307,'Test Wizard 10-25-23','H6LdqOcuAPqk6I+7oju2Og=='),(131,307,'Test Cloud Wizard 11-30-23','ELVKtS2URlW0nK2HV9y5cg=='),(132,307,'Test Wizard 1-19-24','U5ROkZWscF7tPY+F83Nc0Q=='),(133,307,'Test Wizard 5-12-24','/O7Ol/5WS5S6ir4on3oXyg==');
/*!40000 ALTER TABLE `wizard` ENABLE KEYS */;
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

-- Dump completed on 2025-03-17  9:04:36
