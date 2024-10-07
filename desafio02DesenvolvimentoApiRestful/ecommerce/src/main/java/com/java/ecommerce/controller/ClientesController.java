package com.java.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.java.ecommerce.dto.request.cliente.CreateClienteParams;
import com.java.ecommerce.dto.request.cliente.UpdateClienteParams;
import com.java.ecommerce.dto.response.cliente.ClienteResponse;
import com.java.ecommerce.service.ClienteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> create(@Valid @RequestBody CreateClienteParams params) {
        ClienteResponse response = clienteService.create(params);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> find() {
        List<ClienteResponse> clientes = clienteService.find();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {
        ClienteResponse cliente = clienteService.update(new UpdateClienteParams(id, null, null, null));
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateClienteParams params) {
        params.setId(id);
        ClienteResponse response = clienteService.update(params);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
