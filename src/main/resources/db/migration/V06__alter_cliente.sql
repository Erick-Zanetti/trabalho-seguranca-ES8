ALTER TABLE seguranca.cliente ADD COLUMN idempresa BIGINT(20) NULL;

ALTER TABLE seguranca.cliente ADD CONSTRAINT FK_cliente_empresa FOREIGN KEY (idempresa) REFERENCES seguranca.empresa(idempresa);
