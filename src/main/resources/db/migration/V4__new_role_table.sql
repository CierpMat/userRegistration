CREATE TABLE role (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100)
);
ALTER TABLE myusers ADD COLUMN role_id BIGINT;
ALTER TABLE myusers ADD FOREIGN KEY (role_id) REFERENCES role (id);