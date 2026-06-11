package com.udec.unidad3hexagonal.application.service;

import com.udec.unidad3hexagonal.domain.exception.EntityNotFoundException;
import com.udec.unidad3hexagonal.domain.model.Pedido;
import com.udec.unidad3hexagonal.domain.port.in.PedidoUseCase;
import com.udec.unidad3hexagonal.domain.port.out.PedidoRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService implements PedidoUseCase {
    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public Pedido create(Pedido pedido) {
        if (pedido.getEstado() == null || pedido.getEstado().isBlank()) {
            pedido.setEstado("PENDIENTE");
        }
        if (pedido.getFecha() == null) {
            pedido.setFecha(LocalDate.now());
        }
        return pedidoRepositoryPort.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepositoryPort.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con id: " + id));
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Pedido current = findById(id);
        current.setNumeroPedido(pedido.getNumeroPedido());
        current.setCliente(pedido.getCliente());
        current.setProducto(pedido.getProducto());
        current.setCantidad(pedido.getCantidad());
        current.setValorUnitario(pedido.getValorUnitario());
        current.setEstado(pedido.getEstado());
        current.setFecha(pedido.getFecha());
        return pedidoRepositoryPort.save(current);
    }

    @Override
    public void delete(Long id) {
        if (!pedidoRepositoryPort.existsById(id)) {
            throw new EntityNotFoundException("Pedido no encontrado con id: " + id);
        }
        pedidoRepositoryPort.deleteById(id);
    }
}
