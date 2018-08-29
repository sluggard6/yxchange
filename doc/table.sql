DROP database IF EXISTS `yxchange`;

CREATE SCHEMA `yxchange` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `yxchange`.`user`;

CREATE TABLE `yxchange`.`user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) not null COMMENT '用户名',
  `password` varchar(50) not null COMMENT '密码',
  `createtime` datetime not null default CURRENT_TIMESTAMP comment '创建时间',
  `modifytime` datetime not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '最后更改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户角色表';