CREATE TABLE funcionario (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL, 
	sobrenome VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO funcionario (nome, sobrenome, email) values ('Fernando', 'Vieira', 'fvieira.java@gmail.com');
INSERT INTO funcionario (nome, sobrenome, email) values ('Luiz Fernando', 'Vieira', 'luiz.f.vieira@gmail.com');
INSERT INTO funcionario (nome, sobrenome, email) values ('Brunna', 'Santiago', 'bblsantiago@hotmail.com');