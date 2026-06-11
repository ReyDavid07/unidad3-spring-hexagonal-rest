package com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.controller;

import com.udec.unidad3hexagonal.domain.port.in.PedidoUseCase;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.CreatePedidoRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.UpdatePedidoRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.response.PedidoResponse;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.mapper.PedidoRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
    private final PedidoUseCase pedidoUseCase;
    private final PedidoRestMapper mapper;

    public PedidoRestController(PedidoUseCase pedidoUseCase, PedidoRestMapper mapper) {
        this.pedidoUseCase = pedidoUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> create(@Valid @RequestBody CreatePedidoRequest request) {
        PedidoResponse response = mapper.toResponse(pedidoUseCase.create(mapper.toDomain(request)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<PedidoResponse> findAll() {
        return pedidoUseCase.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public PedidoResponse findById(@PathVariable Long id) {
        return mapper.toResponse(pedidoUseCase.findById(id));
    }

    @PutMapping("/{id}")
    public PedidoResponse update(@PathVariable Long id, @Valid @RequestBody UpdatePedidoRequest request) {
        return mapper.toResponse(pedidoUseCase.update(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
