CREATE table myusers (
    id bigint primary key AUTO_INCREMENT NOT NULL,
    first_name varchar(30) NOT NULL,
    last_name varchar(50) NOT NULL,
    login varchar(30) NOT NULL,
    password varchar(100),
    is_active tinyint(1) NOT NULL DEFAULT 1
);