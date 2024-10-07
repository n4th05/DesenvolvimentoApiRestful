package com.java.ecommerce.dto.response.categoria;

import com.java.ecommerce.entity.Categoria;

import lombok.Data;

@Data
public class CategoriaResponse {
    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    private Long id;
    private String nome;
    private String descricao;
}
