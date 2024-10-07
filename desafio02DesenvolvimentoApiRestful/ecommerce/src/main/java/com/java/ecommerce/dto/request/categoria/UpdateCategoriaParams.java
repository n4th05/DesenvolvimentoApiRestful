package com.java.ecommerce.dto.request.categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoriaParams {
    private Long id;

    private String nome;

    private String descricao;
}
