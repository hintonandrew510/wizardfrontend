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
-- Table structure for table `contact`
--

DROP TABLE contact;
 
CREATE TABLE contact (
  contact_id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(250) not null,
  uuid  VARCHAR(250) not null,
  license  VARCHAR(3000) not null,
  general_information varchar(3000) NOT NULL,
  phone varchar(250) DEFAULT NULL,
  usage_date datetime DEFAULT NULL,
  created_date datetime NOT NULL,
  start_date timestamp DEFAULT NULL,
  end_date datetime NOT NULL,
  address varchar(250) NOT NULL,
  active tinyint DEFAULT NULL,
  client_type varchar(45) NOT NULL,
  streetaddress varchar(250) NOT NULL,
  city varchar(250) NOT NULL,
  state varchar(250) NOT NULL,
  zipcode varchar(250) NOT NULL,
  emailaddress varchar(250) DEFAULT NULL,
  password varchar(50) NOT NULL,
    
);


