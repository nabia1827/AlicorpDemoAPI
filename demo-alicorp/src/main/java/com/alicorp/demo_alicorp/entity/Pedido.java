package com.alicorp.demo_alicorp.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name="Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    private LocalDate fecha;

    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name="clienteId")
    private Cliente cliente;
}