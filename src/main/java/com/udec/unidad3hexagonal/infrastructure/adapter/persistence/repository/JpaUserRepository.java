package com.udec.unidad3hexagonal.infrastructure.adapter.persistence.repository;

import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
