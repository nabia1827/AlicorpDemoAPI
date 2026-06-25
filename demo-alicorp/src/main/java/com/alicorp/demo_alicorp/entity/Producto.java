package com.alicorp.demo_alicorp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    private String nombre;

    private Double precio;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private Categoria categoria;
}