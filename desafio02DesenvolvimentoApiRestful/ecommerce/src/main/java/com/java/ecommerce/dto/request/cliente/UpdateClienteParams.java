package com.java.ecommerce.dto.request.cliente;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClienteParams {
    private Long id;

    private String nome;

    private String cpf;

    private Date dataNascimento;
}
