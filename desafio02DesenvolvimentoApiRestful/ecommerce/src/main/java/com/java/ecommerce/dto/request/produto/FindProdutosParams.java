package com.java.ecommerce.dto.request.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindProdutosParams {
    private Long categoriaId;
}
