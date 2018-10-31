create table produtos (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    valor DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO produtos (nome, valor) values ('tenis', 250.00);
INSERT INTO produtos (nome, valor) values ('oculos', 450.00);
INSERT INTO produtos (nome, valor) values ('calça', 120.00);
INSERT INTO produtos (nome, valor) values ('meia', 25.00);
INSERT INTO produtos (nome, valor) values ('bone', 50.00);