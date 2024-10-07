package com.java.ecommerce.dto.request.cliente;

import java.sql.Date;
import java.util.List;

import com.java.ecommerce.dto.request.endereco.CreateEnderecoParams;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateClienteParams {
    @NotNull(message = "O nome do cliente é obrigatório")
    private String nome;

    @NotNull(message = "O cpf do cliente é obrigatório")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    private Date dataNascimento;

    private List<CreateEnderecoParams> enderecos;
}
