package com.java.ecommerce.dto.response.produto;

import com.java.ecommerce.dto.response.categoria.CategoriaResponse;
import com.java.ecommerce.entity.Produto;

import lombok.Data;

@Data
public class ProdutoResponse {
    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.imagemUrl = produto.getImagemUrl();
        this.categoria = new CategoriaResponse(produto.getCategoria());
    }

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private String imagemUrl;
    private CategoriaResponse categoria;
}
