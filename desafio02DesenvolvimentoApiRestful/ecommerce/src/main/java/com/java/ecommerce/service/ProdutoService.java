package com.java.ecommerce.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ecommerce.dto.request.produto.CreateProdutoParams;
import com.java.ecommerce.dto.request.produto.FindProdutosParams;
import com.java.ecommerce.dto.request.produto.UpdateProdutoParams;
import com.java.ecommerce.dto.response.produto.ProdutoResponse;
import com.java.ecommerce.entity.Categoria;
import com.java.ecommerce.entity.Produto;
import com.java.ecommerce.repository.CategoriaRepository;
import com.java.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoResponse create(CreateProdutoParams params) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(params.getCategoriaId());
        if (categoria.isPresent()) {
            Produto produto = new Produto(params, categoria.get());
            return new ProdutoResponse(this.produtoRepository.save(produto));
        }
        return null;
    }

    public ProdutoResponse findById(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()) {
            return new ProdutoResponse(produto.get());
        }
        return null;
    }

    public List<ProdutoResponse> find(FindProdutosParams params) {
        if (params.getCategoriaId() != null) {
            Optional<Categoria> categoria = this.categoriaRepository.findById(params.getCategoriaId());
            if (categoria.isPresent()) {
                return this.produtoRepository.findByCategoria(categoria.get()).stream()
                        .map(produto -> new ProdutoResponse(produto)).toList();
            }
        }
        return this.produtoRepository.findAll().stream().map(produto -> new ProdutoResponse(produto)).toList();
    }

    public ProdutoResponse update(UpdateProdutoParams params) {
        Optional<Produto> produto = this.produtoRepository.findById(params.getId());
        if (produto.isPresent()) {
            Produto updatedProduto = produto.get();
            if (params.getNome() != null) updatedProduto.setNome(params.getNome());
            if (params.getDescricao() != null) updatedProduto.setDescricao(params.getDescricao());
            if (params.getValor() != null) updatedProduto.setValor(params.getValor());
            if (params.getImagemUrl() != null) updatedProduto.setImagemUrl(params.getImagemUrl());
            if (params.getCategoriaId() != null) {
                Optional<Categoria> categoria = this.categoriaRepository.findById(params.getCategoriaId());
                if (categoria.isPresent()) {
                    updatedProduto.setCategoria(categoria.get());
                }
            }
            return new ProdutoResponse(this.produtoRepository.save(updatedProduto));
        }
        return null;
    }

    public void delete(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()) {
            this.produtoRepository.delete(produto.get());
        }
    }
}
