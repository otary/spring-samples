DROP TABLE IF EXISTS `java_types_entity`;
CREATE TABLE `java_types_entity`  (
  `byte_type` CHAR(1) NULL DEFAULT NULL,
  `short_type` tinyint(4) NULL DEFAULT NULL,
  `character_type` char(2)  NULL DEFAULT NULL,
  `integer_type` int(12) NULL DEFAULT NULL,
   `float_type` double NULL DEFAULT NULL,
  `long_type` bigint(12) NULL DEFAULT NULL,
  `double_type` double NULL DEFAULT NULL,
  `bytes_type` binary NULL,
  `bigdecimal_type` bigint(20) NULL DEFAULT NULL,
  `boolean_type` boolean NULL DEFAULT NULL,
  `date_type` date NULL DEFAULT NULL,
  `varchar_type` varchar(500) NULL  DEFAULT NULL,
  `enum_type` varchar(500) null default null
);


DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `username` varchar(32) NOT NULL COMMENT '账号',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `state` char(1) DEFAULT NULL COMMENT '账号状态.0:未激活,1:正常状态,2：用户被锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
