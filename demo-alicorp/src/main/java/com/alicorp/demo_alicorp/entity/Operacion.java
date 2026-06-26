package com.alicorp.demo_alicorp.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="fx_operacion")
public class Operacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Moneda moneda_origen;

    @Enumerated(EnumType.STRING)
    private Moneda moneda_destino;

    @Positive
    private Float monto_origen;

    @Column(name = "monto_destino",insertable = false, updatable = false)
    private Float monto_destino;

    @Positive
    private Float tipo_cambio;

    private LocalDateTime fecha_operacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate created_at;
}
