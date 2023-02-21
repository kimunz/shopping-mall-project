insert into "USER" (name, username, password, email, phone, address)
values ('관리자', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin@test.com', '010-0000-0000', '없음');
insert into "USER" (name, username, password, email, phone, address)
values ('홍길동', 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user@test.com', '010-0000-0001', '서울');

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (id, authority_name) values (2, 'ROLE_USER');
