package com.alicorp.demo_alicorp.repository;
import com.alicorp.demo_alicorp.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {
}