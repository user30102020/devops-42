create database devops3db;

\c devops3db;

create table users (
    id int primary key ,
    name varchar(50)
);