-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: banhang
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `danhsachhoadon`
--

DROP TABLE IF EXISTS `danhsachhoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhsachhoadon` (
  `maHD` int NOT NULL,
  `maKH` int DEFAULT NULL,
  `ngaylapHD` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tinhtrangHD` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `giaHD` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ghichuHD` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maHD`),
  KEY `maKH_idx` (`maKH`),
  CONSTRAINT `maKH` FOREIGN KEY (`maKH`) REFERENCES `khachhang` (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhsachhoadon`
--

LOCK TABLES `danhsachhoadon` WRITE;
/*!40000 ALTER TABLE `danhsachhoadon` DISABLE KEYS */;
INSERT INTO `danhsachhoadon` VALUES (1,1,'2021-03-01 09:19:05','Đã Hoàn Thành','130061878',''),(3,2,'2021-12-27 11:51:37','Đã Hoàn Thành','10048762','gfgfsdsd'),(4,1,'2021-12-27 09:19:05','Hoàn Thành','x','dtftfg'),(5,1,'2021-12-27 09:19:05','Hoàn Thành','x','dtftfg'),(6,3,'2021-03-21 17:23:01','Hoàn Thành','x','sdsfcxxcxcxc'),(7,3,'2021-12-27 17:23:01','Đã Hoàn Thành','x','sdsfcxxcxcxc'),(8,2,'2021-06-06 15:41:19','Chưa Hoàn Thành','x','ưqwqqwq'),(9,2,'2021-06-06 15:41:19','Chưa Hoàn Thành','0','êrerer'),(10,2,'2021-06-07 12:03:32','Chưa Hoàn Thành','','âsasdsd');
/*!40000 ALTER TABLE `danhsachhoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `maHD` int NOT NULL,
  `maSP` int NOT NULL,
  `soluongHD` int DEFAULT NULL,
  `thanhtienHD` int DEFAULT NULL,
  PRIMARY KEY (`maHD`,`maSP`),
  KEY `maSP_idx` (`maSP`),
  CONSTRAINT `maHD` FOREIGN KEY (`maHD`) REFERENCES `danhsachhoadon` (`maHD`),
  CONSTRAINT `maSP` FOREIGN KEY (`maSP`) REFERENCES `sanpham` (`maSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (1,1,555555,128888760),(1,2,3,NULL),(1,3,323,750329),(1,4,50,11615),(1,5,23,2),(1,6,23,1),(1,8,555,1161500),(3,1,888,206016),(3,2,4,3),(3,5,2,4),(3,6,2,10000000),(3,7,59,48686),(3,9,3,69),(4,1,888,206016),(4,2,34,10958982),(4,3,2,NULL),(5,1,222,51504),(5,2,3,4),(5,4,23,53429),(6,1,222,51504),(7,1,22,5104),(7,2,34,10958982),(8,3,23,53429),(9,1,222,51504),(9,2,34,10958982),(9,3,3,NULL),(10,1,222,51504),(10,2,34,10958982);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadons`
--

DROP TABLE IF EXISTS `hoadons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadons` (
  `maHD` int NOT NULL,
  `maSP` int NOT NULL,
  `soluong` int DEFAULT NULL,
  `dongia` int DEFAULT NULL,
  `thanhtien` int DEFAULT NULL,
  PRIMARY KEY (`maHD`,`maSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadons`
--

LOCK TABLES `hoadons` WRITE;
/*!40000 ALTER TABLE `hoadons` DISABLE KEYS */;
INSERT INTO `hoadons` VALUES (1,1,2,2,NULL),(1,4,2,3,2),(2,4,2,3,2),(3,4,34,43,NULL),(4,3,2,3,2),(4,4,2,3,2),(5,3,NULL,NULL,NULL),(5,4,2,3,2);
/*!40000 ALTER TABLE `hoadons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKH` int NOT NULL AUTO_INCREMENT,
  `tenKH` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `diachiKH` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sdtKH` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `emailKH` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `diemKH` int DEFAULT NULL,
  `phanhoiKH` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Tran Van A','0','7575676','tranvanchung1409@gmail.com',1300,'fff'),(2,'Nguyen Van D','0','0989998877','chungvip1409@gmail.com',11,'aads'),(3,'dfdf','df','df','fdfdf',33,'df');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `maNCC` int NOT NULL,
  `tenNCC` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `diachiNCC` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sdtNCC` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `emailNCC` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNV` int NOT NULL AUTO_INCREMENT,
  `tenNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `gioitinhNV` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `ngaysinhNV` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `cmndNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sdtNV` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `diachiNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `emailNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `luongNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ngayvaoNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'ac','Nam','2323','2323','2323','ẻer','đf','2323','232323'),(2,'ưewe','Nam','ưeww','55555555','ưew','0','ưewe','e','ưewe');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `maSP` int NOT NULL AUTO_INCREMENT,
  `tenSP` varchar(45) COLLATE utf8_bin NOT NULL,
  `loaiSP` varchar(45) COLLATE utf8_bin NOT NULL,
  `soSP` int NOT NULL,
  `giaSP` int NOT NULL,
  `ngaySP` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ghichuSP` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `maNCC` int DEFAULT NULL,
  PRIMARY KEY (`maSP`),
  KEY `maNCC_idx` (`maNCC`),
  CONSTRAINT `maNCC` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNCC`)
) ENGINE=InnoDB AUTO_INCREMENT=234547 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'acb','Nike',222222,232,'2021-06-05','24d',NULL),(2,'hsjsdklsd','Nike',3400,322323,'2021-06-05','êrer',NULL),(3,'dsdsd','Nike',22323,2323,'2021-06-05','llllll',NULL),(4,'dsdsd','Admin',22323,2323,NULL,'sdsdfd',NULL),(5,'sdsd','Admin',212,1212,NULL,'ưsđssd',NULL),(6,'jordan4','Nike',7778,5000000,NULL,'abc',NULL),(7,'êrer','Nike',2323,24343,'2010','êw',NULL),(8,'fgfg','Nike',5555,555,'2021-06-05','',NULL),(9,'gggg','Nike',444,444,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sukien`
--

DROP TABLE IF EXISTS `sukien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sukien` (
  `idSK` int NOT NULL AUTO_INCREMENT,
  `tenSK` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `thoigianSK` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `noidungSK` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idSK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sukien`
--

LOCK TABLES `sukien` WRITE;
/*!40000 ALTER TABLE `sukien` DISABLE KEYS */;
INSERT INTO `sukien` VALUES (4,'âssa','âdad','adaaaa');
/*!40000 ALTER TABLE `sukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `maNV` int NOT NULL AUTO_INCREMENT,
  `mk` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maNV`),
  CONSTRAINT `maNV` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (1,'aaa',NULL);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-10 10:56:49
