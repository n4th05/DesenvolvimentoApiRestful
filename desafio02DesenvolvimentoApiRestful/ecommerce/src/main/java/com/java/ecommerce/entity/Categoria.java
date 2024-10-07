package com.java.ecommerce.entity;

import lombok.*;
import jakarta.persistence.*;
import com.java.ecommerce.dto.request.categoria.CreateCategoriaParams;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Categoria(CreateCategoriaParams params){
        this.nome = params.getNome();
        this.descricao = params.getDescricao();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}