package com.java.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.java.ecommerce.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
