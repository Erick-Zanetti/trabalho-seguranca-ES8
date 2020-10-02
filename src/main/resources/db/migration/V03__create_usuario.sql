CREATE TABLE seguranca.usuario (
	idusuario BIGINT(20) auto_increment NOT NULL,
	nome varchar(100) NULL,
	senha varchar(100) NOT NULL,
	created DATE,
	updated DATE,
	CONSTRAINT produto_PK PRIMARY KEY (idusuario)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
