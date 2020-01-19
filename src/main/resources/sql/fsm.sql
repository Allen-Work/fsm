/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : 127.0.0.1:3306
 Source Schema         : com.gtstar.fsm

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 17/01/2020 17:20:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file_list
-- ----------------------------
DROP TABLE IF EXISTS `file_list`;
CREATE TABLE `file_list`  (
  `file_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level` int(11) NULL DEFAULT NULL COMMENT '目录层级',
  `file_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `directory` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件目录',
  `size` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  `file_type` int(11) NOT NULL COMMENT '文件类型：0.文件夹\r\n//文档文件类型的\r\n1.ai\r\n2.eps\r\n3.exe\r\n4.doc\r\n5.xls\r\n6.ppt\r\n7.pps\r\n8.pdf\r\n9.xml\r\n10.odt\r\n11.swf\r\n//压缩文件类型的 \r\n12.gz\r\n13.tgz\r\n14.bz\r\n15.bz2\r\n16.tbz\r\n17.zip\r\n18.rar\r\n19.tar\r\n20.7z\r\n//文字类型 \r\n21.txt\r\n22.php\r\n23.html\r\n24.htm\r\n25.js\r\n26.css\r\n27.rtf\r\n28.rtfd\r\n29.py\r\n30.java\r\n31.rb\r\n32.sh\r\n33.pl\r\n34.sql\r\n//图片类型的 \r\n35.bmp\r\n36.jpg\r\n37.jpeg\r\n38.gif\r\n39.png\r\n40.tif\r\n41.tiff\r\n42.tga\r\n43.psd\r\n\r\n//音频文件类型的 \r\n44.mp3\r\n45.mid\r\n46.ogg\r\n47.mp4a\r\n48.wav\r\n49.wma\r\n\r\n//视频文件类型的 \r\n50.avi\r\n51.dv\r\n52.mp4\r\n53.mpeg\r\n54.mpg\r\n55.mov\r\n56.wm\r\n57.flv\r\n58.mkv',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `delete_flag` int(1) NULL DEFAULT NULL COMMENT '删除标记',
  `is_folder` int(4) NOT NULL COMMENT '是否是文件夹,1是;0否',
  `parent_id` bigint(11) NOT NULL COMMENT '所属上一级目录id',
  `remark` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `file_index`(`directory`(255), `file_name`(255)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file_list
-- ----------------------------
INSERT INTO `file_list` VALUES (1, 1, 'activeMQ', 'F:\\activeMQ', NULL, 0, '2019-12-30 10:23:15', '2019-12-30 10:23:27', NULL, NULL, 1, 0, NULL);
INSERT INTO `file_list` VALUES (2, 1, 'maven', 'F:\\maven', NULL, 0, '2019-12-30 10:24:27', '2019-12-30 10:24:29', NULL, NULL, 1, 0, NULL);
INSERT INTO `file_list` VALUES (3, 1, 'opt', 'F:\\opt', NULL, 0, '2019-12-30 10:24:56', '2019-12-30 10:24:59', NULL, NULL, 1, 0, NULL);
INSERT INTO `file_list` VALUES (4, 1, 'Project', 'F:\\Project', NULL, 0, '2019-12-30 10:25:18', '2019-12-30 10:25:20', NULL, NULL, 1, 0, NULL);
INSERT INTO `file_list` VALUES (5, 2, 'apache-activemq-5.11.2-bin', 'F:\\activeMQ\\apache-activemq-5.11.2-bin', NULL, 0, '2019-12-30 10:26:11', '2019-12-30 10:26:13', NULL, NULL, 1, 1, NULL);
INSERT INTO `file_list` VALUES (6, 2, 'apache-activemq-5.11.2-bin.tar.gz', 'F:\\activeMQ\\apache-activemq-5.11.2-bin.tar.gz', NULL, 1, '2019-12-30 10:34:34', '2019-12-30 10:34:36', NULL, NULL, 0, 1, NULL);
INSERT INTO `file_list` VALUES (7, 2, 'apache-activemq-5.11.2-bin.zip', 'F:\\activeMQ\\apache-activemq-5.11.2-bin.zip', NULL, 1, '2019-12-30 15:01:44', '2019-12-30 15:01:47', NULL, NULL, 0, 1, NULL);
INSERT INTO `file_list` VALUES (8, 2, 'maven-repository', 'F:\\maven\\maven-repository', NULL, 0, '2019-12-30 15:03:49', '2019-12-30 15:03:51', NULL, NULL, 1, 2, NULL);
INSERT INTO `file_list` VALUES (9, 2, 'gtmis', 'F:\\opt\\gtmis', NULL, 0, '2019-12-30 15:04:35', '2019-12-30 15:04:37', NULL, NULL, 1, 3, NULL);
INSERT INTO `file_list` VALUES (10, 2, 'mis', 'F:\\opt\\mis', NULL, 0, '2019-12-30 15:05:50', '2019-12-30 15:05:55', NULL, NULL, 1, 3, NULL);
INSERT INTO `file_list` VALUES (11, 3, 'apache-activemq-5.11.2', 'F:\\activeMQ\\apache-activemq-5.11.2-bin\\apache-activemq-5.11.2', NULL, 0, '2019-12-30 15:06:49', '2019-12-30 15:06:51', NULL, NULL, 1, 5, NULL);
INSERT INTO `file_list` VALUES (12, 2, 'preview', 'F:\\preview', NULL, 0, '2020-01-03 13:27:15', '2020-01-03 13:27:18', NULL, NULL, 1, 0, NULL);
INSERT INTO `file_list` VALUES (13, 3, 'lack.xlsx', 'F:\\preview\\lack.xlsx', NULL, 1, '2020-01-03 13:31:29', '2020-01-03 13:31:26', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (14, 3, 'MSD-DB_20190906(1).xls', 'F:\\preview\\MSD-DB_20190906(1).xls', NULL, 1, '2020-01-03 13:32:27', '2020-01-03 13:32:29', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (15, 3, 'Java.pdf', 'F:\\preview\\Java.pdf', NULL, 1, '2020-01-03 13:33:13', '2020-01-03 13:33:11', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (16, 3, 'jeesite-1.0.3.zip', 'F:\\preview\\jeesite-1.0.3.zip', NULL, 1, '2020-01-03 13:33:42', '2020-01-03 13:33:44', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (17, 3, 'login.css', 'F:\\preview\\login.css', NULL, 1, '2020-01-03 13:34:09', '2020-01-03 13:34:11', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (18, 3, '测试.doc', 'F:\\preview\\测试.doc', NULL, 1, '2020-01-03 13:34:40', '2020-01-03 13:34:42', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (19, 3, 'Mis完整流程步骤.docx', 'F:\\preview\\Mis完整流程步骤.docx', NULL, 1, '2020-01-03 13:35:06', '2020-01-03 13:35:09', NULL, NULL, 0, 12, NULL);
INSERT INTO `file_list` VALUES (20, 3, '说明文档.txt', 'F:\\preview\\说明文档.txt', NULL, 1, '2020-01-03 13:35:40', '2020-01-03 13:35:37', NULL, NULL, 0, 12, NULL);

-- ----------------------------
-- Table structure for file_share
-- ----------------------------
DROP TABLE IF EXISTS `file_share`;
CREATE TABLE `file_share`  (
  `share_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `file_ids` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分享的文件id',
  `link_address` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分享链接',
  `view_count` int(11) NULL DEFAULT NULL COMMENT '浏览次数',
  `download_count` int(11) NULL DEFAULT NULL COMMENT '下载次数',
  `share_time` date NOT NULL COMMENT '分享时间',
  `inactive_time` date NOT NULL COMMENT '失效时间',
  PRIMARY KEY (`share_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file_share
-- ----------------------------
INSERT INTO `file_share` VALUES (1, NULL, 'http://gtstar/show/Y3aUBn', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (2, NULL, 'http://gtstar/show/2Evu6v', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (3, NULL, 'Y3aUBn', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (4, NULL, '2Evu6v', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (5, NULL, 'Y3aUBn', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (6, NULL, 'Rjq2Yn', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (7, NULL, 'Y3aUBn', NULL, NULL, '2019-12-17', '2019-12-24');
INSERT INTO `file_share` VALUES (8, NULL, 'yAZvuu', NULL, NULL, '2019-12-23', '2019-12-30');
INSERT INTO `file_share` VALUES (9, NULL, 'jMzeie', NULL, NULL, '2019-12-23', '2019-12-30');
INSERT INTO `file_share` VALUES (10, NULL, 'JF73am', NULL, NULL, '2019-12-23', '2019-12-30');
INSERT INTO `file_share` VALUES (11, NULL, 'MRBJZf', NULL, NULL, '2019-12-26', '2020-01-02');
INSERT INTO `file_share` VALUES (12, NULL, 'ueURb2', NULL, NULL, '2019-12-26', '2020-01-02');
INSERT INTO `file_share` VALUES (13, NULL, 'eQRFn2', NULL, NULL, '2019-12-26', '2020-01-02');
INSERT INTO `file_share` VALUES (14, NULL, 'NJBRve', NULL, NULL, '2019-12-26', '2020-01-02');
INSERT INTO `file_share` VALUES (17, NULL, 'uaYBni', NULL, NULL, '2020-01-10', '2020-01-17');
INSERT INTO `file_share` VALUES (18, NULL, 'FzemMr', NULL, NULL, '2020-01-10', '2020-01-17');
INSERT INTO `file_share` VALUES (19, NULL, '6VVzAz', NULL, NULL, '2020-01-10', '2020-01-17');
INSERT INTO `file_share` VALUES (20, NULL, 'NbY7Zv', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (21, NULL, 'Eb2MR3', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (22, NULL, 'j6RJZr', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (23, NULL, '7zaeAj', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (24, NULL, 'FFJZZ3', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (25, NULL, 'AJnM73', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (26, NULL, 'u6fYNz', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (28, NULL, 'AneUrm', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (29, NULL, 'bYBBj2', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (30, NULL, 'QbQN3y', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (31, NULL, 'eINJ7z', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (32, NULL, 'zEnq2m', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (33, NULL, 'neuIRr', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (34, NULL, 'vEz2Uj', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (35, '12', 'eiaQNz', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (36, '13,14,15,16,17,18,19,20', 'FnieAn', NULL, NULL, '2020-01-16', '2020-01-23');
INSERT INTO `file_share` VALUES (37, '16', 'QzInYn', NULL, NULL, '2020-01-17', '2020-01-24');

SET FOREIGN_KEY_CHECKS = 1;
