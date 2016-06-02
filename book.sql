/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-04-10 19:47:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `authors` varchar(30) DEFAULT NULL,
  `publisher` varchar(30) DEFAULT NULL,
  `publishdate` datetime DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', '鲁滨逊漂流记 ', '迪福6', '北方少年出版社', '1996-08-09 00:00:00', '25.2');
INSERT INTO `book` VALUES ('4', '海底两万里', '儒勒.凡尔纳', ' 北方妇女儿童出版社 ', '1998-09-08 00:00:00', '18.8');
INSERT INTO `book` VALUES ('6', '十万个为什么', '米·伊林', '新世纪出版社', '1961-01-20 00:00:00', '8000');
INSERT INTO `book` VALUES ('2212', '家', '巴金', '人民文学出版社', '1978-02-28 00:00:00', '30');
