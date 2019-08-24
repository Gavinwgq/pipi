/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.27 : Database - pipi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pipi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pipi`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuId` bigint(32) NOT NULL,
  `menuName` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `menuType` char(1) DEFAULT NULL COMMENT '菜单类型',
  `menuParent` bigint(32) DEFAULT NULL COMMENT '父菜单id',
  `menuPerm` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` bigint(32) NOT NULL,
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `roleMark` varchar(20) DEFAULT NULL COMMENT '角色标识',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `udpateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `roleMenuId` bigint(32) NOT NULL,
  `roleId` bigint(32) DEFAULT NULL COMMENT '角色id',
  `menuId` bigint(32) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`roleMenuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(32) NOT NULL,
  `userName` varchar(20) DEFAULT NULL COMMENT '用户名',
  `userNickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `userPassword` varchar(100) DEFAULT NULL COMMENT '密码',
  `userSalt` varchar(20) DEFAULT NULL COMMENT '加密盐值',
  `userState` char(1) DEFAULT NULL COMMENT '用户状态0、正常1、冻结',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`userNickName`,`userPassword`,`userSalt`,`userState`,`createTime`,`updateTime`) values (100,'Gavin','Gavin','12323','12313','1','2019-08-24 17:57:37','2019-08-24 17:57:40');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `userRoleId` bigint(32) NOT NULL,
  `userId` bigint(32) DEFAULT NULL COMMENT '用户id',
  `roleId` bigint(32) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`userRoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
