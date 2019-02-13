insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into user (id, create_date, email, name, nick_name, passwd) values (1, now(), 'test@naver.com', 'test', '감자', '{bcrypt}$2a$10$MCAxEy0tmC1jgyMW/ZnuYO4oS/Do/5zrMqnlAMI7cTMYiREZhuzMm');

insert into category (id, name) values (1, 'phone_case');
insert into category (id, name) values (2, 'keyboard');
insert into category (id, name) values (3, 'mouse');

