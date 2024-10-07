package com.java.ecommerce.dto.response.endereco;

import com.java.ecommerce.entity.Endereco;

import lombok.Data;

@Data
public class EnderecoResponse {
public EnderecoResponse(Endereco endereco) {
    this.id = endereco.getId();
    this.cep = endereco.getCep();  
    this.rua = endereco.getRua();
    this.numero = endereco.getNumero();
    this.bairro = endereco.getBairro();
    this.complemento = endereco.getComplemento();
    this.cidade = endereco.getCidade();
    this.estado = endereco.getEstado();
}

    private Long id;
    private String cep;
    private String rua;
    private Integer numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
}
