package com.java.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.*;

import jakarta.persistence.*;

import com.java.ecommerce.dto.request.cliente.CreateClienteParams;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    public Cliente(CreateClienteParams params) {
        this.nome = params.getNome();
        this.cpf = params.getCpf();
        this.dataNascimento = params.getDataNascimento();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, name = "data_nascimento")
    private Date dataNascimento;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Endereco> enderecos;
}
