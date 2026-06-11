package com.udec.unidad3hexagonal.infrastructure.adapter.persistence.mapper;

import com.udec.unidad3hexagonal.domain.model.User;
import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {
    public User toDomain(UserEntity entity) {
        if (entity == null) return null;
        return new User(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword(), entity.getRole(), entity.getStatus());
    }

    public UserEntity toEntity(User domain) {
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        entity.setRole(domain.getRole());
        entity.setStatus(domain.getStatus());
        return entity;
    }
}
