--liquibase formatted sql

--changeset suhas:1
create table request_log (
    identifier varchar(36) primary key,
    text varchar(255),
    status varchar(1),
    created_date date
);