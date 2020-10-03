CREATE DATABASE  IF NOT EXISTS `adoptar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `adoptar`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: adoptar
-- ------------------------------------------------------
-- Server version	8.0.21

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

--
-- Table structure for table `adopcion`
--

DROP TABLE IF EXISTS `adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adopcion` (
  `id_transito` int NOT NULL,
  `id_adoptante` int NOT NULL,
  PRIMARY KEY (`id_transito`,`id_adoptante`),
  KEY `id_donante_idx` (`id_adoptante`),
  CONSTRAINT `id_adoptante` FOREIGN KEY (`id_adoptante`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `id_transito` FOREIGN KEY (`id_transito`) REFERENCES `transito` (`id_transito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopcion`
--

LOCK TABLES `adopcion` WRITE;
/*!40000 ALTER TABLE `adopcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `adopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donacion_ong`
--

DROP TABLE IF EXISTS `donacion_ong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donacion_ong` (
  `id_usuario` int NOT NULL,
  `id_ong` int NOT NULL,
  `monto` int NOT NULL,
  `fecha_hora_donfin` datetime(1) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_ong`,`fecha_hora_donfin`),
  KEY `id_ong_idx` (`id_ong`),
  CONSTRAINT `id_donfin` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `id_ong` FOREIGN KEY (`id_ong`) REFERENCES `ong` (`id_ong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donacion_ong`
--

LOCK TABLES `donacion_ong` WRITE;
/*!40000 ALTER TABLE `donacion_ong` DISABLE KEYS */;
/*!40000 ALTER TABLE `donacion_ong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localidad` (
  `id_localidad` int NOT NULL AUTO_INCREMENT,
  `nombre_localidad` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  PRIMARY KEY (`id_localidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES (1,'Rosario','Santa Fe');
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `idmascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo_animal` varchar(45) NOT NULL,
  `edad` int DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmascota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ong`
--

DROP TABLE IF EXISTS `ong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ong` (
  `id_ong` int NOT NULL AUTO_INCREMENT,
  `nombre_ong` varchar(45) NOT NULL,
  `cbu_ong` varchar(45) NOT NULL,
  PRIMARY KEY (`id_ong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ong`
--

LOCK TABLES `ong` WRITE;
/*!40000 ALTER TABLE `ong` DISABLE KEYS */;
/*!40000 ALTER TABLE `ong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transito`
--

DROP TABLE IF EXISTS `transito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transito` (
  `id_transito` int NOT NULL AUTO_INCREMENT,
  `id_donante` int NOT NULL,
  `id_mascota` int NOT NULL,
  `fecha_hora_donacion` datetime(1) NOT NULL,
  PRIMARY KEY (`id_transito`),
  KEY `id_donante_idx` (`id_donante`),
  KEY `id_mascota_idx` (`id_mascota`),
  CONSTRAINT `id_donante` FOREIGN KEY (`id_donante`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `id_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mascota` (`idmascota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transito`
--

LOCK TABLES `transito` WRITE;
/*!40000 ALTER TABLE `transito` DISABLE KEYS */;
/*!40000 ALTER TABLE `transito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `domicilio` varchar(45) NOT NULL,
  `tipo_doc` varchar(45) NOT NULL,
  `nro_doc` varchar(45) NOT NULL,
  `is_adoptante` tinyint(1) NOT NULL,
  `is_donante` tinyint(1) NOT NULL,
  `localidad` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_localidad_idx` (`localidad`),
  CONSTRAINT `id_localidad` FOREIGN KEY (`localidad`) REFERENCES `localidad` (`id_localidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'hernan','hernan','ha@gmail.com','Hernan','David','Calle 123','dni','123456789',1,0,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-02 22:04:38
