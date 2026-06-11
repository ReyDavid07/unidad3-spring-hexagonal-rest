package com.udec.unidad3hexagonal.infrastructure.adapter.persistence;

import com.udec.unidad3hexagonal.domain.model.Pedido;
import com.udec.unidad3hexagonal.domain.port.out.PedidoRepositoryPort;
import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.mapper.PedidoPersistenceMapper;
import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.repository.JpaPedidoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoPersistenceAdapter implements PedidoRepositoryPort {
    private final JpaPedidoRepository jpaPedidoRepository;
    private final PedidoPersistenceMapper mapper;

    public PedidoPersistenceAdapter(JpaPedidoRepository jpaPedidoRepository, PedidoPersistenceMapper mapper) {
        this.jpaPedidoRepository = jpaPedidoRepository;
        this.mapper = mapper;
    }

    @Override
    public Pedido save(Pedido pedido) {
        return mapper.toDomain(jpaPedidoRepository.save(mapper.toEntity(pedido)));
    }

    @Override
    public List<Pedido> findAll() {
        return jpaPedidoRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return jpaPedidoRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaPedidoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaPedidoRepository.existsById(id);
    }
}
