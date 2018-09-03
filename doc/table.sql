DROP database IF EXISTS `yxchange`;

CREATE SCHEMA `yxchange` DEFAULT CHARACTER SET utf8 ;

use yxchange;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `salt` varchar(100) NOT NULL COMMENT '掩码',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';


drop table if exists `coin`;

create table `coin`(
  `id` int(10) NOT NULL,
  `name` varchar(5) not null comment '代币名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数字货币表';

insert into coin (id, name) value (1, 'BTC');
insert into coin (id, name) value (2, 'ETH');
insert into coin (id, name) value (3, 'LSK');

drop table if exists `account`;

create table `account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) not null comment '用户表id',
  `coin_name` varchar(5) not null comment '代币名称',
  `available` DECIMAL(10,10) not null default 0 comment '可用资产',
  `freezed` DECIMAL(10,10) not null default 0 comment '可用资产',
  `address` varchar(100) comment '充币地址',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_coin_UNIQUE` (`user_id`, `coin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户表';

drop table if exists `account_operation`;

create table `account_operation` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账户id',
  `order_id` varchar(20) not null comment '变更订单号',
  `channel_id` int(3) not null comment '系统来源',
  `operation` int(2) not null comment '操作类型，1-加减仓，2-冻结/解冻资金',
  `amount` DECIMAL(10,10) not null comment '变更数量',
  `available_before` DECIMAL(10,10) not null comment '变更前可用资产',
  `available_after` DECIMAL(10,10) not null comment '变更后可用资产',
  `freezed_before` DECIMAL(10,10) not null comment '变更前冻结资产',
  `freezed_after` DECIMAL(10,10) not null comment '变更后冻结资产',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户变更表';

drop table if exists `account_trans`;

create table `account_trans` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(20) not null comment '订单号',
  `operation` int(2) not null comment '操作类型，1-加减仓，2-冻结/解冻资金',
  `amount` DECIMAL(10,10) not null comment '变更数量',
  `available_before` DECIMAL(10,10) not null comment '变更前可用资产',
  `available_after` DECIMAL(10,10) not null comment '变更后可用资产',
  `freezed_before` DECIMAL(10,10) not null comment '变更前冻结资产',
  `freezed_after` DECIMAL(10,10) not null comment '变更后冻结资产',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户变更流水表';

drop table if exists `account_address`;

create table `account_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账户id',
  `address` varchar(100) comment '提币地址',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户提币地址表';

