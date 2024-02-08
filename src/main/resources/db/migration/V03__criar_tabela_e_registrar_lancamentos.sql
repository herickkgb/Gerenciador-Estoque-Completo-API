CREATE TABLE lancamento (
    codigo BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10, 2) NOT NULL,
    observacao VARCHAR(100),
    tipo VARCHAR(20) NOT NULL,
    codigo_categoria BIGINT(20) NOT NULL,
    codigo_pessoa BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
    FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Conta de Luz', '2024-02-08', '2024-02-08', 150.00, 'Pagamento da conta de luz do mês', 'Despesa', 1, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Salário', '2024-02-15', '2024-02-15', 3000.00, 'Recebimento do salário', 'Receita', 2, 3);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Aluguel', '2024-03-01', '2024-03-01', 800.00, 'Pagamento do aluguel', 'Despesa', 3, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Compra Supermercado', '2024-02-10', '2024-02-10', 200.00, 'Compra mensal no supermercado', 'Despesa', 4, 4);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Reembolso', '2024-02-20', '2024-02-18', 50.00, 'Reembolso de despesas', 'Receita', 5, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Internet', '2024-02-12', '2024-02-12', 80.00, 'Pagamento mensal de internet', 'Despesa', 3, 7);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Presente Aniversário', '2024-02-25', '2024-02-25', 30.00, 'Compra de presente de aniversário', 'Despesa', 5, 8);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Consultoria', '2024-02-15', '2024-02-14', 500.00, 'Pagamento de consultoria', 'Despesa', 2, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Freelance Design', '2024-03-05', '2024-03-05', 300.00, 'Recebimento de pagamento por trabalho freelance', 'Receita', 4, 5);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) VALUES ('Manutenção Carro', '2024-02-18', '2024-02-18', 150.00, 'Manutenção do veículo', 'Despesa', 1, 2);
