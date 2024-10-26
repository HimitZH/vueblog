/*
 Navicat Premium Data Transfer

 Source Server         : test01
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 26/10/2024 15:07:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_blog
-- ----------------------------
DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint NULL DEFAULT NULL,
  `deleted` int NULL DEFAULT 0,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog` VALUES (18, 1, '4444', '44444', '444444', '2020-07-20 22:35:21', NULL, 0, 0, NULL);
INSERT INTO `m_blog` VALUES (19, 1, '11111', '111', '11111', '2020-07-20 22:36:10', NULL, 0, 0, NULL);
INSERT INTO `m_blog` VALUES (20, 1, '33333', '3333', '33333', '2020-07-20 23:52:50', NULL, 0, 0, NULL);
INSERT INTO `m_blog` VALUES (21, 1, '4444', '44444', '44444', '2020-07-20 23:52:58', NULL, 0, 0, NULL);
INSERT INTO `m_blog` VALUES (22, 1, '5555', '55555', '555555', '2020-07-20 23:53:07', '2020-07-21 21:25:15', 0, 1, NULL);

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status` int NOT NULL DEFAULT 0,
  `created` datetime NULL DEFAULT NULL,
  `last_login` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `UK_USERNAME`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES (1, 'admin', 'https://cdn.jsdelivr.net/gh/HimitZH/CDN/images/HCODE.png', 'admin@qq.com', '96e79218965eb72c92a549dd5a330112', 0, '2020-07-19 22:00:00', NULL);
INSERT INTO `m_user` VALUES (2, 'admin123', NULL, '1012145225@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 0, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
