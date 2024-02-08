CREATE TABLE pessoa (
   codigo BIGINT (20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   nome VARCHAR(50) NOT NULL,
   ativo BOOLEAN NOT NULL,
   logradouro VARCHAR(50) NOT NULL,
   numero VARCHAR(50) NOT NULL,
   complemento VARCHAR(50) NOT NULL,
   bairro VARCHAR(50) NOT NULL,
   cep VARCHAR(50) NOT NULL,
   cidade VARCHAR(50) NOT NULL,
   estado VARCHAR(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Ana Silva', false, 'Avenida Afonso Pena', '1001', 'Casa','Centro', '30130-000', 'Belo Horizonte', 'MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Carlos Oliveira', true, 'Rua da Bahia', '500','Casa', 'Centro', '30160-011', 'Belo Horizonte', 'MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Fernanda Santos', true, 'Avenida Cristiano Machado', '4000','Casa', 'Cidade Nova', '31170-800', 'Belo Horizonte', 'MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('José Lima', false, 'Rua Padre Eustáquio', '900', 'Casa','Padre Eustáquio', '30720-450', 'Belo Horizonte', 'MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Mariana Oliveira', true, 'Avenida Amazonas', '500', 'Casa','Centro', '30180-001', 'Belo Horizonte', 'MG');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Pedro Santos', true, 'Rua Teste', '123', 'Bairro Teste','Casa', '12345-678', 'Cidade Teste', 'TT');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Camila Lima', false, 'Avenida Principal', '789','Casa', 'Bairro Principal', '98765-432', 'Cidade Principal', 'CP');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Ricardo Oliveira', true, 'Rua Nova', '456','Casa', 'Bairro Novo', '54321-876', 'Cidade Nova', 'CN');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Isabela Silva', false, 'Avenida Velha', '321','Casa', 'Bairro Velho', '87654-321', 'Cidade Velha', 'CV');
INSERT INTO pessoa (nome, ativo, logradouro, numero,complemento ,bairro, cep, cidade, estado) VALUES ('Lucas Pereira', true, 'Rua Final', '999','Casa', 'Bairro Final', '133878-999', 'Cidade Final', 'CF');
