/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : xmshopping

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-06-06 00:00:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `carts`
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `edition` varchar(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '../upload/20210528235659.jpg', 'MIX FOLD折叠手机', '10999', null, '黑色', '12GB+512GB', '2000');
INSERT INTO `goods` VALUES ('2', '../upload/20210528235852.jpg', '小米10', '3599', null, '国风雅灰', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('3', '../upload/20210529000029.jpg', 'Note 9 4G', '1299', null, '羽墨黑', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('4', '../upload/20210529000224.jpg', '小米11S', '3299', null, '黑色', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('5', '../upload/20210529000518.jpg', '小米11 Ultra', '5999', null, '陶瓷黑', '8GB+256GB', '2000');
INSERT INTO `goods` VALUES ('6', '../upload/20210529000757.jpg', '小米11 Pro', '5299', null, '黑色', '8GB+256GB', '2000');
INSERT INTO `goods` VALUES ('7', '../upload/20210529001121.jpg', '小米10 青春版 5G', '2099', null, '黑巧风暴', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('8', '../upload/20210529001251.jpg', '黑鲨4', '2699', null, '幻境黑', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('9', '../upload/20210529001610.jpg', '黑鲨4 Pro', '3999', null, '墨海黑', '8GB+256GB', '2000');
INSERT INTO `goods` VALUES ('10', '../upload/20210529001819.jpg', 'Note 8 Pro', '1499', null, '暮光橙', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('11', '../upload/20210529002110.jpg', 'Redmi Note 8', '1299', null, '梦幻蓝', '6GB+128GB', '2000');
INSERT INTO `goods` VALUES ('12', '../upload/20210529002540.jpg', 'Note 9 5G', '1299', null, '云墨灰', '6GB+128GB', '2000');
INSERT INTO `goods` VALUES ('13', '../upload/20210529002702.jpg', 'Note 9 5G Pro', '1799', null, '湖光秋色', '8GB+128GB', '2000');
INSERT INTO `goods` VALUES ('14', '../upload/20210529002859.jpg', 'Redmi K40', '2699', null, '幻境', '12GB+256GB', '2000');
INSERT INTO `goods` VALUES ('15', '../upload/20210529003046.jpg', 'Redmi 8A', '799', null, '深海蓝', '4GB+64GB', '1000');
INSERT INTO `goods` VALUES ('16', '../upload/20210529003219.jpg', 'Redmi 9A', '599', null, '砂石黑', '4GB+64GB', '1500');
INSERT INTO `goods` VALUES ('17', '../upload/20210529003503.jpg', 'Redmi 10X 4G', '999', null, '冰雾白', '4GB+128GB', '1500');
INSERT INTO `goods` VALUES ('18', '../upload/20210529003720.jpg', 'Redmi 10X 5G', '1899', null, '白色', '8GB+256GB', '4000');
INSERT INTO `goods` VALUES ('19', '../upload/20210529003923.jpg', 'Redmi K30 5G', '1999', null, '深海微光', '6GB+64GB', '2000');
INSERT INTO `goods` VALUES ('20', '../upload/20210529004059.jpg', 'Redmi K40 游戏增强版', '2699', null, '暗影', '12GB+256GB', '2500');

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `items_id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `orders_id` varchar(14) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`items_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` varchar(14) NOT NULL,
  `total` float DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `receiver`
-- ----------------------------
DROP TABLE IF EXISTS `receiver`;
CREATE TABLE `receiver` (
  `receiver_id` int(11) NOT NULL AUTO_INCREMENT,
  `users_id` int(11) DEFAULT NULL,
  `receiver_name` varchar(20) DEFAULT NULL,
  `receiver_phone` varchar(11) DEFAULT NULL,
  `receiver_province` varchar(20) DEFAULT NULL,
  `receiver_city` varchar(20) DEFAULT NULL,
  `receiver_district` varchar(20) DEFAULT NULL,
  `receiver_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`receiver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receiver
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
