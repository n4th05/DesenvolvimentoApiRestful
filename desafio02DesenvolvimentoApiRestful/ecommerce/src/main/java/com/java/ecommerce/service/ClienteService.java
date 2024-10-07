package com.java.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ecommerce.dto.request.cliente.CreateClienteParams;
import com.java.ecommerce.dto.request.cliente.UpdateClienteParams;
import com.java.ecommerce.dto.response.cliente.ClienteResponse;
import com.java.ecommerce.entity.Cliente;
import com.java.ecommerce.entity.Endereco;
import com.java.ecommerce.repository.ClienteRepository;
import com.java.ecommerce.repository.EnderecoRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ClienteResponse create(CreateClienteParams params) {
        Cliente cliente = this.clienteRepository.save(new Cliente(params));

        List<Endereco> enderecos = new ArrayList<>();

        if (params.getEnderecos() != null) {
            params.getEnderecos().forEach(endereco -> {
                enderecos.add(this.enderecoRepository.save(new Endereco(endereco, cliente)));
            });
        }

        cliente.setEnderecos(enderecos);
        return new ClienteResponse(this.clienteRepository.save(cliente));
    }

    public List<ClienteResponse> find() {
        return this.clienteRepository.findAll().stream().map(cliente -> new ClienteResponse(cliente)).toList();
    }

    public ClienteResponse update(UpdateClienteParams params) {
        Optional<Cliente> cliente = this.clienteRepository.findById(params.getId());

        if (cliente.isPresent()) {
            Cliente updatedCliente = cliente.get();

            if (params.getNome() != null) {
                updatedCliente.setNome(params.getNome());
            }

            if (params.getCpf() != null) {
                updatedCliente.setCpf(params.getCpf());
            }

            if (params.getDataNascimento() != null) {
                updatedCliente.setDataNascimento(params.getDataNascimento());
            }

            return new ClienteResponse((this.clienteRepository.save(updatedCliente)));
        }
        return null;
    }

    public void delete(long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if (cliente.isPresent()) {
            this.clienteRepository.delete(cliente.get());
        }
    }
}
