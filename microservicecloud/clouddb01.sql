/*
Navicat MySQL Data Transfer

Source Server         : localhost-----localhost
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : clouddb01

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-25 10:30:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部', 'clouddb01');
INSERT INTO `dept` VALUES ('2', '人事部', 'clouddb01');
INSERT INTO `dept` VALUES ('3', '财务部', 'clouddb01');
INSERT INTO `dept` VALUES ('4', '市场部', 'clouddb01');
INSERT INTO `dept` VALUES ('5', '运维部', 'clouddb01');
INSERT INTO `dept` VALUES ('6', '测试部', 'clouddb01');
