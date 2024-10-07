package com.java.ecommerce.entity;

import lombok.*;

import jakarta.persistence.*;

import com.java.ecommerce.dto.request.endereco.CreateEnderecoParams;

import java.io.Serializable;

@Entity
@Table(name = "enderecos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    public Endereco(CreateEnderecoParams params, Cliente cliente){
        this.cep = params.getCep();
        this.rua = params.getRua();
        this.numero = params.getNumero();
        this.bairro = params.getBairro();
        this.complemento = params.getComplemento();
        this.cidade = params.getCidade();
        this.estado = params.getEstado();
        this.cliente = cliente;
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String bairro;

    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
