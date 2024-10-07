CREATE TABLE produtos(
    id SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    descricao VARCHAR NOT NULL,
    valor FLOAT NOT NULL,
    imagem_url VARCHAR,
    categoria_id INTEGER NOT NULL REFERENCES categorias(id)
);