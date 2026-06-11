package com.udec.unidad3hexagonal.domain.port.out;

import com.udec.unidad3hexagonal.domain.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {
    Pedido save(Pedido pedido);
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
