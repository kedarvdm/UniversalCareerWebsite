CREATE DATABASE  IF NOT EXISTS `universalcareers` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `universalcareers`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: universalcareers
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `STREET1` varchar(255) DEFAULT NULL,
  `STREET2` varchar(255) DEFAULT NULL,
  `ZIP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'a','a',NULL,'a','a','a','a'),(2,'a','a',NULL,'a','a','a','a'),(3,'a','a',NULL,'a','a','a','a');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant` (
  `CELLPHONE` varchar(255) DEFAULT NULL,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `RESUME` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  CONSTRAINT `FK_lqtlys8m214ckjhcrjv6hx8yw` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
INSERT INTO `applicant` VALUES ('a',NULL,'C:\\Tomcat8\\UniversalCareers\\Applicants\\Resumes\\1\\1.pdf',1);
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APPSTATUS` varchar(255) DEFAULT NULL,
  `DATEAPPSTATUS` varchar(255) DEFAULT NULL,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `DATEINTSTATUS` varchar(255) DEFAULT NULL,
  `INTERNALAPPSTATUS` varchar(255) DEFAULT NULL,
  `JOB_ID` int(11) NOT NULL,
  `USER_APPLICATION_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_j81ft44o5lmvvf63llr3r79ek` (`JOB_ID`),
  KEY `FK_cw2t0ttv35dmhvlc2d4ggleqg` (`USER_APPLICATION_FK`),
  CONSTRAINT `FK_cw2t0ttv35dmhvlc2d4ggleqg` FOREIGN KEY (`USER_APPLICATION_FK`) REFERENCES `user` (`ID`),
  CONSTRAINT `FK_j81ft44o5lmvvf63llr3r79ek` FOREIGN KEY (`JOB_ID`) REFERENCES `jobdetails` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,'Applied','04/24/2015','04/24/2015','04/24/2015','Applied',1,1);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEGREELEVEL` varchar(255) DEFAULT NULL,
  `ENDDATE` varchar(255) DEFAULT NULL,
  `GPA` varchar(255) DEFAULT NULL,
  `ISGRADUATED` varchar(255) DEFAULT NULL,
  `MAJOR` varchar(255) DEFAULT NULL,
  `SCHOOLNAME` varchar(255) DEFAULT NULL,
  `STARTDATE` varchar(255) DEFAULT NULL,
  `USER_EDUCATION_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_3g5vwhwfprw582irvlgl22i4t` (`USER_EDUCATION_FK`),
  CONSTRAINT `FK_3g5vwhwfprw582irvlgl22i4t` FOREIGN KEY (`USER_EDUCATION_FK`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,'MS','08/2016','3.66','No','IS','NEU','09/2013',1);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `CELLPHONE` varchar(255) DEFAULT NULL,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `DEPARTMENT` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  `EMPLOYER_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK_a5ld2q59m6iqmb8r66wm9d48t` (`EMPLOYER_FK`),
  CONSTRAINT `FK_a5ld2q59m6iqmb8r66wm9d48t` FOREIGN KEY (`EMPLOYER_FK`) REFERENCES `employer` (`USER_ID`),
  CONSTRAINT `FK_pahqxqqbjnk7q2759k4ogtusb` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('a','04/24/2015','HR',3,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employer` (
  `DATECREATED` varchar(255) DEFAULT NULL,
  `VETERANSTATUS` varchar(255) DEFAULT NULL,
  `INDUSTRY` varchar(255) DEFAULT NULL,
  `WEBSITE` varchar(255) DEFAULT NULL,
  `WORKPHONE` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  CONSTRAINT `FK_ejxsevco1reldp1rtwucvyfjb` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (NULL,'a','a','a','a',2);
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobdetails`
--

DROP TABLE IF EXISTS `jobdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobdetails` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `DURATIONFROM` varchar(255) DEFAULT NULL,
  `DURATIONTO` varchar(255) DEFAULT NULL,
  `HOURLYWAGE` varchar(255) DEFAULT NULL,
  `JOBTITLE` varchar(255) DEFAULT NULL,
  `JOBTYPE` varchar(255) DEFAULT NULL,
  `POSITIONS` int(11) DEFAULT NULL,
  `SKILLS` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `EMPLOYER_FK` int(11) DEFAULT NULL,
  `EMPLOYEE_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_qujhev7iyad9559dxghd5n28p` (`EMPLOYER_FK`),
  KEY `FK_aufymairv8wwaojlc33tq01jv` (`EMPLOYEE_FK`),
  CONSTRAINT `FK_aufymairv8wwaojlc33tq01jv` FOREIGN KEY (`EMPLOYEE_FK`) REFERENCES `user` (`ID`),
  CONSTRAINT `FK_qujhev7iyad9559dxghd5n28p` FOREIGN KEY (`EMPLOYER_FK`) REFERENCES `employer` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobdetails`
--

LOCK TABLES `jobdetails` WRITE;
/*!40000 ALTER TABLE `jobdetails` DISABLE KEYS */;
INSERT INTO `jobdetails` VALUES (1,'Boston','USA',NULL,'Application Development','July 2015','NA','30','Programmer','Technical',5,'Java','MA',2,3);
/*!40000 ALTER TABLE `jobdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMPANYNAME` varchar(255) DEFAULT NULL,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `EMAILID` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `MIDDLENAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `ADDRESS_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_r86rlv8krq266srngqt56469` (`ADDRESS_FK`),
  CONSTRAINT `FK_r86rlv8krq266srngqt56469` FOREIGN KEY (`ADDRESS_FK`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,'kvdeshmukh1989@gmail.com','Kedar','Deshmukh','Vaijanathrao','password','Applicant',1),(2,'Company',NULL,'employer1@gmail.com','Employer','Employer',NULL,'password','Employer',2),(3,NULL,'04/24/2015','hr1@gmail.com','HR','HR','HR','password','Employee',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workexperience`
--

DROP TABLE IF EXISTS `workexperience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workexperience` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATECREATED` varchar(255) DEFAULT NULL,
  `EMPLOYERNAME` varchar(255) DEFAULT NULL,
  `ENDDATE` varchar(255) DEFAULT NULL,
  `ISCURRENTEMPLOYER` varchar(255) DEFAULT NULL,
  `RESPONSIBILITIES` varchar(255) DEFAULT NULL,
  `STARTDATE` varchar(255) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `USER_WORKEX_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_j7ell49bt0v7j8ono7qbbgmgh` (`USER_WORKEX_FK`),
  CONSTRAINT `FK_j7ell49bt0v7j8ono7qbbgmgh` FOREIGN KEY (`USER_WORKEX_FK`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workexperience`
--

LOCK TABLES `workexperience` WRITE;
/*!40000 ALTER TABLE `workexperience` DISABLE KEYS */;
INSERT INTO `workexperience` VALUES (1,'04/24/2015','Yardi','06/2013','No','Web Development','08/2011','Programmer I',1);
/*!40000 ALTER TABLE `workexperience` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-24 17:15:57
