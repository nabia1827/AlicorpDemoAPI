package com.alicorp.demo_alicorp.repository;

import com.alicorp.demo_alicorp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository
        extends JpaRepository<Producto, Long> {
}