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
  `giaHD` int DEFAULT NULL,
  `ghichuHD` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `maNV` int DEFAULT NULL,
  PRIMARY KEY (`maHD`),
  KEY `maKH_idx` (`maKH`) /*!80000 INVISIBLE */,
  KEY `maNV_idx` (`maNV`),
  CONSTRAINT `maKH` FOREIGN KEY (`maKH`) REFERENCES `khachhang` (`maKH`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhsachhoadon`
--

LOCK TABLES `danhsachhoadon` WRITE;
/*!40000 ALTER TABLE `danhsachhoadon` DISABLE KEYS */;
INSERT INTO `danhsachhoadon` VALUES (1,1,'2021-03-01','Đã Hoàn Thành',130061878,'',3),(4,1,'2021-12-27','Đã Hoàn Thành',11218427,'dtftfg',2),(5,1,'2021-12-27','Đã Hoàn Thành',695351,'dtftfg',1),(6,2,'2021-12-27','Đã Hoàn Thành',0,'sdsd',1),(7,1,'2021-06-14 01:11:42','Chưa Hoàn Thành',0,'d',1);
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
  CONSTRAINT `maHD` FOREIGN KEY (`maHD`) REFERENCES `danhsachhoadon` (`maHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `maSP` FOREIGN KEY (`maSP`) REFERENCES `sanpham` (`maSP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (1,1,555555,128888760),(1,2,3,NULL),(1,3,323,750329),(1,4,50,11615),(1,5,23,2),(1,6,23,1),(1,8,555,1161500),(4,1,888,206016),(4,2,34,10958982),(4,3,2,NULL),(4,4,23,53429),(5,1,222,51504),(5,2,3,4),(5,4,23,53429),(5,7,23,559889),(5,8,55,30525);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Trần Văn Chung','Hưng Yên','012345678','tranvanchung1409@gmail.com',120,'Phù Hợp'),(2,'Bùi Văn Đạt','Hải Phòng','0969696969','datduocdayy2k@gmail.com',0,'sản phẩm tốt'),(3,'Trần Đức Ngọc','Nam Định','098989898','ngoctran74122@gmail.com',0,'Phù hợp giá tiền'),(4,'Vũ Tuấn Anh','Thái Bình','0912121212','vuanh2k0@gmail.com',0,'Đẹp'),(5,'Phạm Thái Hòa ','Nam Định','0987654321','hoaabc@gmai.com',0,'Đẹp, Chất Lượng'),(6,'Lê Quốc Việt','Hà Tĩnh','0912345678','viet123@gmail.com',0,'Giày đẹp'),(7,'Lê Văn A','Hà Nội','0969123456','chungvip1409@gmail.com',0,'Tốt'),(8,'Trần Văn B','Sơn La','0987789987','hieu12@gmail.com',0,'Đẹppppp');
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
INSERT INTO `nhacungcap` VALUES (1,'Adidas Original','USA','123456789','adidas@gmail.com'),(2,'SneakerLand','England','33434556','sneakerLand@gmail.com'),(3,'ConverseStore','Việt Nam','0987382323','converse@gmail.com'),(4,'Vansvietnam','Hà Nội, Việt Nam','0983272323','vansvn@gmail.com'),(5,'OriginSneaker','Đà Nẵng, Việt Nam','098876645','originsneaker@gmail.com');
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
  `luongNV` int DEFAULT NULL,
  `ngayvaoNV` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Trần Văn A','Nam','14/9/2000','32232322332','232354454','Hà Nội','abcccc@gmail.com',10000000,'22/5/2020'),(2,'Vũ Thị B','Nữ','12/12/2001','55555555','23232323','Hà Nội','abc@gmail.com',5000000,'20/5/2021'),(3,'Nguyễn Văn C','Nam','22/2/2000','3223322323','09878922112','Hà Nội','cde@gmail.com',6000000,'10/1/2021'),(4,'Vũ Văn D','Nam','12/2/2002','33333333','3232323','Hà Nội','aaa@gmail.com',4000000,'3/4/2021'),(5,'Bùi Văn E','Nam','22/9/2000','434343434','0954550878','Hà Nội','eee@gmail.com',6000000,'14/5/2020'),(6,'Nguyễn Minh F','Nam','1/1/2000','3344343434','0978676767','Hà Nội','bbb@gmail.com',4000000,'24/4/2021');
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
INSERT INTO `sanpham` VALUES (1,'Nike Air Mag','Nike',1256,8000000,'2021-06-14','size 39-43',NULL),(2,'Ultra Boost','Adidas',3400,5600000,'2021-06-14','36-43',NULL),(3,'Yeezy 350','Adidas',3567,9800000,'2021-06-14','36-43',NULL),(4,'Converse Chuck Taylor All Star','Converse',22300,1800000,'2021-06-14','36-43',NULL),(5,'Vans old skool','Vans',49865,1500000,'2021-06-14','36-43',NULL),(6,'Air Jordan4','Nike',6868,10000000,'2021-06-14','36-43',NULL),(7,'Converse Chuck II ','Converse',2300,2000000,'2021-06-14','39-43',NULL),(8,'Gel Lite V','Asics',54778,6340000,'2021-06-14','36-43',NULL),(9,'gggg','Nike',444,444,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sukien`
--

LOCK TABLES `sukien` WRITE;
/*!40000 ALTER TABLE `sukien` DISABLE KEYS */;
INSERT INTO `sukien` VALUES (5,'Chào mừng ngày 8/3','8/3 đến 10/3','Giảm giá 20% toàn bộ sản phẩm '),(6,'Chào mừng 30/4 và 1/5','30/4 và 1/5','Giảm giá tới 20%, có tặng quà giá trị tới 200000 đồng');
/*!40000 ALTER TABLE `sukien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `maNV` int NOT NULL,
  `taikhoan` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `matkhau` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `vaitro` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`maNV`),
  UNIQUE KEY `maNV_UNIQUE` (`maNV`),
  KEY `maNV_idx` (`maNV`),
  CONSTRAINT `maNV` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (1,'admin','admin','Admin'),(2,'aaa','bbb','Employee'),(3,'ccc','ddd','Employee'),(4,'eee','fff','Employee'),(5,'ggg','hhh','Employee');
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

-- Dump completed on 2021-06-16 22:19:32
