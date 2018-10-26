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
  `wallet_class_name` varchar(100) comment '钱包类路径',
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
  `coin_id` int(10) not null comment '代币id',
  `coin_name` varchar(5) not null comment '代币名称',
  `available` DECIMAL(20,10) not null default 0 comment '可用资产',
  `freezed` DECIMAL(20,10) not null default 0 comment '可用资产',
  `address` varchar(100) comment '充币地址',
  `state` int(2) not null default 0 comment '0-在用，1-禁用',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_coin_UNIQUE` (`user_id`, `coin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户表';

drop table if exists `account_order`;

create table `account_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账户id',
  `order_id` varchar(20) not null comment '变更订单号',
  `channel_id` int(3) not null comment '系统来源',
  `available_before` DECIMAL(20,10) not null comment '变更前可用资产',
  `available_after` DECIMAL(20,10) not null comment '变更后可用资产',
  `freezed_before` DECIMAL(20,10) not null comment '变更前冻结资产',
  `freezed_after` DECIMAL(20,10) not null comment '变更后冻结资产',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户变更表';

drop table if exists `account_operation`;

create table `account_operation` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(20) not null comment '订单号',
  `operation` int(2) not null comment '操作类型，0-加减仓，1-冻结/解冻资金',
  `amount` DECIMAL(20,10) not null comment '变更数量',
  `freeze_order_id` varchar(20) comment '冻结订单号',
  `available_before` DECIMAL(20,10) not null comment '变更前可用资产',
  `available_after` DECIMAL(20,10) not null comment '变更后可用资产',
  `freezed_before` DECIMAL(20,10) not null comment '变更前冻结资产',
  `freezed_after` DECIMAL(20,10) not null comment '变更后冻结资产',
  `description` varchar(50) comment '说明',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户变更流水表';

drop table if exists `deposit`;

create table `deposit` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账户id',
  `coin_id` int(10) not null comment '币种id',
  `coin_name` varchar(10) not null comment '币种名称',
  `amount` DECIMAL(20,10) not null comment '充值金额',
  `address` varchar(50) not null comment '充币地址',
  `trans_hash` varchar(100) comment '交易hash',
  `high` int(10) comment '块高',
  `state` int(2) not null default 0 comment '状态，0-新建,1-安全块高确认中,2-待归集,3-完成',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值记录表';

drop table if exists `withdraw`;

create table `withdraw` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账户id',
  `address_id` int(10) not null comment '地址id',
  `amount` DECIMAL(20,10) not null comment '充值金额',
  `trans_hash` varchar(100) comment '交易hash',
  `high` int(10) comment '块高',
  `state` int(2) not null default 0 comment '0-新建,1-交易池,2-有hash,3-完成',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提币记录表';

drop table if exists `account_address`;

create table `account_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账户id',
  `address` varchar(100) not null comment '提币地址',
  `state` int(2) not null default 0 comment '状态，0-在用，1-已删除',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户提币地址表';

drop table if exists `trans_order`;

create table `trans_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) not null comment '账号id',
  `base_id` int(10) not null comment '要买/卖的币种id',
  `counter_id` int(10) not null comment '要支付/收到的币种id',
  `category` int(1) not null comment '交易类型，0-ask,1-bid',
  `price` DECIMAL(20,10) not null comment '交易价格',
  `amount` DECIMAL(20,10) not null comment '交易数量',
  `state` int(2) not null default 0 comment '状态，0-新建，1-部分匹配，2-匹配完成，3-已完成，4-已撤单，5-失败',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易订单表';

drop table if exists `trade`;

create table `trade` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `match_id` varchar(50) not null comment '撮合id',
  `ask_order_id` int(10) not null comment '卖方id',
  `bid_order_id` int(10) not null comment '买方id',
  `taker_order_id` int(10) not null comment '成交方id',
  `maker_order_id` int(10) not null comment '做市方id',
  `price` DECIMAL(20,10) not null comment '成交价格',
  `amount` DECIMAL(20,10) not null comment '成交数量',
  `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更改时间',
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成交表';
