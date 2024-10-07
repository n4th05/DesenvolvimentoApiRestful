package com.java.ecommerce.dto.request.produto;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProdutoParams {
    private Long id;

    private String nome;

    private String descricao;

    @Min(value = 0, message = "O valor do produto deve ser maior ou igual a zero")
    private Double valor;

    private String imagemUrl;

    private Long categoriaId;
}
