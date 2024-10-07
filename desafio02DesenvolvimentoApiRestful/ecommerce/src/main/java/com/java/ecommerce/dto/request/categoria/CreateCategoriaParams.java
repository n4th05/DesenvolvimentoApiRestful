package com.java.ecommerce.dto.request.categoria;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoriaParams {
    @NotNull(message = "O nome da categoria é obrigatório")
    private String nome;

    @NotNull(message = "A descrição da categoria é obrigatória")
    private String descricao;
}
