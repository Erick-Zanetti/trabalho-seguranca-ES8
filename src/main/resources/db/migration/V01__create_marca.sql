CREATE TABLE IF NOT EXISTS marca  (
	idmarca BIGINT(20) auto_increment NOT NULL,
	nome VARCHAR(50) NOT NULL,
	created DATE,
	updated DATE,
	CONSTRAINT marca_PK PRIMARY KEY (idmarca)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;