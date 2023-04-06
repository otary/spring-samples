/*
SQLyog v10.2
MySQL - 5.1.72-community : Database - shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`name`,`type`,`url`,`permission`,`parent_id`,`parent_ids`,`sort_id`,`available`) values (1,'权限','','',NULL,0,'0/','0','1'),(21,'用户管理','menu','/user/list','user:view',1,'0/1/',2,'1'),(22,'用户新增','permission','','user:create',21,'0/1/21/',0,'1'),(23,'用户修改','permission','','user:update',21,'0/1/21/',0,'1'),(24,'用户删除','permission','','user:delete',21,'0/1/21/',0,'1');

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`description`,`available`) values (1,'用户管理员','管理员角色（UI显示）',1);

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`id`,`sys_role_id`,`sys_permission_id`) values (1,1,21),(2,1,22);

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`name`,`password`,`salt`,`state`) values (1,'admin','管理员','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f','0'),(2,'lisi','李四','bf07fd8bbc73b6f70b8319f2ebb87483','uiwueylm','0'),(3,'zhangsan','张三','cb571f7bd7a6f73ab004a70322b963d5','eteokues','0');

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`sys_user_id`,`sys_role_id`) values (1,1,1);


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;