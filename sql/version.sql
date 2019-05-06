/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : version

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-05 16:52:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mobile_token`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_token`;
CREATE TABLE `mobile_token` (
  `ID` varchar(100) NOT NULL COMMENT 'id号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `tokenid` varchar(100) DEFAULT NULL COMMENT '口令',
  `validtime` datetime DEFAULT NULL COMMENT '过期时间',
  `islock` int(10) DEFAULT '0' COMMENT '是否锁定,1为锁定,默认为0',
  `isbomb` int(10) DEFAULT '0' COMMENT '是否推送炸弹消息,1为炸弹,默认为0',
  `updatetime` datetime DEFAULT NULL COMMENT '编辑时间',
  `device` varchar(100) DEFAULT NULL COMMENT '设备id值',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobile_token
-- ----------------------------

-- ----------------------------
-- Table structure for `mobile_version`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_version`;
CREATE TABLE `mobile_version` (
  `appKey` varchar(50) NOT NULL,
  `appName` varchar(50) DEFAULT NULL,
  `version` varchar(20) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `applicationType` varchar(100) DEFAULT NULL,
  `updatePackagePath` varchar(200) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateLog` varchar(500) DEFAULT NULL,
  `appUrl` varchar(2000) DEFAULT NULL,
  `targetSize` varchar(50) DEFAULT NULL,
  `constraints` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`appKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobile_version
-- ----------------------------
INSERT INTO `mobile_version` VALUES ('ab55ce55Ac4bcP408cPb8c1Aaeac179c5f6f', '安卓客户端', '1.2.2', 'true', '正式', 'http://localhost:8080/online/appDownFile/test.apk', '2017-07-05 16:52:28', '1.测试', 'http://localhost:8080/pelDem/appVersionManager/download.html', '0M', 'false');

-- ----------------------------
-- Table structure for `tb_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info` (
  `info_id` int(10) NOT NULL AUTO_INCREMENT,
  `info1` varchar(100) DEFAULT NULL,
  `info2` varchar(100) DEFAULT NULL,
  `info3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `menu_id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '系统管理', '', null);
INSERT INTO `tb_menu` VALUES ('3', '版本管理', '', null);
INSERT INTO `tb_menu` VALUES ('5', '用户管理', 'user.html', '1');
INSERT INTO `tb_menu` VALUES ('6', '角色管理', 'role.html', '1');
INSERT INTO `tb_menu` VALUES ('7', '菜单管理', 'menu.html', '1');
INSERT INTO `tb_menu` VALUES ('10', '版本更新', 'appVersionManager.html', '3');

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '系统管理员', '120555502');
INSERT INTO `tb_role` VALUES ('2', '普通用户', '2038792');
INSERT INTO `tb_role` VALUES ('3', '系统用户', '230374');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_uniu` (`loginname`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '1qazxsw2', '管理员', '1059686382', '0', '1', '2017-07-05 16:51:54');

-- ----------------------------
-- View structure for `card_view`
-- ----------------------------
DROP VIEW IF EXISTS `card_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `card_view` AS select `mobile_card`.`id` AS `id`,`mobile_card`.`username` AS `username`,`mobile_card`.`cardID` AS `cardID`,`mobile_card`.`cardIssuers` AS `cardIssuers` from `mobile_card` ;
