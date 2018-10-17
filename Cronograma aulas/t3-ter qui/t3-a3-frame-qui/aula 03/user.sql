-- Database: "user"

-- DROP DATABASE "user";

CREATE DATABASE "user"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

insert into usuario (id, userName, password, lastAccess) values (3, 'admin', '123456', CURRENT_TIMESTAMP);
insert into usuario (id, userName, password, lastAccess) values (4, 'fabio', '123', CURRENT_TIMESTAMP);
insert into usuario (id, userName, password, lastAccess) values (5, 'teste', '123', CURRENT_TIMESTAMP);