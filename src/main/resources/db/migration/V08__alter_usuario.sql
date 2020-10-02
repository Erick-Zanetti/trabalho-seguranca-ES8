ALTER TABLE seguranca.usuario ADD COLUMN idempresa BIGINT(20) NULL;

ALTER TABLE seguranca.usuario ADD CONSTRAINT FK_usuario_empresa FOREIGN KEY (idempresa) REFERENCES seguranca.empresa(idempresa);
