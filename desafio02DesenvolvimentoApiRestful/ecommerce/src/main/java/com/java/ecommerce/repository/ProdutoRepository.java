package com.java.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.java.ecommerce.entity.Categoria;
import com.java.ecommerce.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(Categoria categoria);
}
