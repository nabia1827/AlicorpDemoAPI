package com.alicorp.demo_alicorp.dto.request;

import com.alicorp.demo_alicorp.entity.Estado;
import com.alicorp.demo_alicorp.entity.Moneda;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RegistrarOperacionRequest {
    private Moneda moneda_origen;
    private Moneda moneda_destino;
    private Float monto_origen;
    private Float tipo_cambio;
    private LocalDateTime fecha_operacion;
    private Estado estado;
    private LocalDate created_at;
}
