package com.java.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.ecommerce.dto.request.produto.CreateProdutoParams;
import com.java.ecommerce.dto.request.produto.FindProdutosParams;
import com.java.ecommerce.dto.request.produto.UpdateProdutoParams;
import com.java.ecommerce.dto.response.produto.ProdutoResponse;
import com.java.ecommerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody CreateProdutoParams params) {
        ProdutoResponse response = produtoService.create(params);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> find(@RequestParam(required = false) Long categoriaId) {
        FindProdutosParams params = new FindProdutosParams();
        params.setCategoriaId(categoriaId);
        
        List<ProdutoResponse> produtos = produtoService.find(params);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        ProdutoResponse produto = produtoService.findById(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody UpdateProdutoParams params) {
        params.setId(id);
        ProdutoResponse response = produtoService.update(params);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
