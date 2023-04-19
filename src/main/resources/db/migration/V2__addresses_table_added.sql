CREATE table myaddresses
(
    id          bigint primary key AUTO_INCREMENT NOT NULL,
    city        varchar(40)                    NOT NULL,
    street      varchar(50)                    NOT NULL,
    postal_code varchar(7)                     NOT NULL
);

CREATE table users_addresses(
    user_id bigint NOT NULL ,
    address_id bigint NOT NULL,
    FOREIGN KEY (user_id) REFERENCES myusers(id),
    FOREIGN KEY (address_id) REFERENCES myaddresses(id)
);