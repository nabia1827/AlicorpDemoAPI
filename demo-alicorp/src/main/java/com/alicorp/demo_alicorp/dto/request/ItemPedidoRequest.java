package com.alicorp.demo_alicorp.dto.request;

import lombok.Data;

@Data
public class ItemPedidoRequest {

    private Long productoId;

    private Integer cantidad;
}
