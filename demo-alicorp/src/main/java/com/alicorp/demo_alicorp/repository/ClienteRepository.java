package com.alicorp.demo_alicorp.repository;

import com.alicorp.demo_alicorp.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {
}
