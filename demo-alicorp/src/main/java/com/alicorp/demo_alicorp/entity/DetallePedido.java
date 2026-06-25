package com.alicorp.demo_alicorp.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="DetallePedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleId;

    private Integer cantidad;

    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name="pedidoId")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="productoId")
    private Producto producto;
}