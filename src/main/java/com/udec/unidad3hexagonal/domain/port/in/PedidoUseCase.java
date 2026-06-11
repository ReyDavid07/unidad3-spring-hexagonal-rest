package com.udec.unidad3hexagonal.domain.port.in;

import com.udec.unidad3hexagonal.domain.model.Pedido;
import java.util.List;

public interface PedidoUseCase {
    Pedido create(Pedido pedido);
    List<Pedido> findAll();
    Pedido findById(Long id);
    Pedido update(Long id, Pedido pedido);
    void delete(Long id);
}
