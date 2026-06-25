package com.alicorp.demo_alicorp.controller;

import com.alicorp.demo_alicorp.entity.Producto;
import com.alicorp.demo_alicorp.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Producto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return service.createOrUpdate(producto);
    }

    @PutMapping("/{id}")
    public Producto update(
            @PathVariable Long id,
            @RequestBody Producto producto) {

        producto.setProductoId(id);
        return service.createOrUpdate(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
