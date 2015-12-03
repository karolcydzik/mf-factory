CREATE DATABASE  IF NOT EXISTS `mpfactory` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci */;
USE `mpfactory`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: mpfactory
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `agglomerations`
--

DROP TABLE IF EXISTS `agglomerations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agglomerations` (
  `ID` bigint(20) NOT NULL,
  `AGGLOM_ID` bigint(20) DEFAULT NULL,
  `CITY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FK362D64B4E6BB0A93` (`AGGLOM_ID`),
  KEY `FK362D64B414C86091` (`CITY_ID`),
  CONSTRAINT `FK362D64B414C86091` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`ID`),
  CONSTRAINT `FK362D64B4E6BB0A93` FOREIGN KEY (`AGGLOM_ID`) REFERENCES `city` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agglomerations`
--

LOCK TABLES `agglomerations` WRITE;
/*!40000 ALTER TABLE `agglomerations` DISABLE KEYS */;
INSERT INTO `agglomerations` VALUES (1,909,161),(2,909,162),(3,909,688),(4,910,74),(5,910,93),(6,910,125),(7,910,165),(8,910,259),(9,910,445),(10,910,231),(11,910,539),(12,910,655),(13,910,629),(14,910,689),(15,910,763),(16,910,860);
/*!40000 ALTER TABLE `agglomerations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(60) COLLATE utf8_polish_ci DEFAULT NULL,
  `ORD` bigint(20) DEFAULT NULL,
  `STATE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FK1F916B28714843` (`STATE_ID`),
  KEY `idx_city_STATE_ID` (`STATE_ID`),
  CONSTRAINT `FK1F916B28714843` FOREIGN KEY (`STATE_ID`) REFERENCES `state` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Aleksandrów Kujawski',1001,2),(2,'Aleksandrów Łódzki',1002,5),(3,'Alwernia',1003,7),(4,'Andrychów',1004,7),(5,'Annopol',1005,3),(6,'Augustów',1006,10),(7,'Babimost',1007,4),(8,'Baborów',1008,8),(9,'Baranów Sandomierski',1009,9),(10,'Barcin',1010,2),(11,'Barczewo',1011,14),(12,'Bardo',1012,1),(13,'Barlinek',1013,16),(14,'Bartoszyce',1014,14),(15,'Barwice',1015,16),(16,'Bełchatów',1016,5),(17,'Bełżyce',1017,3),(18,'Będzin',1018,12),(19,'Biała',1019,8),(20,'Biała Piska',1020,14),(21,'Biała Podlaska',1021,3),(22,'Biała Rawska',1022,5),(23,'Białobrzegi',1023,6),(24,'Białogard',1024,16),(25,'Biały Bór',1025,16),(26,'Białystok',4,10),(27,'Biecz',1027,7),(28,'Bielawa',1028,1),(29,'Bielsk Podlaski',1029,10),(30,'Bielsko-Biała',1030,12),(31,'Bieruń',1031,12),(32,'Bierutów',1032,1),(33,'Bieżuń',1033,6),(34,'Biłgoraj',1034,3),(35,'Biskupiec',1035,14),(36,'Bisztynek',1036,14),(37,'Blachownia',1037,12),(38,'Błaszki',1038,5),(39,'Błażowa',1039,9),(40,'Błonie',1040,6),(41,'Bobolice',1041,16),(42,'Bobowa',1042,7),(43,'Bochnia',1043,7),(44,'Bodzentyn',1044,13),(45,'Bogatynia',1045,1),(46,'Boguchwała',1046,9),(47,'Boguszów-Gorce',1047,1),(48,'Bojanowo',1048,15),(49,'Bolesławiec',1049,1),(50,'Bolków',1050,1),(51,'Borek Wielkopolski',1051,15),(52,'Borne Sulinowo',1052,16),(53,'Braniewo',1053,14),(54,'Brańsk',1054,10),(55,'Brodnica',1055,2),(56,'Brok',1056,6),(57,'Brusy',1057,11),(58,'Brwinów',1058,6),(59,'Brzeg',1059,8),(60,'Brzeg Dolny',1060,1),(61,'Brzesko',1061,7),(62,'Brzeszcze',1062,7),(63,'Brześć Kujawski',1063,2),(64,'Brzeziny',1064,5),(65,'Brzostek',1065,9),(66,'Brzozów',1066,9),(67,'Buk',1067,15),(68,'Bukowno',1068,7),(69,'Busko-Zdrój',1069,13),(70,'Bychawa',1070,3),(71,'Byczyna',1071,8),(72,'Bydgoszcz',5,2),(73,'Bystrzyca Kłodzka',1073,1),(74,'Bytom',1074,12),(75,'Bytom Odrzański',1075,4),(76,'Bytów',1076,11),(77,'Cedynia',1077,16),(78,'Chełm',1078,3),(79,'Chełmek',1079,7),(80,'Chełmno',1080,2),(81,'Chełmża',1081,2),(82,'Chęciny',1082,13),(83,'Chmielnik',1083,13),(84,'Chocianów',1084,1),(85,'Chociwel',1085,16),(86,'Chodecz',1086,2),(87,'Chodzież',1087,15),(88,'Chojna',1088,16),(89,'Chojnice',1089,11),(90,'Chojnów',1090,1),(91,'Choroszcz',1091,10),(92,'Chorzele',1092,6),(93,'Chorzów',1093,12),(94,'Choszczno',1094,16),(95,'Chrzanów',1095,7),(96,'Ciechanowiec',1096,10),(97,'Ciechanów',1097,6),(98,'Ciechocinek',1098,2),(99,'Cieszanów',1099,9),(100,'Cieszyn',1100,12),(101,'Ciężkowice',1101,7),(102,'Cybinka',1102,4),(103,'Czaplinek',1103,16),(104,'Czarna Białostocka',1104,10),(105,'Czarna Woda',1105,11),(106,'Czarne',1106,11),(107,'Czarnków',1107,15),(108,'Czchów',1108,7),(109,'Czechowice-Dziedzice',1109,12),(110,'Czeladź',1110,12),(111,'Czempiń',1111,15),(112,'Czerniejewo',1112,15),(113,'Czersk',1113,11),(114,'Czerwieńsk',1114,4),(115,'Czerwionka-Leszczyny',1115,12),(116,'Częstochowa',6,12),(117,'Człopa',1117,16),(118,'Człuchów',1118,11),(119,'Czyżew',1119,10),(120,'Ćmielów',1120,13),(121,'Daleszyce',1121,13),(122,'Darłowo',1122,16),(123,'Dąbie',1123,15),(124,'Dąbrowa Białostocka',1124,10),(125,'Dąbrowa Górnicza',1125,12),(126,'Dąbrowa Tarnowska',1126,7),(127,'Debrzno',1127,11),(128,'Dębica',1128,9),(129,'Dęblin',1129,3),(130,'Dębno',1130,16),(131,'Dobczyce',1131,7),(132,'Dobiegniew',1132,4),(133,'Dobra',1133,16),(134,'Dobra',1134,15),(135,'Dobre Miasto',1135,14),(136,'Dobrodzień',1136,8),(137,'Dobrzany',1137,16),(138,'Dobrzyń nad Wisłą',1138,2),(139,'Dolsk',1139,15),(140,'Drawno',1140,16),(141,'Drawsko Pomorskie',1141,16),(142,'Drezdenko',1142,4),(143,'Drobin',1143,6),(144,'Drohiczyn',1144,10),(145,'Drzewica',1145,5),(146,'Dukla',1146,9),(147,'Duszniki-Zdrój',1147,1),(148,'Dynów',1148,9),(149,'Działdowo',1149,14),(150,'Działoszyce',1150,13),(151,'Działoszyn',1151,5),(152,'Dzierzgoń',1152,11),(153,'Dzierżoniów',1153,1),(154,'Dziwnów',1154,16),(155,'Elbląg',1155,14),(156,'Ełk',1156,14),(157,'Frampol',1157,3),(158,'Frombork',1158,14),(159,'Garwolin',1159,6),(160,'Gąbin',1160,6),(161,'Gdańsk',1161,11),(162,'Gdynia',1162,11),(163,'Giżycko',1163,14),(164,'Glinojeck',1164,6),(165,'Gliwice',1165,12),(166,'Głogów',1166,1),(167,'Głogów Małopolski',1167,9),(168,'Głogówek',1168,8),(169,'Głowno',1169,5),(170,'Głubczyce',1170,8),(171,'Głuchołazy',1171,8),(172,'Głuszyca',1172,1),(173,'Gniew',1173,11),(174,'Gniewkowo',1174,2),(175,'Gniezno',1175,15),(176,'Gogolin',1176,8),(177,'Golczewo',1177,16),(178,'Goleniów',1178,16),(179,'Golina',1179,15),(180,'Golub-Dobrzyń',1180,2),(181,'Gołańcz',1181,15),(182,'Gołdap',1182,14),(183,'Goniądz',1183,10),(184,'Gorlice',1184,7),(185,'Gorzów Śląski',1185,8),(186,'Gorzów Wielkopolski',1186,4),(187,'Gostynin',1187,6),(188,'Gostyń',1188,15),(189,'Gościno',1189,16),(190,'Gozdnica',1190,4),(191,'Góra',1191,1),(192,'Góra Kalwaria',1192,6),(193,'Górowo Iławeckie',1193,14),(194,'Górzno',1194,2),(195,'Grabów nad Prosną',1195,15),(196,'Grajewo',1196,10),(197,'Grodków',1197,8),(198,'Grodzisk Mazowiecki',1198,6),(199,'Grodzisk Wielkopolski',1199,15),(200,'Grójec',1200,6),(201,'Grudziądz',1201,2),(202,'Grybów',1202,7),(203,'Gryfice',1203,16),(204,'Gryfino',1204,16),(205,'Gryfów Śląski',1205,1),(206,'Gubin',1206,4),(207,'Hajnówka',1207,10),(208,'Halinów',1208,6),(209,'Hel',1209,11),(210,'Hrubieszów',1210,3),(211,'Iława',1211,14),(212,'Iłowa',1212,4),(213,'Iłża',1213,6),(214,'Imielin',1214,12),(215,'Inowrocław',1215,2),(216,'Ińsko',1216,16),(217,'Iwonicz-Zdrój',1217,9),(218,'Izbica Kujawska',1218,2),(219,'Jabłonowo Pomorskie',1219,2),(220,'Janikowo',1220,2),(221,'Janowiec Wielkopolski',1221,2),(222,'Janów Lubelski',1222,3),(223,'Jarocin',1223,15),(224,'Jarosław',1224,9),(225,'Jasień',1225,4),(226,'Jasło',1226,9),(227,'Jastarnia',1227,11),(228,'Jastrowie',1228,15),(229,'Jastrzębie-Zdrój',1229,12),(230,'Jawor',1230,1),(231,'Jaworzno',1231,12),(232,'Jaworzyna Śląska',1232,1),(233,'Jedlicze',1233,9),(234,'Jedlina-Zdrój',1234,1),(235,'Jedwabne',1235,10),(236,'Jelcz-Laskowice',1236,1),(237,'Jelenia Góra',1237,1),(238,'Jeziorany',1238,14),(239,'Jędrzejów',1239,13),(240,'Jordanów',1240,7),(241,'Józefów',1241,3),(242,'Józefów',1242,6),(243,'Jutrosin',1243,15),(244,'Kalety',1244,12),(245,'Kalisz',1245,15),(246,'Kalisz Pomorski',1246,16),(247,'Kalwaria Zebrzydowska',1247,7),(248,'Kałuszyn',1248,6),(249,'Kamienna Góra',1249,1),(250,'Kamień Krajeński',1250,2),(251,'Kamień Pomorski',1251,16),(252,'Kamieńsk',1252,5),(253,'Kańczuga',1253,9),(254,'Karczew',1254,6),(255,'Kargowa',1255,4),(256,'Karlino',1256,16),(257,'Karpacz',1257,1),(258,'Kartuzy',1258,11),(259,'Katowice',1259,12),(260,'Kazimierz Dolny',1260,3),(261,'Kazimierza Wielka',1261,13),(262,'Kąty Wrocławskie',1262,1),(263,'Kcynia',1263,2),(264,'Kędzierzyn-Koźle',1264,8),(265,'Kępice',1265,11),(266,'Kępno',1266,15),(267,'Kętrzyn',1267,14),(268,'Kęty',1268,7),(269,'Kielce',7,13),(270,'Kietrz',1270,8),(271,'Kisielice',1271,14),(272,'Kleczew',1272,15),(273,'Kleszczele',1273,10),(274,'Kluczbork',1274,8),(275,'Kłecko',1275,15),(276,'Kłobuck',1276,12),(277,'Kłodawa',1277,15),(278,'Kłodzko',1278,1),(279,'Knurów',1279,12),(280,'Knyszyn',1280,10),(281,'Kobylin',1281,15),(282,'Kobyłka',1282,6),(283,'Kock',1283,3),(284,'Kolbuszowa',1284,9),(285,'Kolno',1285,10),(286,'Kolonowskie',1286,8),(287,'Koluszki',1287,5),(288,'Kołaczyce',1288,9),(289,'Koło',1289,15),(290,'Kołobrzeg',1290,16),(291,'Koniecpol',1291,12),(292,'Konin',1292,15),(293,'Konstancin-Jeziorna',1293,6),(294,'Konstantynów Łódzki',1294,5),(295,'Końskie',1295,13),(296,'Koprzywnica',1296,13),(297,'Korfantów',1297,8),(298,'Koronowo',1298,2),(299,'Korsze',1299,14),(300,'Kosów Lacki',1300,6),(301,'Kostrzyn',1301,15),(302,'Kostrzyn nad Odrą',1302,4),(303,'Koszalin',1303,16),(304,'Kościan',1304,15),(305,'Kościerzyna',1305,11),(306,'Kowal',1306,2),(307,'Kowalewo Pomorskie',1307,2),(308,'Kowary',1308,1),(309,'Koziegłowy',1309,12),(310,'Kozienice',1310,6),(311,'Koźmin Wielkopolski',1311,15),(312,'Kożuchów',1312,4),(313,'Kórnik',1313,15),(314,'Krajenka',1314,15),(315,'Kraków',9,7),(316,'Krapkowice',1316,8),(317,'Krasnobród',1317,3),(318,'Krasnystaw',1318,3),(319,'Kraśnik',1319,3),(320,'Krobia',1320,15),(321,'Krosno',1321,9),(322,'Krosno Odrzańskie',1322,4),(323,'Krośniewice',1323,5),(324,'Krotoszyn',1324,15),(325,'Kruszwica',1325,2),(326,'Krynica Morska',1326,11),(327,'Krynica-Zdrój',1327,7),(328,'Krynki',1328,10),(329,'Krzanowice',1329,12),(330,'Krzepice',1330,12),(331,'Krzeszowice',1331,7),(332,'Krzywiń',1332,15),(333,'Krzyż Wielkopolski',1333,15),(334,'Książ Wielkopolski',1334,15),(335,'Kudowa-Zdrój',1335,1),(336,'Kunów',1336,13),(337,'Kutno',1337,5),(338,'Kuźnia Raciborska',1338,12),(339,'Kwidzyn',1339,11),(340,'Lądek-Zdrój',1340,1),(341,'Legionowo',1341,6),(342,'Legnica',1342,1),(343,'Lesko',1343,9),(344,'Leszno',1344,15),(345,'Leśna',1345,1),(346,'Leśnica',1346,8),(347,'Lewin Brzeski',1347,8),(348,'Leżajsk',1348,9),(349,'Lębork',1349,11),(350,'Lędziny',1350,12),(351,'Libiąż',1351,7),(352,'Lidzbark',1352,14),(353,'Lidzbark Warmiński',1353,14),(354,'Limanowa',1354,7),(355,'Lipiany',1355,16),(356,'Lipno',1356,2),(357,'Lipsk',1357,10),(358,'Lipsko',1358,6),(359,'Lubaczów',1359,9),(360,'Lubań',1360,1),(361,'Lubartów',1361,3),(362,'Lubawa',1362,14),(363,'Lubawka',1363,1),(364,'Lubień Kujawski',1364,2),(365,'Lubin',1365,1),(366,'Lublin',10,3),(367,'Lubliniec',1367,12),(368,'Lubniewice',1368,4),(369,'Lubomierz',1369,1),(370,'Luboń',1370,15),(371,'Lubraniec',1371,2),(372,'Lubsko',1372,4),(373,'Lwówek',1373,15),(374,'Lwówek Śląski',1374,1),(375,'Łabiszyn',1375,2),(376,'Łańcut',1376,9),(377,'Łapy',1377,10),(378,'Łasin',1378,2),(379,'Łask',1379,5),(380,'Łaskarzew',1380,6),(381,'Łaszczów',1381,3),(382,'Łaziska Górne',1382,12),(383,'Łazy',1383,12),(384,'Łeba',1384,11),(385,'Łęczna',1385,3),(386,'Łęczyca',1386,5),(387,'Łęknica',1387,4),(388,'Łobez',1388,16),(389,'Łobżenica',1389,15),(390,'Łochów',1390,6),(391,'Łomianki',1391,6),(392,'Łomża',1392,10),(393,'Łosice',1393,6),(394,'Łowicz',1394,5),(395,'Łódź',11,5),(396,'Łuków',1396,3),(397,'Maków Mazowiecki',1397,6),(398,'Maków Podhalański',1398,7),(399,'Malbork',1399,11),(400,'Małogoszcz',1400,13),(401,'Małomice',1401,4),(402,'Margonin',1402,15),(403,'Marki',1403,6),(404,'Maszewo',1404,16),(405,'Miasteczko Śląskie',1405,12),(406,'Miastko',1406,11),(407,'Michałowo',1407,10),(408,'Miechów',1408,7),(409,'Miejska Górka',1409,15),(410,'Mielec',1410,9),(411,'Mieroszów',1411,1),(412,'Mieszkowice',1412,16),(413,'Międzybórz',1413,1),(414,'Międzychód',1414,15),(415,'Międzylesie',1415,1),(416,'Międzyrzec Podlaski',1416,3),(417,'Międzyrzecz',1417,4),(418,'Międzyzdroje',1418,16),(419,'Mikołajki',1419,14),(420,'Mikołów',1420,12),(421,'Mikstat',1421,15),(422,'Milanówek',1422,6),(423,'Milicz',1423,1),(424,'Miłakowo',1424,14),(425,'Miłomłyn',1425,14),(426,'Miłosław',1426,15),(427,'Mińsk Mazowiecki',1427,6),(428,'Mirosławiec',1428,16),(429,'Mirsk',1429,1),(430,'Mława',1430,6),(431,'Młynary',1431,14),(432,'Mogielnica',1432,6),(433,'Mogilno',1433,2),(434,'Mońki',1434,10),(435,'Morąg',1435,14),(436,'Mordy',1436,6),(437,'Moryń',1437,16),(438,'Mosina',1438,15),(439,'Mrągowo',1439,14),(440,'Mrocza',1440,2),(441,'Mszana Dolna',1441,7),(442,'Mszczonów',1442,6),(443,'Murowana Goślina',1443,15),(444,'Muszyna',1444,7),(445,'Mysłowice',1445,12),(446,'Myszków',1446,12),(447,'Myszyniec',1447,6),(448,'Myślenice',1448,7),(449,'Myślibórz',1449,16),(450,'Nakło nad Notecią',1450,2),(451,'Nałęczów',1451,3),(452,'Namysłów',1452,8),(453,'Narol',1453,9),(454,'Nasielsk',1454,6),(455,'Nekla',1455,15),(456,'Nidzica',1456,14),(457,'Niemcza',1457,1),(458,'Niemodlin',1458,8),(459,'Niepołomice',1459,7),(460,'Nieszawa',1460,2),(461,'Nisko',1461,9),(462,'Nowa Dęba',1462,9),(463,'Nowa Ruda',1463,1),(464,'Nowa Sarzyna',1464,9),(465,'Nowa Sól',1465,4),(466,'Nowe',1466,2),(467,'Nowe Brzesko',1467,7),(468,'Nowe Miasteczko',1468,4),(469,'Nowe Miasto Lubawskie',1469,14),(470,'Nowe Miasto nad Pilicą',1470,6),(471,'Nowe Skalmierzyce',1471,15),(472,'Nowe Warpno',1472,16),(473,'Nowogard',1473,16),(474,'Nowogrodziec',1474,1),(475,'Nowogród',1475,10),(476,'Nowogród Bobrzański',1476,4),(477,'Nowy Dwór Gdański',1477,11),(478,'Nowy Dwór Mazowiecki',1478,6),(479,'Nowy Sącz',1479,7),(480,'Nowy Staw',1480,11),(481,'Nowy Targ',1481,7),(482,'Nowy Tomyśl',1482,15),(483,'Nowy Wiśnicz',1483,7),(484,'Nysa',1484,8),(485,'Oborniki',1485,15),(486,'Oborniki Śląskie',1486,1),(487,'Obrzycko',1487,15),(488,'Odolanów',1488,15),(489,'Ogrodzieniec',1489,12),(490,'Okonek',1490,15),(491,'Olecko',1491,14),(492,'Olesno',1492,8),(493,'Oleszyce',1493,9),(494,'Oleśnica',1494,1),(495,'Olkusz',1495,7),(496,'Olsztyn',12,14),(497,'Olsztynek',1497,14),(498,'Olszyna',1498,1),(499,'Oława',1499,1),(500,'Opalenica',1500,15),(501,'Opatów',1501,13),(502,'Opoczno',1502,5),(503,'Opole',13,8),(504,'Opole Lubelskie',1504,3),(505,'Orneta',1505,14),(506,'Orzesze',1506,12),(507,'Orzysz',1507,14),(508,'Osieczna',1508,15),(509,'Osiek',1509,13),(510,'Ostrołęka',1510,6),(511,'Ostroróg',1511,15),(512,'Ostrowiec Świętokrzyski',1512,13),(513,'Ostróda',1513,14),(514,'Ostrów Lubelski',1514,3),(515,'Ostrów Mazowiecka',1515,6),(516,'Ostrów Wielkopolski',1516,15),(517,'Ostrzeszów',1517,15),(518,'Ośno Lubuskie',1518,4),(519,'Oświęcim',1519,7),(520,'Otmuchów',1520,8),(521,'Otwock',1521,6),(522,'Ozimek',1522,8),(523,'Ozorków',1523,5),(524,'Ożarów',1524,13),(525,'Ożarów Mazowiecki',1525,6),(526,'Pabianice',1526,5),(527,'Paczków',1527,8),(528,'Pajęczno',1528,5),(529,'Pakość',1529,2),(530,'Parczew',1530,3),(531,'Pasłęk',1531,14),(532,'Pasym',1532,14),(533,'Pelplin',1533,11),(534,'Pełczyce',1534,16),(535,'Piaseczno',1535,6),(536,'Piaski',1536,3),(537,'Piastów',1537,6),(538,'Piechowice',1538,1),(539,'Piekary Śląskie',1539,12),(540,'Pieniężno',1540,14),(541,'Pieńsk',1541,1),(542,'Pieszyce',1542,1),(543,'Pilawa',1543,6),(544,'Pilica',1544,12),(545,'Pilzno',1545,9),(546,'Piła',1546,15),(547,'Piława Górna',1547,1),(548,'Pińczów',1548,13),(549,'Pionki',1549,6),(550,'Piotrków Kujawski',1550,2),(551,'Piotrków Trybunalski',1551,5),(552,'Pisz',1552,14),(553,'Piwniczna-Zdrój',1553,7),(554,'Pleszew',1554,15),(555,'Płock',1555,6),(556,'Płońsk',1556,6),(557,'Płoty',1557,16),(558,'Pniewy',1558,15),(559,'Pobiedziska',1559,15),(560,'Poddębice',1560,5),(561,'Podkowa Leśna',1561,6),(562,'Pogorzela',1562,15),(563,'Polanica-Zdrój',1563,1),(564,'Polanów',1564,16),(565,'Police',1565,16),(566,'Polkowice',1566,1),(567,'Połaniec',1567,13),(568,'Połczyn-Zdrój',1568,16),(569,'Poniatowa',1569,3),(570,'Poniec',1570,15),(571,'Poręba',1571,12),(572,'Poznań',14,15),(573,'Prabuty',1573,11),(574,'Praszka',1574,8),(575,'Prochowice',1575,1),(576,'Proszowice',1576,7),(577,'Prószków',1577,8),(578,'Pruchnik',1578,9),(579,'Prudnik',1579,8),(580,'Prusice',1580,1),(581,'Pruszcz Gdański',1581,11),(582,'Pruszków',1582,6),(583,'Przasnysz',1583,6),(584,'Przecław',1584,9),(585,'Przedbórz',1585,5),(586,'Przedecz',1586,15),(587,'Przemków',1587,1),(588,'Przemyśl',1588,9),(589,'Przeworsk',1589,9),(590,'Przysucha',1590,6),(591,'Pszczyna',1591,12),(592,'Pszów',1592,12),(593,'Puck',1593,11),(594,'Puławy',1594,3),(595,'Pułtusk',1595,6),(596,'Puszczykowo',1596,15),(597,'Pyrzyce',1597,16),(598,'Pyskowice',1598,12),(599,'Pyzdry',1599,15),(600,'Rabka-Zdrój',1600,7),(601,'Raciąż',1601,6),(602,'Racibórz',1602,12),(603,'Radków',1603,1),(604,'Radlin',1604,12),(605,'Radłów',1605,7),(606,'Radom',15,6),(607,'Radomsko',1607,5),(608,'Radomyśl Wielki',1608,9),(609,'Radymno',1609,9),(610,'Radziejów',1610,2),(611,'Radzionków',1611,12),(612,'Radzymin',1612,6),(613,'Radzyń Chełmiński',1613,2),(614,'Radzyń Podlaski',1614,3),(615,'Rajgród',1615,10),(616,'Rakoniewice',1616,15),(617,'Raszków',1617,15),(618,'Rawa Mazowiecka',1618,5),(619,'Rawicz',1619,15),(620,'Recz',1620,16),(621,'Reda',1621,11),(622,'Rejowiec Fabryczny',1622,3),(623,'Resko',1623,16),(624,'Reszel',1624,14),(625,'Rogoźno',1625,15),(626,'Ropczyce',1626,9),(627,'Różan',1627,6),(628,'Ruciane-Nida',1628,14),(629,'Ruda Śląska',1629,12),(630,'Rudnik nad Sanem',1630,9),(631,'Rumia',1631,11),(632,'Rybnik',1632,12),(633,'Rychwał',1633,15),(634,'Rydułtowy',1634,12),(635,'Rydzyna',1635,15),(636,'Ryglice',1636,7),(637,'Ryki',1637,3),(638,'Rymanów',1638,9),(639,'Ryn',1639,14),(640,'Rypin',1640,2),(641,'Rzepin',1641,4),(642,'Rzeszów',16,9),(643,'Rzgów',1643,5),(644,'Sandomierz',1644,13),(645,'Sanok',1645,9),(646,'Sejny',1646,10),(647,'Serock',1647,6),(648,'Sędziszów',1648,13),(649,'Sędziszów Małopolski',1649,9),(650,'Sępopol',1650,14),(651,'Sępólno Krajeńskie',1651,2),(652,'Sianów',1652,16),(653,'Siechnice',1653,1),(654,'Siedlce',1654,6),(655,'Siemianowice Śląskie',1655,12),(656,'Siemiatycze',1656,10),(657,'Sieniawa',1657,9),(658,'Sieradz',1658,5),(659,'Sieraków',1659,15),(660,'Sierpc',1660,6),(661,'Siewierz',1661,12),(662,'Skalbmierz',1662,13),(663,'Skała',1663,7),(664,'Skarszewy',1664,11),(665,'Skaryszew',1665,6),(666,'Skarżysko-Kamienna',1666,13),(667,'Skawina',1667,7),(668,'Skępe',1668,2),(669,'Skierniewice',1669,5),(670,'Skoczów',1670,12),(671,'Skoki',1671,15),(672,'Skórcz',1672,11),(673,'Skwierzyna',1673,4),(674,'Sława',1674,4),(675,'Sławków',1675,12),(676,'Sławno',1676,16),(677,'Słomniki',1677,7),(678,'Słubice',1678,4),(679,'Słupca',1679,15),(680,'Słupsk',1680,11),(681,'Sobótka',1681,1),(682,'Sochaczew',1682,6),(683,'Sokołów Małopolski',1683,9),(684,'Sokołów Podlaski',1684,6),(685,'Sokółka',1685,10),(686,'Solec Kujawski',1686,2),(687,'Sompolno',1687,15),(688,'Sopot',1688,11),(689,'Sosnowiec',1689,12),(690,'Sośnicowice',1690,12),(691,'Stalowa Wola',1691,9),(692,'Starachowice',1692,13),(693,'Stargard Szczeciński',1693,16),(694,'Starogard Gdański',1694,11),(695,'Stary Sącz',1695,7),(696,'Staszów',1696,13),(697,'Stawiski',1697,10),(698,'Stawiszyn',1698,15),(699,'Stąporków',1699,13),(700,'Stęszew',1700,15),(701,'Stoczek Łukowski',1701,3),(702,'Stronie Śląskie',1702,1),(703,'Strumień',1703,12),(704,'Stryków',1704,5),(705,'Strzegom',1705,1),(706,'Strzelce Krajeńskie',1706,4),(707,'Strzelce Opolskie',1707,8),(708,'Strzelin',1708,1),(709,'Strzelno',1709,2),(710,'Strzyżów',1710,9),(711,'Sucha Beskidzka',1711,7),(712,'Suchań',1712,16),(713,'Suchedniów',1713,13),(714,'Suchowola',1714,10),(715,'Sulechów',1715,4),(716,'Sulejów',1716,5),(717,'Sulejówek',1717,6),(718,'Sulęcin',1718,4),(719,'Sulmierzyce',1719,15),(720,'Sułkowice',1720,7),(721,'Supraśl',1721,10),(722,'Suraż',1722,10),(723,'Susz',1723,14),(724,'Suwałki',1724,10),(725,'Swarzędz',1725,15),(726,'Syców',1726,1),(727,'Szadek',1727,5),(728,'Szamocin',1728,15),(729,'Szamotuły',1729,15),(730,'Szczawnica',1730,7),(731,'Szczawno-Zdrój',1731,1),(732,'Szczebrzeszyn',1732,3),(733,'Szczecin',8,16),(734,'Szczecinek',1734,16),(735,'Szczekociny',1735,12),(736,'Szczucin',1736,7),(737,'Szczuczyn',1737,10),(738,'Szczyrk',1738,12),(739,'Szczytna',1739,1),(740,'Szczytno',1740,14),(741,'Szepietowo',1741,10),(742,'Szklarska Poręba',1742,1),(743,'Szlichtyngowa',1743,4),(744,'Szprotawa',1744,4),(745,'Sztum',1745,11),(746,'Szubin',1746,2),(747,'Szydłowiec',1747,6),(748,'Ścinawa',1748,1),(749,'Ślesin',1749,15),(750,'Śmigiel',1750,15),(751,'Śrem',1751,15),(752,'Środa Śląska',1752,1),(753,'Środa Wielkopolska',1753,15),(754,'Świątniki Górne',1754,7),(755,'Świdnica',1755,1),(756,'Świdnik',1756,3),(757,'Świdwin',1757,16),(758,'Świebodzice',1758,1),(759,'Świebodzin',1759,4),(760,'Świecie',1760,2),(761,'Świeradów-Zdrój',1761,1),(762,'Świerzawa',1762,1),(763,'Świętochłowice',1763,12),(764,'Świnoujście',1764,16),(765,'Tarczyn',1765,6),(766,'Tarnobrzeg',1766,9),(767,'Tarnogród',1767,3),(768,'Tarnowskie Góry',1768,12),(769,'Tarnów',1769,7),(770,'Tczew',1770,11),(771,'Terespol',1771,3),(772,'Tłuszcz',1772,6),(773,'Tolkmicko',1773,14),(774,'Tomaszów Lubelski',1774,3),(775,'Tomaszów Mazowiecki',1775,5),(776,'Toruń',17,2),(777,'Torzym',1777,4),(778,'Toszek',1778,12),(779,'Trzcianka',1779,15),(780,'Trzciel',1780,4),(781,'Trzcińsko-Zdrój',1781,16),(782,'Trzebiatów',1782,16),(783,'Trzebinia',1783,7),(784,'Trzebnica',1784,1),(785,'Trzemeszno',1785,15),(786,'Tuchola',1786,2),(787,'Tuchów',1787,7),(788,'Tuczno',1788,16),(789,'Tuliszków',1789,15),(790,'Turek',1790,15),(791,'Tuszyn',1791,5),(792,'Twardogóra',1792,1),(793,'Tychowo',1793,16),(794,'Tychy',1794,12),(795,'Tyczyn',1795,9),(796,'Tykocin',1796,10),(797,'Tyszowce',1797,3),(798,'Ujazd',1798,8),(799,'Ujście',1799,15),(800,'Ulanów',1800,9),(801,'Uniejów',1801,5),(802,'Ustka',1802,11),(803,'Ustroń',1803,12),(804,'Ustrzyki Dolne',1804,9),(805,'Wadowice',1805,7),(806,'Wałbrzych',1806,1),(807,'Wałcz',1807,16),(808,'Warka',1808,6),(809,'Warszawa',1,6),(810,'Warta',1810,5),(811,'Wasilków',1811,10),(812,'Wąbrzeźno',1812,2),(813,'Wąchock',1813,13),(814,'Wągrowiec',1814,15),(815,'Wąsosz',1815,1),(816,'Wejherowo',1816,11),(817,'Węgliniec',1817,1),(818,'Węgorzewo',1818,14),(819,'Węgorzyno',1819,16),(820,'Węgrów',1820,6),(821,'Wiązów',1821,1),(822,'Wieleń',1822,15),(823,'Wielichowo',1823,15),(824,'Wieliczka',1824,7),(825,'Wieluń',1825,5),(826,'Wieruszów',1826,5),(827,'Więcbork',1827,2),(828,'Wilamowice',1828,12),(829,'Wisła',1829,12),(830,'Witkowo',1830,15),(831,'Witnica',1831,4),(832,'Wleń',1832,1),(833,'Władysławowo',1833,11),(834,'Włocławek',1834,2),(835,'Włodawa',1835,3),(836,'Włoszczowa',1836,13),(837,'Wodzisław Śląski',1837,12),(838,'Wojcieszów',1838,1),(839,'Wojkowice',1839,12),(840,'Wojnicz',1840,7),(841,'Wolbórz',1841,5),(842,'Wolbrom',1842,7),(843,'Wolin',1843,16),(844,'Wolsztyn',1844,15),(845,'Wołczyn',1845,8),(846,'Wołomin',1846,6),(847,'Wołów',1847,1),(848,'Woźniki',1848,12),(849,'Wrocław',18,1),(850,'Wronki',1850,15),(851,'Września',1851,15),(852,'Wschowa',1852,4),(853,'Wyrzysk',1853,15),(854,'Wysoka',1854,15),(855,'Wysokie Mazowieckie',1855,10),(856,'Wyszków',1856,6),(857,'Wyszogród',1857,6),(858,'Wyśmierzyce',1858,6),(859,'Zabłudów',1859,10),(860,'Zabrze',1860,12),(861,'Zagórów',1861,15),(862,'Zagórz',1862,9),(863,'Zakliczyn',1863,7),(864,'Zakopane',1864,7),(865,'Zakroczym',1865,6),(866,'Zalewo',1866,14),(867,'Zambrów',1867,10),(868,'Zamość',1868,3),(869,'Zator',1869,7),(870,'Zawadzkie',1870,8),(871,'Zawichost',1871,13),(872,'Zawidów',1872,1),(873,'Zawiercie',1873,12),(874,'Ząbki',1874,6),(875,'Ząbkowice Śląskie',1875,1),(876,'Zbąszynek',1876,4),(877,'Zbąszyń',1877,15),(878,'Zduny',1878,15),(879,'Zduńska Wola',1879,5),(880,'Zdzieszowice',1880,8),(881,'Zelów',1881,5),(882,'Zgierz',1882,5),(883,'Zgorzelec',1883,1),(884,'Zielona Góra',1884,4),(885,'Zielonka',1885,6),(886,'Ziębice',1886,1),(887,'Złocieniec',1887,16),(888,'Złoczew',1888,5),(889,'Złotoryja',1889,1),(890,'Złotów',1890,15),(891,'Złoty Stok',1891,1),(892,'Zwierzyniec',1892,3),(893,'Zwoleń',1893,6),(894,'Żabno',1894,7),(895,'Żagań',1895,4),(896,'Żarki',1896,12),(897,'Żarów',1897,1),(898,'Żary',1898,4),(899,'Żelechów',1899,6),(900,'Żerków',1900,15),(901,'Żmigród',1901,1),(902,'Żnin',1902,2),(903,'Żory',1903,12),(904,'Żukowo',1904,11),(905,'Żuromin',1905,6),(906,'Żychlin',1906,5),(907,'Żyrardów',1907,6),(908,'Żywiec',1908,12),(909,'Trójmiasto',3,11),(910,'Okręg Katowicki',2,12);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counter` (
  `ID` bigint(20) NOT NULL,
  `CLASS_NAME` varchar(40) COLLATE utf8_polish_ci NOT NULL,
  `LAST_NUMBER` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `CLASS_NAME` (`CLASS_NAME`),
  UNIQUE KEY `CLASS_NAME_2` (`CLASS_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
INSERT INTO `counter` VALUES (1,'com.omn.mpfactory.model.State',399);
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(60) COLLATE utf8_polish_ci DEFAULT NULL,
  `CITY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FK3FDF238E14C86091` (`CITY_ID`),
  CONSTRAINT `FK3FDF238E14C86091` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincecapital`
--

DROP TABLE IF EXISTS `provincecapital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincecapital` (
  `ID` bigint(20) NOT NULL,
  `CITY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FKprovincecapital01` (`CITY_ID`),
  CONSTRAINT `FKprovincecapital01` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincecapital`
--

LOCK TABLES `provincecapital` WRITE;
/*!40000 ALTER TABLE `provincecapital` DISABLE KEYS */;
INSERT INTO `provincecapital` VALUES (12,26),(2,72),(5,186),(15,269),(8,315),(4,366),(7,395),(16,496),(10,503),(17,572),(11,642),(18,733),(3,776),(9,809),(1,849),(6,884),(13,909),(14,910);
/*!40000 ALTER TABLE `provincecapital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(60) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `idx_state_NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Dolnośląskie'),(2,'Kujawsko-Pomorskie'),(3,'Lubelskie'),(4,'Lubuskie'),(5,'Łódzkie'),(7,'Małopolskie'),(6,'Mazowieckie'),(8,'Opolskie'),(9,'Podkarpackie'),(10,'Podlaskie'),(11,'Pomorskie'),(12,'Śląskie'),(13,'Świętokrzyskie'),(14,'Warmińsko-Mazurskie'),(15,'Wielkopolskie'),(16,'Zachodniopomorskie');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-23 22:32:10



insert into mpfactory.district(id, name, CITY_ID) values(1,'Bemowo',809);
insert into mpfactory.district(id, name, CITY_ID) values(2,'Białołęka',809);
insert into mpfactory.district(id, name, CITY_ID) values(3,'Bielany',809);
insert into mpfactory.district(id, name, CITY_ID) values(4,'Mokotów',809);
insert into mpfactory.district(id, name, CITY_ID) values(5,'Ochota',809);
insert into mpfactory.district(id, name, CITY_ID) values(6,'Praga-Południe',809);
insert into mpfactory.district(id, name, CITY_ID) values(7,'Praga-Północ',809);
insert into mpfactory.district(id, name, CITY_ID) values(8,'Rembertów',809);
insert into mpfactory.district(id, name, CITY_ID) values(9,'Śródmieście',809);
insert into mpfactory.district(id, name, CITY_ID) values(10,'Targówek',809);
insert into mpfactory.district(id, name, CITY_ID) values(11,'Ursus',809);
insert into mpfactory.district(id, name, CITY_ID) values(12,'Ursynów',809);
insert into mpfactory.district(id, name, CITY_ID) values(13,'Wawer',809);
insert into mpfactory.district(id, name, CITY_ID) values(14,'Wesoła',809);
insert into mpfactory.district(id, name, CITY_ID) values(15,'Wilanów',809);
insert into mpfactory.district(id, name, CITY_ID) values(16,'Włochy',809);
insert into mpfactory.district(id, name, CITY_ID) values(17,'Wola',809);
insert into mpfactory.district(id, name, CITY_ID) values(18,'Żoliborz',809);


insert into mpfactory.district(id, name, CITY_ID) values(19,'Bałuty',809);
insert into mpfactory.district(id, name, CITY_ID) values(20,'Górna',809);
insert into mpfactory.district(id, name, CITY_ID) values(21,'Polesie',809);
insert into mpfactory.district(id, name, CITY_ID) values(22,'Śródmieście',809);
insert into mpfactory.district(id, name, CITY_ID) values(23,'Widzew',809);





insert into mpfactory.district(id, name, CITY_ID) values(24,'Antoniuk',26);
insert into mpfactory.district(id, name, CITY_ID) values(25,'Bacieczki',26);
insert into mpfactory.district(id, name, CITY_ID) values(26,'Bema',26);
insert into mpfactory.district(id, name, CITY_ID) values(27,'Białostoczek',26);
insert into mpfactory.district(id, name, CITY_ID) values(28,'Bojary',26);
insert into mpfactory.district(id, name, CITY_ID) values(29,'Centrum',26);
insert into mpfactory.district(id, name, CITY_ID) values(30,'Dojlidy',26);
insert into mpfactory.district(id, name, CITY_ID) values(31,'Dojlidy Górne',26);
insert into mpfactory.district(id, name, CITY_ID) values(32,'Dziesięciny I',26);
insert into mpfactory.district(id, name, CITY_ID) values(33,'Dziesięciny II',26);
insert into mpfactory.district(id, name, CITY_ID) values(34,'Jaroszówka',26);
insert into mpfactory.district(id, name, CITY_ID) values(35,'Kawaleryjskie',26);
insert into mpfactory.district(id, name, CITY_ID) values(36,'Leśna Dolina',26);
insert into mpfactory.district(id, name, CITY_ID) values(37,'Mickiewicza',26);
insert into mpfactory.district(id, name, CITY_ID) values(38,'Młodych',26);
insert into mpfactory.district(id, name, CITY_ID) values(39,'Nowe Miasto',26);
insert into mpfactory.district(id, name, CITY_ID) values(40,'Piaski',26);
insert into mpfactory.district(id, name, CITY_ID) values(41,'Piasta I',26);
insert into mpfactory.district(id, name, CITY_ID) values(42,'Piasta II',26);
insert into mpfactory.district(id, name, CITY_ID) values(43,'Przydworcowe',26);
insert into mpfactory.district(id, name, CITY_ID) values(44,'Sienkiewicza',26);
insert into mpfactory.district(id, name, CITY_ID) values(45,'Skorupy',26);
insert into mpfactory.district(id, name, CITY_ID) values(46,'Słoneczny Stok',26);
insert into mpfactory.district(id, name, CITY_ID) values(47,'Starosielce',26);
insert into mpfactory.district(id, name, CITY_ID) values(48,'Wygoda',26);
insert into mpfactory.district(id, name, CITY_ID) values(49,'Wysoki Stoczek',26);
insert into mpfactory.district(id, name, CITY_ID) values(50,'Zawady',26);
insert into mpfactory.district(id, name, CITY_ID) values(51,'Zielone Wzgórza',26);


insert into mpfactory.district(id, name, CITY_ID) values(52,'Dolny Taras',72);
insert into mpfactory.district(id, name, CITY_ID) values(53,'Górny Taras',72);
insert into mpfactory.district(id, name, CITY_ID) values(54,'Północny Pas Rekreacyjny',72);
insert into mpfactory.district(id, name, CITY_ID) values(55,'Południowo-wschodnia dzielnica',72);
insert into mpfactory.district(id, name, CITY_ID) values(56,'Wschodnia dzielnica',72);
insert into mpfactory.district(id, name, CITY_ID) values(57,'Zachodnie osiedla',72);




insert into mpfactory.district(id, name, CITY_ID) values(58,'Błeszno',116);
insert into mpfactory.district(id, name, CITY_ID) values(59,'Częstochówka-Parkitka',116);
insert into mpfactory.district(id, name, CITY_ID) values(60,'Dźbów',116);
insert into mpfactory.district(id, name, CITY_ID) values(61,'Gnaszyn-Kawodrza',116);
insert into mpfactory.district(id, name, CITY_ID) values(62,'Grabówka',116);
insert into mpfactory.district(id, name, CITY_ID) values(63,'Kiedrzyn',116);
insert into mpfactory.district(id, name, CITY_ID) values(64,'Lisiniec',116);
insert into mpfactory.district(id, name, CITY_ID) values(65,'Mirów',116);
insert into mpfactory.district(id, name, CITY_ID) values(66,'Ostatni Grosz',116);
insert into mpfactory.district(id, name, CITY_ID) values(67,'Podjasnogórska',116);
insert into mpfactory.district(id, name, CITY_ID) values(68,'Północ',116);
insert into mpfactory.district(id, name, CITY_ID) values(69,'Raków',116);
insert into mpfactory.district(id, name, CITY_ID) values(70,'Stare Miasto',116);
insert into mpfactory.district(id, name, CITY_ID) values(71,'Stradom',116);
insert into mpfactory.district(id, name, CITY_ID) values(72,'Śródmieście',116);
insert into mpfactory.district(id, name, CITY_ID) values(73,'Trzech Wieszczów',116);
insert into mpfactory.district(id, name, CITY_ID) values(74,'Tysiąclecie',116);
insert into mpfactory.district(id, name, CITY_ID) values(75,'Wrzosowiak',116);
insert into mpfactory.district(id, name, CITY_ID) values(76,'Wyczerpy-Aniołów',116);
insert into mpfactory.district(id, name, CITY_ID) values(77,'Zawodzie-Dąbie',116);










insert into mpfactory.district(id, name, CITY_ID) values(78,'Baranówek',269);
insert into mpfactory.district(id, name, CITY_ID) values(79,'Barwinek',269);
insert into mpfactory.district(id, name, CITY_ID) values(80,'Białogon',269);
insert into mpfactory.district(id, name, CITY_ID) values(81,'Biesak',269);
insert into mpfactory.district(id, name, CITY_ID) values(82,'Bocianek',269);
insert into mpfactory.district(id, name, CITY_ID) values(83,'Bukówka',269);
insert into mpfactory.district(id, name, CITY_ID) values(84,'Cedro Mazur',269);
insert into mpfactory.district(id, name, CITY_ID) values(85,'Cegielnia',269);
insert into mpfactory.district(id, name, CITY_ID) values(86,'Centrum',269);
insert into mpfactory.district(id, name, CITY_ID) values(87,'Czarnów',269);
insert into mpfactory.district(id, name, CITY_ID) values(88,'Dąbrowa',269);
insert into mpfactory.district(id, name, CITY_ID) values(89,'Dobromyśl',269);
insert into mpfactory.district(id, name, CITY_ID) values(90,'Domaszowice Wikaryjskie',269);
insert into mpfactory.district(id, name, CITY_ID) values(91,'Dyminy',269);
insert into mpfactory.district(id, name, CITY_ID) values(92,'Herby',269);
insert into mpfactory.district(id, name, CITY_ID) values(93,'Jagiellońskie',269);
insert into mpfactory.district(id, name, CITY_ID) values(94,'Karczówka',269);
insert into mpfactory.district(id, name, CITY_ID) values(95,'KSM',269);
insert into mpfactory.district(id, name, CITY_ID) values(96,'Łazy',269);
insert into mpfactory.district(id, name, CITY_ID) values(97,'Na Stoku',269);
insert into mpfactory.district(id, name, CITY_ID) values(98,'Nowy Folwark',269);
insert into mpfactory.district(id, name, CITY_ID) values(99,'Niewachlów I',269);
insert into mpfactory.district(id, name, CITY_ID) values(100,'Niewachlów II',269);
insert into mpfactory.district(id, name, CITY_ID) values(101,'Osiedle Jana Czarnockiego',269);
insert into mpfactory.district(id, name, CITY_ID) values(102,'Osiedle Jana Kochanowskiego',269);
insert into mpfactory.district(id, name, CITY_ID) values(103,'Osiedle Związkowiec',269);
insert into mpfactory.district(id, name, CITY_ID) values(104,'Ostra Górka',269);
insert into mpfactory.district(id, name, CITY_ID) values(105,'Pakosz',269);
insert into mpfactory.district(id, name, CITY_ID) values(106,'Panorama',269);
insert into mpfactory.district(id, name, CITY_ID) values(107,'Piaski',269);
insert into mpfactory.district(id, name, CITY_ID) values(108,'Pietraszki',269);
insert into mpfactory.district(id, name, CITY_ID) values(109,'Pod Dalnią',269);
insert into mpfactory.district(id, name, CITY_ID) values(110,'Podhale',269);
insert into mpfactory.district(id, name, CITY_ID) values(111,'Podkarczówka',269);
insert into mpfactory.district(id, name, CITY_ID) values(112,'Pod Telegrafem',269);
insert into mpfactory.district(id, name, CITY_ID) values(113,'Posłowice',269);
insert into mpfactory.district(id, name, CITY_ID) values(114,'Sady',269);
insert into mpfactory.district(id, name, CITY_ID) values(115,'Sandomierskie',269);
insert into mpfactory.district(id, name, CITY_ID) values(116,'Sieje',269);
insert into mpfactory.district(id, name, CITY_ID) values(117,'Sitkówka',269);
insert into mpfactory.district(id, name, CITY_ID) values(118,'Skrzetle',269);
insert into mpfactory.district(id, name, CITY_ID) values(119,'Słoneczne Wzgórze',269);
insert into mpfactory.district(id, name, CITY_ID) values(120,'Słowik',269);
insert into mpfactory.district(id, name, CITY_ID) values(121,'Szydłówek',269);
insert into mpfactory.district(id, name, CITY_ID) values(122,'Ślichowice',269);
insert into mpfactory.district(id, name, CITY_ID) values(123,'Osiedle Świętokrzyskie',269);
insert into mpfactory.district(id, name, CITY_ID) values(124,'Uroczysko',269);
insert into mpfactory.district(id, name, CITY_ID) values(125,'Wielkopole',269);
insert into mpfactory.district(id, name, CITY_ID) values(126,'Wietrznia',269);
insert into mpfactory.district(id, name, CITY_ID) values(127,'Zacisze',269);
insert into mpfactory.district(id, name, CITY_ID) values(128,'Zagórska Południe',269);
insert into mpfactory.district(id, name, CITY_ID) values(129,'Zagórska Północ',269);
insert into mpfactory.district(id, name, CITY_ID) values(130,'Zagórze',269);
insert into mpfactory.district(id, name, CITY_ID) values(131,'Zalesie',269);




    
Fabryczna
Krzyki
Psie Pole
Stare Miasto
Śródmieście
