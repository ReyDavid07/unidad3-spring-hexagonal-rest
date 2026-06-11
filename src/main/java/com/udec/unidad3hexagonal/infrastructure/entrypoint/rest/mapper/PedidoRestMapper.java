package com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.mapper;

import com.udec.unidad3hexagonal.domain.model.Pedido;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.CreatePedidoRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.UpdatePedidoRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.response.PedidoResponse;
import org.springframework.stereotype.Component;

@Component
public class PedidoRestMapper {
    public Pedido toDomain(CreatePedidoRequest request) {
        return new Pedido(null, request.getNumeroPedido(), request.getCliente(), request.getProducto(), request.getCantidad(), request.getValorUnitario(), "PENDIENTE", request.getFecha());
    }

    public Pedido toDomain(UpdatePedidoRequest request) {
        return new Pedido(null, request.getNumeroPedido(), request.getCliente(), request.getProducto(), request.getCantidad(), request.getValorUnitario(), request.getEstado(), request.getFecha());
    }

    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getNumeroPedido(), pedido.getCliente(), pedido.getProducto(), pedido.getCantidad(), pedido.getValorUnitario(), pedido.getTotal(), pedido.getEstado(), pedido.getFecha());
    }
}
