create database hjy;

CREATE TABLE hero (
  id int(10) AUTO_INCREMENT PRIMARY KEY,
  username varchar(25),
  password varchar(25),
  email    varchar(25),
  code     varchar(25),
  state    tinyint(1),
  registerTime   date
)  DEFAULT CHARSET=utf8;


insert into tb_user (username,password) value('root1',100);
insert into tb_user (username,password) value('root2',100);















