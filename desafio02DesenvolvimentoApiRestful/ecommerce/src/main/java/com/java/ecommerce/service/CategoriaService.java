package com.java.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ecommerce.dto.request.categoria.CreateCategoriaParams;
import com.java.ecommerce.dto.request.categoria.UpdateCategoriaParams;
import com.java.ecommerce.dto.response.categoria.CategoriaResponse;
import com.java.ecommerce.entity.Categoria;
import com.java.ecommerce.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponse create(CreateCategoriaParams params) {
        return new CategoriaResponse(this.categoriaRepository.save(new Categoria(params)));
    }

    public List<CategoriaResponse> find() {
        return this.categoriaRepository.findAll().stream().map(categoria -> new CategoriaResponse(categoria)).toList();
    }

    public CategoriaResponse update(UpdateCategoriaParams params) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(params.getId());

        if (categoria.isPresent()) {
            Categoria updatedCategoria = categoria.get();

            if (params.getNome() != null) {
                updatedCategoria.setNome(params.getNome());
            }

            if (params.getDescricao() != null) {
                updatedCategoria.setDescricao(params.getDescricao());
            }

            return new CategoriaResponse(this.categoriaRepository.save(updatedCategoria));
        }
        return null;
    }

    public void delete(Long id){
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            this.categoriaRepository.delete(categoria.get());
        }
    }
}
