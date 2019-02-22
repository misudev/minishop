insert into roles (id, name) values (1, 'USER');
insert into roles (id, name) values (2, 'ADMIN');

insert into user (id, create_date, email, name, nick_name, passwd) values (1, now(), 'test@naver.com', 'test', '감자', '{bcrypt}$2a$10$MCAxEy0tmC1jgyMW/ZnuYO4oS/Do/5zrMqnlAMI7cTMYiREZhuzMm');

insert into user_roles(user_id, role_id) values( 1, 1);
insert into user_roles(user_id, role_id) values( 1, 2);

insert into category (id, name, ordering) values (1, '젤리 케이스' , 1);
insert into category (id, name, ordering) values (2, '하드 케이스' , 2);
insert into category (id, name, ordering) values (3, '글리터 케이스', 3);

insert into phone_type (id, name) values (1, '아이폰5/5S');
insert into phone_type (id, name) values (2, '아이폰6/6S');
insert into phone_type (id, name) values (3, '아이폰7/8');
insert into phone_type (id, name) values (4, '아이폰X/XS');
insert into phone_type (id, name) values (5, '갤럭시 S6');
insert into phone_type (id, name) values (6, '갤럭시 S7');
insert into phone_type (id, name) values (7, '갤럭시 S8');
insert into phone_type (id, name) values (8, '갤럭시 S9');

