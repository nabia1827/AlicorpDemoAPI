package com.alicorp.demo_alicorp.controller;
import com.alicorp.demo_alicorp.dto.request.CrearPedidoRequest;
import com.alicorp.demo_alicorp.entity.Pedido;
import com.alicorp.demo_alicorp.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(
            PedidoService pedidoService) {

        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {

        return ResponseEntity.ok(
                pedidoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> get(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                pedidoService.get(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> create(
            @RequestBody Pedido pedido) {

        Pedido nuevoPedido =
                pedidoService.createOrUpdate(pedido);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nuevoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        pedidoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create-pedido")
    public ResponseEntity<Pedido> createPedido(
            @RequestBody CrearPedidoRequest request) {

        return ResponseEntity.ok(
                pedidoService.createPedido(request));
    }
}