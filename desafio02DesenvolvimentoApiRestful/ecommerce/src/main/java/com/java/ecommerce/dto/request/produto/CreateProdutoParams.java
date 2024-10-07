package com.java.ecommerce.dto.request.produto;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProdutoParams {
    @NotNull(message = "O nome do produto é obrigatório")
    private String nome;

    @NotNull(message = "A descrição do produto é obrigatória")
    private String descricao;

    @NotNull(message = "O valor do produto é obrigatório")
    @Min(value = 0, message = "O valor do produto deve ser maior ou igual a zero")
    private Double valor;

    private String imagemUrl;

    @NotNull(message = "A categoria do produto é obrigatória")
    private Long categoriaId;
}
