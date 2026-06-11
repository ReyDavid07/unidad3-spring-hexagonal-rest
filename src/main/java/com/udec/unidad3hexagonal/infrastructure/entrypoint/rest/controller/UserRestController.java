package com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.controller;

import com.udec.unidad3hexagonal.domain.port.in.UserUseCase;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.CreateUserRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.request.UpdateUserRequest;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.dto.response.UserResponse;
import com.udec.unidad3hexagonal.infrastructure.entrypoint.rest.mapper.UserRestMapper;
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
@RequestMapping("/api/users")
public class UserRestController {
    private final UserUseCase userUseCase;
    private final UserRestMapper mapper;

    public UserRestController(UserUseCase userUseCase, UserRestMapper mapper) {
        this.userUseCase = userUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        UserResponse response = mapper.toResponse(userUseCase.create(mapper.toDomain(request)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userUseCase.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return mapper.toResponse(userUseCase.findById(id));
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        return mapper.toResponse(userUseCase.update(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
