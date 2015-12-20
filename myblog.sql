/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-12-20 18:28:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(255) NOT NULL,
  `blog_author_id` int(11) NOT NULL,
  `markdown_content` text NOT NULL,
  `blog_content` text NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `finish_time` datetime NOT NULL,
  PRIMARY KEY (`bid`),
  KEY `FK_Reference_2` (`category_id`),
  KEY `FK_Reference_3` (`blog_author_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`cid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`blog_author_id`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('15', '标题', '1', '**清热污染请额外热情而而且热情**\r\n\r\n请额外热情我二七二qwer\r\n\r\n![alternate text](../upload/2015/11/2/8314840703289910772.jpg)\r\n\r\n![alternate text](../upload/2015/11/5/2153057343678963949.jpg)', '<p><strong>清热污染请额外热情而而且热情</strong></p>\n\n<p>请额外热情我二七二qwer</p>\n\n<p><img src=\"../upload/2015/11/2/8314840703289910772.jpg\" alt=\"alternate text\" /></p>\n\n<p><img src=\"../upload/2015/11/5/2153057343678963949.jpg\" alt=\"alternate text\" /></p>\n', '2', '2015-11-30 21:22:37');
INSERT INTO `blog` VALUES ('17', '12', '1', '\r\n![alternate text](upload/2015/10/30/5628047403465577714.jpg)\r\n**a**', '<p><img src=\"upload/2015/10/30/5628047403465577714.jpg\" alt=\"alternate text\" />\n<strong>a</strong></p>\n', '2', '2015-11-30 21:43:56');
INSERT INTO `blog` VALUES ('18', '2333', '1', '刘彻\r\n![alternate text](upload/2015/11/1/3358454059011124475.jpg)', '<p>刘彻\n<img src=\"upload/2015/11/1/3358454059011124475.jpg\" alt=\"alternate text\" /></p>\n', '0', '2015-12-01 13:01:47');
INSERT INTO `blog` VALUES ('28', '而却', '1', '**567578**\r\n![alternate text](../upload/2015/11/3/8971700439486283805.jpg)', '<p><strong>567578</strong>\n<img src=\"../upload/2015/11/3/8971700439486283805.jpg\" alt=\"alternate text\" /></p>\n', '0', '2015-12-03 16:12:46');
INSERT INTO `blog` VALUES ('29', '全额外人', '1', '\r\n![alternate text](../upload/2015/11/5/6231590468684093226.jpg)\r\n\r\n**liu**', '<p><img src=\"../upload/2015/11/5/6231590468684093226.jpg\" alt=\"alternate text\" /></p>\n\n<p><strong>liu</strong></p>\n', '1', '2015-12-05 16:09:26');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('0', '未分类');
INSERT INTO `category` VALUES ('1', 'java');
INSERT INTO `category` VALUES ('2', 'php');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `comment_nickname` varchar(50) NOT NULL,
  `comment_content` varchar(255) NOT NULL,
  `comment_time` datetime NOT NULL,
  `target_comment_id` int(11) NOT NULL,
  `target_blog_id` int(11) NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK_Reference_1` (`target_blog_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`target_blog_id`) REFERENCES `blog` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', 'ljm', 'hehehhe', '2015-12-03 13:03:07', '0', '15');
INSERT INTO `comment` VALUES ('6', '若尘无悔', '李逍遥', '2015-12-03 19:31:57', '1', '15');
INSERT INTO `comment` VALUES ('7', '秦莞尔', 'qrew', '2015-12-03 19:34:00', '6', '15');
INSERT INTO `comment` VALUES ('8', '而却', '123', '2015-12-03 19:35:42', '0', '15');
INSERT INTO `comment` VALUES ('9', '荣企鹅王', '而却', '2015-12-03 19:38:28', '0', '15');
INSERT INTO `comment` VALUES ('10', '而却', '全额外人', '2015-12-03 19:40:44', '7', '15');
INSERT INTO `comment` VALUES ('11', '而却', '热武器热', '2015-12-03 19:41:00', '0', '15');
INSERT INTO `comment` VALUES ('12', 'qrew', '热武器', '2015-12-03 19:41:46', '0', '15');
INSERT INTO `comment` VALUES ('13', 'reqw', 'werrqw', '2015-12-03 19:52:24', '12', '15');
INSERT INTO `comment` VALUES ('14', 'rqe', 'req', '2015-12-03 19:57:52', '0', '15');
INSERT INTO `comment` VALUES ('15', 'rqewrqewrq ', 'ewqrqrewqrewq', '2015-12-03 20:00:36', '13', '15');
INSERT INTO `comment` VALUES ('16', 'reqw', 'rewqerqwwreqewrqrewewr', '2015-12-03 20:29:24', '0', '15');
INSERT INTO `comment` VALUES ('21', 'eq', 'eqw', '2015-12-04 14:47:23', '1', '15');
INSERT INTO `comment` VALUES ('22', '刘军明', '热情', '2015-12-04 14:49:50', '21', '15');
INSERT INTO `comment` VALUES ('23', '为', '2位', '2015-12-04 14:50:14', '0', '15');
INSERT INTO `comment` VALUES ('26', 'erwq', 'qwer', '2015-12-04 15:10:28', '23', '15');
INSERT INTO `comment` VALUES ('27', '陈次啊博', '呵呵', '2015-12-06 19:37:43', '12', '15');
INSERT INTO `comment` VALUES ('28', 'winter', 'zhonghuageng ', '2015-12-07 11:40:09', '0', '15');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `messager_nickname` varchar(50) NOT NULL,
  `message_content` text NOT NULL,
  `message_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', 'ljm', '123', '2015-12-03 13:39:33');
INSERT INTO `message` VALUES ('2', 'w42', '5425432', '2015-12-03 21:50:29');
INSERT INTO `message` VALUES ('3', 'rew', 'trew', '2015-12-04 12:15:27');
INSERT INTO `message` VALUES ('4', '刘彻', 'O(∩_∩)O哈哈~', '2015-12-04 12:15:54');
INSERT INTO `message` VALUES ('5', '陈贤波', '陈贤波', '2015-12-06 19:36:01');
INSERT INTO `message` VALUES ('6', 'winter', 'athelp', '2015-12-07 11:38:52');
INSERT INTO `message` VALUES ('7', 'zhonghuagn', '', '2015-12-07 11:39:06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ljm', '123456');
