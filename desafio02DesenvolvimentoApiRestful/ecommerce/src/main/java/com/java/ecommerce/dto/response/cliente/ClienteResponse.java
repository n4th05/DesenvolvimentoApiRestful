package com.java.ecommerce.dto.response.cliente;

import java.util.Date;
import java.util.List;

import com.java.ecommerce.dto.response.endereco.EnderecoResponse;
import com.java.ecommerce.entity.Cliente;

import lombok.Data;

@Data
public class ClienteResponse {
    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.enderecos = cliente.getEnderecos().stream().map(endereco -> new EnderecoResponse(endereco)).toList();
    }

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<EnderecoResponse> enderecos;
}
