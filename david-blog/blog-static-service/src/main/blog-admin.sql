-- ----------------------------
-- Table structure for blog_menu 菜单表
-- ----------------------------
DROP TABLE IF EXISTS `blog_menu`;
CREATE TABLE `blog_menu` (
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(256) DEFAULT NULL COMMENT '菜单url',
  `img_url` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点',
  `serial_num` int(5) DEFAULT NULL COMMENT '排序项',
  `create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `end_time` varchar(19) DEFAULT NULL COMMENT '最后修改时间',
  `last_user_id` varchar(36) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';-- ----------------------------
-- Table structure for blog_menu 角色表
-- ----------------------------
DROP TABLE IF EXISTS `blog_role`;
CREATE TABLE `blog_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_tag` int(1) DEFAULT NULL COMMENT '角色标识',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
-- Table structure for blog_user 用户表
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_role` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `user_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `user_password` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(200) DEFAULT NULL COMMENT '用户邮箱',
  `user_state` int(1) default 0 COMMENT '0 启用，1禁用'
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` varchar(255) DEFAULT NULL,
  `phone_num` int(11) DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `ip_address` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `isp` varchar(255) DEFAULT NULL COMMENT '运营商',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `county` varchar(255) DEFAULT NULL COMMENT '县',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `last_time` varchar(255) DEFAULT NULL COMMENT '最后登录时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

用户注册

delimiter $$;
create procedure insert_user(
  in id varchar,
  in  pwdSalt varchar ,
  in  lastTime DATETIME ,
  in  phoneNum varchar ,
  in  password varchar ,
  in  nickname varchar ,
  in  regIp varchar ,
  in  lastIp varchar ,
  in  createTime DATETIME,
  in  thisTime DATETIME,
  out  ret INTEGER )
declare num int default 0;
begin
    select count(1) into num where phoneNum=phoneNum;
if num > 0 then
    insert into blog_user
    (
     id,pwd_salt,last_time,phone_num,password,nickname,reg_ip,last_ip,create_time,this_time
    )
    values
    (
       id,pwdSalt,lastTime,phoneNum,password,nickname,regIp,lastIp,createTime,thisTime
    )
end if;
  set ret = 1;
end ;




)