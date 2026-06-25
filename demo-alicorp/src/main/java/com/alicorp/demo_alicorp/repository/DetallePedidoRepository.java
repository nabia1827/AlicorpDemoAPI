package com.alicorp.demo_alicorp.repository;

import com.alicorp.demo_alicorp.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository
        extends JpaRepository<DetallePedido, Long> {
}
