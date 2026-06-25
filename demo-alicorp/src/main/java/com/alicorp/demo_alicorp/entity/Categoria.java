package com.alicorp.demo_alicorp.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;

    private String nombre;
}
