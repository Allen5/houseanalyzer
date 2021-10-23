
-- 新房表
DROP TABLE IF EXISTS `new_house`;
CREATE TABLE `new_house` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '楼盘名称',

  `created_at` datetime not null comment '创建时间',
  `updated_at` datetime not null comment '更新时间'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 新房销售记录批次表
DROP TABLE IF EXISTS `new_house_sell_batch`;

-- 新房一房一价表
DROP TABLE IF EXISTS `new_house_price`;