
-- permission

CREATE TABLE `permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

insert  into `permission`(`id`,`permission_name`) values (1,'user:*'),(2,'student:*');

-- Role

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

insert  into `role`(`id`,`role_name`) values (1,'admin'),(2,'teacher');

-- User

create table `user_role` (
	`id` bigint primary key auto_increment,
	`user_id` bigint,
	`role_id` bigint
);

insert into `user_role`(user_id, role_id) values(1, 1),(1, 2),(2, 1);

create table `role_permission` (
	`id` bigint primary key auto_increment,
	`role_id` bigint,
	`permission_id` bigint
);

insert into `role_permission`(role_id, permission_id) values(1, 1),(2, 2);