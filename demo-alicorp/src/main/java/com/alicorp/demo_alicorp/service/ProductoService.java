package com.alicorp.demo_alicorp.service;

import com.alicorp.demo_alicorp.entity.Producto;
import com.alicorp.demo_alicorp.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> getAll() {
        return repository.findAll();
    }

    public Producto createOrUpdate(Producto producto) {
        return repository.save(producto);
    }

    public Producto get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}