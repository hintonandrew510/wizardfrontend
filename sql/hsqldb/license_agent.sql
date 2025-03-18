

--
-- Table structure for table `agent`
--

DROP TABLE agent;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE agent (
  agentid INTEGER IDENTITY PRIMARY KEY,
  password varchar(50) NOT NULL,
  contact_id int NOT NULL,
  address varchar(500) NOT NULL,
  googleprofile varchar(2000),
) 

