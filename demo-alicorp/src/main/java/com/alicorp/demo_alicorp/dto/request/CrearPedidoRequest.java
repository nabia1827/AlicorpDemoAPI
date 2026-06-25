package com.alicorp.demo_alicorp.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CrearPedidoRequest {

    private Long clienteId;

    private List<ItemPedidoRequest> productos;
}