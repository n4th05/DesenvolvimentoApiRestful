package com.java.ecommerce.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

import com.java.ecommerce.dto.request.produto.CreateProdutoParams;

import java.io.Serializable;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    public Produto(CreateProdutoParams params, Categoria categoria) {
        this.nome = params.getNome();
        this.descricao = params.getDescricao();
        this.valor = params.getValor();
        this.imagemUrl = params.getImagemUrl();
        this.categoria = categoria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
