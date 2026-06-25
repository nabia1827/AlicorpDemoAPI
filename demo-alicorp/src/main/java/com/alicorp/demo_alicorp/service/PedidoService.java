package com.alicorp.demo_alicorp.service;
import com.alicorp.demo_alicorp.dto.request.*;
import com.alicorp.demo_alicorp.entity.*;
import com.alicorp.demo_alicorp.repository.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final DetallePedidoRepository detallePedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProductoRepository productoRepository,
                         ClienteRepository clienteRepository,
                         DetallePedidoRepository detallePedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido get(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pedido no encontrado"));
    }

    public Pedido createOrUpdate(Pedido pedido) {

        if (pedido.getFecha() == null) {
            pedido.setFecha(LocalDate.now());
        }

        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {

        Pedido pedido = get(id);

        pedidoRepository.delete(pedido);
    }

    @Transactional
    public Pedido createPedido(CrearPedidoRequest request) {

        Cliente cliente = clienteRepository
                .findById(request.getClienteId())
                .orElseThrow();

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setFecha(LocalDate.now());

        double total = 0;

        pedido = pedidoRepository.save(pedido);

        for (ItemPedidoRequest item : request.getProductos()) {

            Producto producto = productoRepository
                    .findById(item.getProductoId())
                    .orElseThrow();

            DetallePedido detalle = new DetallePedido();

            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(item.getCantidad());

            detalle.setPrecioUnitario(
                    producto.getPrecio());

            detallePedidoRepository.save(detalle);

            total += producto.getPrecio()
                    * item.getCantidad();

            producto.setStock(
                    producto.getStock()
                            - item.getCantidad());

            productoRepository.save(producto);
        }

        pedido.setMontoTotal(total);

        return pedidoRepository.save(pedido);
    }
}
