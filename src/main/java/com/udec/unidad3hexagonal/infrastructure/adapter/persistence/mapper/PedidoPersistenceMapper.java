package com.udec.unidad3hexagonal.infrastructure.adapter.persistence.mapper;

import com.udec.unidad3hexagonal.domain.model.Pedido;
import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.entity.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoPersistenceMapper {
    public Pedido toDomain(PedidoEntity entity) {
        if (entity == null) return null;
        return new Pedido(entity.getId(), entity.getNumeroPedido(), entity.getCliente(), entity.getProducto(), entity.getCantidad(), entity.getValorUnitario(), entity.getEstado(), entity.getFecha());
    }

    public PedidoEntity toEntity(Pedido domain) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(domain.getId());
        entity.setNumeroPedido(domain.getNumeroPedido());
        entity.setCliente(domain.getCliente());
        entity.setProducto(domain.getProducto());
        entity.setCantidad(domain.getCantidad());
        entity.setValorUnitario(domain.getValorUnitario());
        entity.setEstado(domain.getEstado());
        entity.setFecha(domain.getFecha());
        return entity;
    }
}
