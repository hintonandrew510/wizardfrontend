
DROP TABLE wizarddata;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE wizarddata (
  wizarddataid INTEGER IDENTITY PRIMARY KEY,
  pagedata LONGVARCHAR NOT NULL,
  wizardid int NOT NULL,
  pagename varchar(50) NOT NULL,
  pagesequence int NOT NULL,
  excluded tinyint,
  
)