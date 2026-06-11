package com.udec.unidad3hexagonal.application.service;

import com.udec.unidad3hexagonal.domain.exception.EntityNotFoundException;
import com.udec.unidad3hexagonal.domain.model.User;
import com.udec.unidad3hexagonal.domain.port.in.UserUseCase;
import com.udec.unidad3hexagonal.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User create(User user) {
        if (user.getStatus() == null || user.getStatus().isBlank()) {
            user.setStatus("ACTIVO");
        }
        return userRepositoryPort.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepositoryPort.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public User update(Long id, User user) {
        User current = findById(id);
        current.setName(user.getName());
        current.setEmail(user.getEmail());
        current.setPassword(user.getPassword());
        current.setRole(user.getRole());
        current.setStatus(user.getStatus());
        return userRepositoryPort.save(current);
    }

    @Override
    public void delete(Long id) {
        if (!userRepositoryPort.existsById(id)) {
            throw new EntityNotFoundException("Usuario no encontrado con id: " + id);
        }
        userRepositoryPort.deleteById(id);
    }
}
