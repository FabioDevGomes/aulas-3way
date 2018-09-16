-- Table: public.usuario

 DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
  id integer NOT NULL ,
  username character varying(255) NOT NULL,
  password character varying(255) NOT NULL,
  lastaccess date,
  matricula character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT usuario_matricula_key UNIQUE (matricula),
  CONSTRAINT usuario_username_key UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO postgres;


update usuario set matricula = 1235 where id = 3;

select * from usuario;


CREATE SEQUENCE usuario_id_seq;
ALTER TABLE usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq');
ALTER TABLE usuario ALTER COLUMN id SET NOT NULL;
ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;    -- 8.2 or later

SELECT MAX(id) FROM usuario;
SELECT setval('usuario_id_seq', 5);  -- replace 5 by SELECT MAX result

SELECT * FROM usuario;

