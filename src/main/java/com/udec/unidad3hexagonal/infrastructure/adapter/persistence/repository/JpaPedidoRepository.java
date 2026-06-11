package com.udec.unidad3hexagonal.infrastructure.adapter.persistence.repository;

import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
