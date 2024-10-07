CREATE TABLE clientes(
    id SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    cpf VARCHAR UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL
);