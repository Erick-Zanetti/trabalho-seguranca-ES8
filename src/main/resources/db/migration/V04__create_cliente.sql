CREATE TABLE seguranca.cliente (
	idcliente BIGINT(20) auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	cpf varchar(20) NULL,
	rg varchar(20) NULL,
	created DATE,
	updated DATE,
	CONSTRAINT cliente_PK PRIMARY KEY (idcliente)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
