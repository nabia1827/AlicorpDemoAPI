package com.alicorp.demo_alicorp.repository;

import com.alicorp.demo_alicorp.entity.Estado;
import com.alicorp.demo_alicorp.entity.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperacionRepository extends JpaRepository<Operacion, Long> {
    List<Operacion> findByEstado(Estado estado);
}
