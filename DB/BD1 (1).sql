-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: BD1
-- ------------------------------------------------------
-- Server version	5.5.53-0+deb8u1

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
-- Table structure for table `ALUMNO`
--

DROP TABLE IF EXISTS `ALUMNO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALUMNO` (
  `IdAlumno` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `APaterno` varchar(50) NOT NULL,
  `AMaterno` varchar(50) NOT NULL,
  `Email` varchar(75) NOT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `IdTT` varchar(9) NOT NULL,
  PRIMARY KEY (`IdAlumno`),
  KEY `IdTT` (`IdTT`),
  CONSTRAINT `ALUMNO_ibfk_1` FOREIGN KEY (`IdTT`) REFERENCES `TT` (`IdTT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALUMNO`
--

LOCK TABLES `ALUMNO` WRITE;
/*!40000 ALTER TABLE `ALUMNO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ALUMNO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CALENDARIO`
--

DROP TABLE IF EXISTS `CALENDARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CALENDARIO` (
  `IdTT` varchar(9) NOT NULL,
  `Fecha` datetime NOT NULL,
  `IdSala` int(11) NOT NULL,
  PRIMARY KEY (`IdTT`),
  KEY `IdSala` (`IdSala`),
  CONSTRAINT `CALENDARIO_ibfk_1` FOREIGN KEY (`IdTT`) REFERENCES `TT` (`IdTT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `CALENDARIO_ibfk_2` FOREIGN KEY (`IdSala`) REFERENCES `SALA` (`IdSala`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CALENDARIO`
--

LOCK TABLES `CALENDARIO` WRITE;
/*!40000 ALTER TABLE `CALENDARIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `CALENDARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DIRIGE`
--

DROP TABLE IF EXISTS `DIRIGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DIRIGE` (
  `IdTT` varchar(9) NOT NULL,
  `D1` int(11) NOT NULL,
  `D2` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdTT`),
  KEY `D1` (`D1`),
  KEY `D2` (`D2`),
  CONSTRAINT `DIRIGE_ibfk_1` FOREIGN KEY (`D1`) REFERENCES `PROFESOR` (`IdProfesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `DIRIGE_ibfk_2` FOREIGN KEY (`D2`) REFERENCES `PROFESOR` (`IdProfesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DIRIGE`
--

LOCK TABLES `DIRIGE` WRITE;
/*!40000 ALTER TABLE `DIRIGE` DISABLE KEYS */;
/*!40000 ALTER TABLE `DIRIGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HORARIO`
--

DROP TABLE IF EXISTS `HORARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HORARIO` (
  `IdHorario` int(11) NOT NULL AUTO_INCREMENT,
  `Lun` varchar(7) DEFAULT NULL,
  `Mar` varchar(7) DEFAULT NULL,
  `Mie` varchar(7) DEFAULT NULL,
  `Jue` varchar(7) DEFAULT NULL,
  `Vie` varchar(7) DEFAULT NULL,
  `IdProfesor` int(11) NOT NULL,
  PRIMARY KEY (`IdHorario`),
  KEY `IdProfesor` (`IdProfesor`),
  CONSTRAINT `HORARIO_ibfk_1` FOREIGN KEY (`IdProfesor`) REFERENCES `PROFESOR` (`IdProfesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HORARIO`
--

LOCK TABLES `HORARIO` WRITE;
/*!40000 ALTER TABLE `HORARIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `HORARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROFESOR`
--

DROP TABLE IF EXISTS `PROFESOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROFESOR` (
  `IdProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `APaterno` varchar(50) NOT NULL,
  `AMaterno` varchar(50) NOT NULL,
  `Email` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`IdProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROFESOR`
--

LOCK TABLES `PROFESOR` WRITE;
/*!40000 ALTER TABLE `PROFESOR` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROFESOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SALA`
--

DROP TABLE IF EXISTS `SALA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SALA` (
  `IdSala` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`IdSala`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SALA`
--

LOCK TABLES `SALA` WRITE;
/*!40000 ALTER TABLE `SALA` DISABLE KEYS */;
/*!40000 ALTER TABLE `SALA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SINODALIA`
--

DROP TABLE IF EXISTS `SINODALIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SINODALIA` (
  `IdTT` varchar(9) NOT NULL,
  `S1` int(11) NOT NULL,
  `S2` int(11) NOT NULL,
  `S3` int(11) NOT NULL,
  PRIMARY KEY (`IdTT`),
  KEY `S1` (`S1`),
  KEY `S2` (`S2`),
  KEY `S3` (`S3`),
  CONSTRAINT `SINODALIA_ibfk_1` FOREIGN KEY (`S1`) REFERENCES `PROFESOR` (`IdProfesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `SINODALIA_ibfk_2` FOREIGN KEY (`S2`) REFERENCES `PROFESOR` (`IdProfesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `SINODALIA_ibfk_3` FOREIGN KEY (`S3`) REFERENCES `PROFESOR` (`IdProfesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SINODALIA`
--

LOCK TABLES `SINODALIA` WRITE;
/*!40000 ALTER TABLE `SINODALIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `SINODALIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TT`
--

DROP TABLE IF EXISTS `TT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TT` (
  `IdTT` varchar(9) NOT NULL,
  `Nombre` varchar(140) NOT NULL,
  `Nivel` int(11) NOT NULL,
  PRIMARY KEY (`IdTT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TT`
--

LOCK TABLES `TT` WRITE;
/*!40000 ALTER TABLE `TT` DISABLE KEYS */;
/*!40000 ALTER TABLE `TT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-18 12:16:05
