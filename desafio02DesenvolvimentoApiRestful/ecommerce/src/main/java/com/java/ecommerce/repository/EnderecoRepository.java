package com.java.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.java.ecommerce.entity.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
