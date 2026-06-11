package com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.mapper;

import com.udec.unidad3hexagonal.domain.model.User;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.CreateUserRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.UpdateUserRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserRestMapper {
    public User toDomain(CreateUserRequest request) {
        return new User(null, request.getName(), request.getEmail(), request.getPassword(), request.getRole(), "ACTIVO");
    }

    public User toDomain(UpdateUserRequest request) {
        return new User(null, request.getName(), request.getEmail(), request.getPassword(), request.getRole(), request.getStatus());
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getStatus());
    }
}
