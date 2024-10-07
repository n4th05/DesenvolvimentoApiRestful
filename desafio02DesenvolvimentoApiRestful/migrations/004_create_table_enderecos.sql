create table enderecos(
    id SERIAL PRIMARY KEY,
    cep varchar not null,
    rua varchar not null,
    numero integer not null,
    bairro varchar not null,
    complemento varchar,
    cidade varchar not null,
    estado varchar not null,
    cliente_id INTEGER NOT NULL REFERENCES clientes(id)
);