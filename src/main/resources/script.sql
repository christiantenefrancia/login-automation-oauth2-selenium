/*drop table if exists roles;
drop table if exists user_roles;
drop table if exists users;
create table roles (id bigint not null auto_increment, created_on bigint, description VARCHAR(255), modified_on bigint, name VARCHAR(255), primary key (id)) engine=MyISAM;
create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM;
create table users (id bigint not null auto_increment, email VARCHAR(255), first_name VARCHAR(255), last_name VARCHAR(255), password VARCHAR(255), username VARCHAR(255), primary key (id)) engine=MyISAM
alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (id);
alter table user_roles add constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users (id);

INSERT INTO roles(description,name) values ('Admin', 'ADMIN');
INSERT INTO roles(description,name) values ('User', 'USER');
INSERT INTO users (email,first_name, last_name,password,username) values ('admin@gmail.com','admin', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','admin');
insert into USER_ROLES(USER_ID,ROLE_ID) values (1,1);*/


/*** For Postgres SQL ***/
DROP TABLE if EXISTS roles CASCADE;
DROP TABLE if EXISTS user_roles CASCADE;
DROP TABLE if EXISTS users CASCADE;

CREATE TABLE roles (
	id SERIAL PRIMARY KEY,
	created_on bigint,
	description VARCHAR(255),
	modified_on bigint,
	name VARCHAR(255));

CREATE TABLE user_roles (
	user_id INTEGER not null,
	role_id INTEGER not null);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255));

alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (id);
alter table user_roles add constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users (id);

INSERT INTO roles(description,name) values ('Admin', 'ADMIN');
INSERT INTO roles(description,name) values ('User', 'USER');
INSERT INTO users (email,first_name, last_name,password,username) values ('admin@gmail.com','admin', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u','admin');
INSERT INTO USER_ROLES(USER_ID,ROLE_ID) values (1,1);

CREATE TABLE site (
    siteId SERIAL PRIMARY KEY,
    siteName VARCHAR(255),
    loginUrl VARCHAR(255),
    usernameTag VARCHAR(255),
    passwordTag VARCHAR(255));

CREATE TABLE credentials (
    credentialsId SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    siteId INTEGER REFERENCES site(siteId));
