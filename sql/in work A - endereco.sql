-- Table: endereco

-- DROP TABLE endereco;

CREATE TABLE endereco
(
  id serial NOT NULL,
  bairro character varying(255),
  estado character varying(255),
  municipio character varying(255),
  rua character varying(255),
  CONSTRAINT endereco_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE endereco
  OWNER TO postgres;

delete from endereco where id = 3;

insert into usuario (matricula, username, password) values ('M123', 'admin', '123')

insert into usuario (matricula, username, password) values ('ADM1234', 'admin2', '123')
