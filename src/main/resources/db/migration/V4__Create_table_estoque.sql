CREATE TABLE quantidade_estoque (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produto_id BIGINT NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    data DATE,
    quantidade INT,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
