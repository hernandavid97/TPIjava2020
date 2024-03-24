CREATE DATABASE  IF NOT EXISTS `adoptar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `adoptar`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: adoptar
-- ------------------------------------------------------
-- Server version	8.0.36

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES (1,'Rosario','Santa Fe'),(2,'Funes','Santa Fe'),(3,'Victoria','Entre Rios'),(6,'San Lorenzo','Santa Fe'),(9,'Recoleta','CABA'),(10,'Santa Fe','Santa Fe'),(11,'Retiro','CABA'),(12,'jjj','jj');
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `id_mascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo_animal` varchar(45) NOT NULL,
  `edad` int DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `is_disponible` tinyint(1) NOT NULL,
  `imagenes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (5,'Pumi','Perro',4,'Blanco y negro',1,'https://github.com/hernandavid97/TPIjava2020/assets/49590400/55ba22f8-5347-4b35-8665-648de6539901'),(6,'Felipe','Gato',5,'Marron y Negro',1,'https://github.com/hernandavid97/TPIjava2020/assets/49590400/ce56e73f-3c12-4e61-b50b-355593bca54d'),(7,'Viejito','Perro',15,'Negro',1,'https://cdn.redcanina.es/wp-content/uploads/2013/10/12173110/perro-viejo.jpg'),(8,'Tony','Perro',20,'Negro',1,'https://www.canuto.com.mx/cdn/shop/articles/blog_canuto.jpg?v=1622059046'),(9,'Mona','Perro',1,'Negro y marron',1,'https://static.miscota.com/consejos/wp-content/uploads/2016/07/12-Week-Black-German-Shepherd-Puppy-1024x683.jpg');
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
  `id_adoptante` int DEFAULT NULL,
  `fecha_hora_adopcion` datetime(1) DEFAULT NULL,
  PRIMARY KEY (`id_transito`),
  KEY `id_donante_idx` (`id_donante`),
  KEY `id_mascota_idx` (`id_mascota`),
  KEY `id_adoptante_idx` (`id_adoptante`),
  CONSTRAINT `id_adopt` FOREIGN KEY (`id_adoptante`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `id_donante` FOREIGN KEY (`id_donante`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `id_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mascota` (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transito`
--

LOCK TABLES `transito` WRITE;
/*!40000 ALTER TABLE `transito` DISABLE KEYS */;
INSERT INTO `transito` VALUES (6,8,5,'2024-03-23 14:39:19.0',NULL,NULL),(7,8,6,'2024-03-23 15:03:07.0',6,'2024-03-23 15:09:57.0'),(8,8,7,'2024-03-23 15:05:25.0',NULL,NULL),(9,2,8,'2024-03-23 15:08:20.0',NULL,NULL),(10,6,9,'2024-03-23 15:09:49.0',NULL,NULL);
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
  `tipo_doc` varchar(45) NOT NULL DEFAULT 'dni',
  `nro_doc` varchar(45) NOT NULL,
  `is_adoptante` tinyint(1) NOT NULL DEFAULT '1',
  `is_donante` tinyint(1) NOT NULL DEFAULT '1',
  `localidad` int DEFAULT NULL,
  `tipo` int NOT NULL DEFAULT '1',
  `fecha_baja` datetime(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_localidad_idx` (`localidad`),
  CONSTRAINT `id_localidad` FOREIGN KEY (`localidad`) REFERENCES `localidad` (`id_localidad`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'hernan','hernan','ha@gmail.com','Hernan','David','Calle 123','dni','123456789',1,0,1,0,NULL),(6,'david','david','david@gmail.com','david','perez','san martin 123','dni','1234444',1,1,1,1,NULL),(7,'roberto','roberto','rober@gmail.com','roberto','gomez','peru 333','dni','544444444',1,1,3,1,NULL),(8,'larita','larita','larita@gmail.com','Larita','Megumi','Casa','dni','41655307',1,1,1,1,NULL),(9,'admin','admin','admin@gmail.com','admin','admin','admin house','dni','44444444',1,1,1,0,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacuna`
--

DROP TABLE IF EXISTS `vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacuna` (
  `id_vacuna` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `especie` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_vacuna`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacuna`
--

LOCK TABLES `vacuna` WRITE;
/*!40000 ALTER TABLE `vacuna` DISABLE KEYS */;
INSERT INTO `vacuna` VALUES (1,'Trivalente','Gato',NULL),(2,'Leucemia ','Gato',NULL),(3,'Rabia','Gato',NULL),(4,'Monovalente ','Perro','Parvovirus'),(5,'Bivalente','Perro','(parvovirus y moquillo)'),(6,'Rabia','Perro',NULL),(7,'kkk','kkk','k'),(8,'asd','asd','asd'),(9,'a','a','a'),(10,'a','a','a'),(11,'a','a','a'),(12,'asd','asd','asddd'),(13,'aaa','aaa','aaa');
/*!40000 ALTER TABLE `vacuna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacunacion`
--

DROP TABLE IF EXISTS `vacunacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacunacion` (
  `id_vacunacion` int NOT NULL AUTO_INCREMENT,
  `id_mascota` int DEFAULT NULL,
  `id_vacuna` int DEFAULT NULL,
  `fecha_vacunacion` date DEFAULT NULL,
  PRIMARY KEY (`id_vacunacion`),
  KEY `id_mascota_idx` (`id_mascota`) /*!80000 INVISIBLE */,
  KEY `fk_vacuna_idx` (`id_vacuna`),
  CONSTRAINT `fk_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mascota` (`id_mascota`),
  CONSTRAINT `fk_vacuna` FOREIGN KEY (`id_vacuna`) REFERENCES `vacuna` (`id_vacuna`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacunacion`
--

LOCK TABLES `vacunacion` WRITE;
/*!40000 ALTER TABLE `vacunacion` DISABLE KEYS */;
INSERT INTO `vacunacion` VALUES (1,6,1,'2024-01-02'),(2,6,2,'2024-01-02'),(3,5,4,'2023-01-02'),(4,7,5,'2023-12-02');
/*!40000 ALTER TABLE `vacunacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-24 16:53:28
