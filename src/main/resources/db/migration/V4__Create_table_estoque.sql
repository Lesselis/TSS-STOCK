CREATE TABLE estoque (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produto_id BIGINT NOT NULL,
    movimentacao_tipo VARCHAR(255) NOT NULL,
    data DATETIME,
    quantidade INT,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
