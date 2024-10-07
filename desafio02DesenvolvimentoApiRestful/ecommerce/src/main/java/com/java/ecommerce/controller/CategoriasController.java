package com.java.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.java.ecommerce.dto.request.categoria.CreateCategoriaParams;
import com.java.ecommerce.dto.request.categoria.UpdateCategoriaParams;
import com.java.ecommerce.dto.response.categoria.CategoriaResponse;
import com.java.ecommerce.service.CategoriaService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@Validated
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> create(@Valid @RequestBody CreateCategoriaParams params) {
        CategoriaResponse response = categoriaService.create(params);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> find() {
        List<CategoriaResponse> categorias = categoriaService.find();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        CategoriaResponse categoria = categoriaService.update(new UpdateCategoriaParams(id, null, null));
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateCategoriaParams params) {
        params.setId(id);
        CategoriaResponse response = categoriaService.update(params);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
