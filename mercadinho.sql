CREATE DATABASE mercadinho;
USE mercadinho;

CREATE TABLE usuario (
idUsuario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(110) NOT NULL,
login VARCHAR(110) NOT NULL UNIQUE,
senha VARCHAR(110) NOT NULL,
telefone VARCHAR(11) NOT NULL,
endereco VARCHAR(110) NOT NULL,
acesso VARCHAR(20) default 'usuario'
);

CREATE TABLE categoria (
idCategoria INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(110) NOT NULL );

CREATE TABLE admin (
idAdmin INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(110) NOT NULL,
login VARCHAR(110) NOT NULL UNIQUE,
senha VARCHAR(110) NOT NULL );

CREATE TABLE produto (
idProduto INT AUTO_INCREMENT PRIMARY KEY,
nomeProduto VARCHAR(110) NOT NULL,
descricao TEXT,
preco FLOAT (10,2) NOT NULL,
estoque INT NOT NULL,
categoria VARCHAR(45)
);

CREATE TABLE backupUsuario (
idBackup INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(110) NOT NULL,
login VARCHAR(110) NOT NULL,
senha VARCHAR(110) NOT NULL,
telefone VARCHAR(11) NOT NULL,
endereco VARCHAR(110) NOT NULL,
exclusaoUsuario DATETIME NOT NULL);

CREATE TABLE venda (
idVenda INT AUTO_INCREMENT PRIMARY KEY,
idProduto INT,
nome VARCHAR(110) NOT NULL,
quantidade int NOT NULL,
preco float NOT NULL);

INSERT INTO produto (nomeProduto,descricao,preco,estoque)
VALUES ('Bolo','Desc1',5.90,5),('Pão','Desc2',8.90,10);

INSERT INTO produto (nomeProduto,descricao,preco,estoque)
VALUES ('Pão','Pão de Forma 200g', 8.9, 10);

INSERT INTO produto (nomeProduto, descricao, preco, estoque)
VALUES ('Leite', 'Leite integral 1L', 3.50, 20);

INSERT INTO produto (nomeProduto, descricao, preco, estoque)
VALUES ('Arroz', 'Arroz branco tipo 1, pacote de 5kg', 15.99, 100);

INSERT INTO produto (nomeProduto, descricao, preco, estoque)
VALUES ('Feijão', 'Feijão carioca, pacote de 1kg', 5.49, 150);

INSERT INTO produto (nomeProduto, descricao, preco, estoque)
VALUES ('Azeite de Oliva', 'Azeite de oliva extra virgem, garrafa de 500ml', 19.99, 80);

INSERT INTO produto (nomeProduto, descricao, preco, estoque)
VALUES ('Carne Bovina', 'Carne bovina de primeira, kg', 29.99, 50);

INSERT INTO produto (nomeProduto, descricao, preco, estoque)
VALUES ('Sabonete', 'Sabonete líquido neutro, frasco de 250ml', 2.99, 120);
