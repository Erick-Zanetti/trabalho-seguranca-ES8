CREATE TABLE seguranca.empresa (
	idempresa BIGINT(20) auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	cnpj varchar(20) NULL,
	created DATE,
	updated DATE,
	CONSTRAINT empresa_PK PRIMARY KEY (idempresa)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
