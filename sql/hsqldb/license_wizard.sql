
DROP TABLE wizard;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE wizard (
  wizardid INTEGER IDENTITY PRIMARY KEY,
  agentid int NOT NULL,
 name varchar(255) NOT NULL,
  encrypt varchar(45) DEFAULT NULL,

) 