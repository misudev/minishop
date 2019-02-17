insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into user (id, create_date, email, name, nick_name, passwd) values (1, now(), 'test@naver.com', 'test', '감자', '{bcrypt}$2a$10$MCAxEy0tmC1jgyMW/ZnuYO4oS/Do/5zrMqnlAMI7cTMYiREZhuzMm');

insert into user_roles(user_id, role_id) values( 1, 1);
insert into user_roles(user_id, role_id) values( 1, 2);

insert into category (id, name, ordering) values (1, 'phone_case' , 1);
insert into category (id, name, ordering) values (2, 'keyboard' , 2);
insert into category (id, name, ordering) values (3, 'mouse', 3);


