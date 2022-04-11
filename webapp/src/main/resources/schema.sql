

create table IF NOT EXISTS  agent (
        agentid integer NOT NULL AUTO_INCREMENT,
        address varchar(255),
        contact_id integer,
        password varchar(255),
        primary key (agentid)
    );


--ALTER TABLE agent
--ADD COLUMN  googleprofile  varchar(2000);

create table IF NOT EXISTS contact (
        contact_id integer NOT NULL AUTO_INCREMENT,
        active bit,
        address varchar(255),
        city varchar(255),
        client_type varchar(255),
        created_date datetime,
        emailaddress varchar(255),
        end_date datetime,
        general_information varchar(255),
        license varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        start_date datetime,
        state varchar(255),
        streetaddress varchar(255),
        usage_date datetime,
        uuid varchar(255),
        zipcode varchar(255),
        primary key (contact_id)
    );
    
    
    
    
    CREATE TABLE IF NOT EXISTS `wizard` (
  `wizardid` int(11) NOT NULL AUTO_INCREMENT,
  `agentid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
   `encrypt` varchar(45) NULL,
  primary key (wizardid)
) ;


  
  
  CREATE TABLE IF NOT EXISTS `wizarddata` (
  `wizarddataid` int(11) NOT NULL AUTO_INCREMENT,
  `pagedata` varchar(2000) NOT NULL,
  `wizardid` int(11) NOT NULL,
  `pagename` varchar(50) NOT NULL,
  `pagesequence` int(11) NOT NULL,
   primary key (wizarddataid)
) ;

--SELECT *  FROM license.wizarddata where wizardid = 39 and pagesequence = 27
-- SELECT count(*) as count , pagesequence , wizardid , pagename  FROM license.wizarddata GROUP BY wizardid, pagesequence , pagename HAVING count >= 2
--ALTER TABLE `wizarddata` 
--CHANGE COLUMN `pagedata` `pagedata` LONGTEXT NOT NULL ;

--ALTER TABLE `license`.`wizarddata` 
--ADD UNIQUE INDEX `pageIndex` (`wizardid` ASC, `pagesequence` ASC) VISIBLE;





--ALTER TABLE `wizarddata`
--ADD COLUMN  `excluded`  TINYINT(1) AFTER `pagesequence`;
--update table wizarddata set excluded = 0;
--update  wizarddata
----set excluded = 0
--where wizarddataid >  0
--ALTER TABLE `license`.`wizarddata` 
--CHANGE COLUMN `excluded` `excluded` TINYINT(1) NULL DEFAULT 0 ;
-- Indexes for dumped tables
--

--ALTER TABLE `license`.`wizarddata` 
--ADD UNIQUE INDEX `pageDataIndex` (`wizardid` ASC, `pagename` ASC) VISIBLE;

    
-- DROP INDEX index_agent_address ON agent;
 
--CREATE UNIQUE INDEX  index_agent_address ON agent(address);

--insert---
--INSERT IGNORE INTO `contact` ( `contact_id`,`name`, `uuid`, `license`, `general_information`, `phone`, `usage_date`, `created_date`, `start_date`, `end_date`, `address`, `active`, `client_type`, `streetaddress`, `city`, `state`, `zipcode`, `emailaddress`,`password`) VALUES (-777,'Mark Hildebrand', '0825f2d3', 'y8V9vQD3d', ' Casper, WY', '3073330964', '2017-09-07 21:54:10', '2017-07-15 07:29:19', '2017-01-04 00:10:00', '2022-01-31 00:03:00', 'mhildebrand@kcwy13.com', 0, 'TV', 'PO Box 1540', 'Mills', 'WY', '82644', 'a@aol.com', 'password');

delete from contact where contact_id = -777;
INSERT IGNORE INTO `contact` ( `contact_id`,`name`, `uuid`, `license`, `general_information`, `phone`, `usage_date`, `created_date`, `start_date`, `end_date`, `address`, `active`, `client_type`, `streetaddress`, `city`, `state`, `zipcode`, `emailaddress`,`password`) VALUES (-777,'Mark Hildebrand', '0825f2d3', 'y8V9vQD3d', ' Casper, WY', '3073330964', '2017-09-07 21:54:10', '2017-07-15 07:29:19', '2017-01-04 00:10:00', '2022-01-31 00:03:00', 'mhildebrand@kcwy13.com', 0, 'TV', 'PO Box 1540', 'Mills', 'WY', '82644', 'a@aol.com', 'password');
delete from agent where address = 'z@aol.com';
INSERT IGNORE  INTO `agent` (`address`,`password`, `contact_id`) VALUES ('z@aol.com', 'z', -777);

/*
 
 DELIMITER //
 CREATE PROCEDURE AddTestAgent()
  BEGIN
  DECLARE countID INT;

SELECT COUNT(address) INTO countID FROM agent
WHERE address = 'z@aol.com';
  IF countID =0  THEN 
  
   INSERT INTO `agent` (`address`,`password`, `contact_id`) VALUES ('z@aol.com', 'z', -777);
  
  END IF;

 
  END //
 DELIMITER ;
CALL AddTestAgent();
*/
