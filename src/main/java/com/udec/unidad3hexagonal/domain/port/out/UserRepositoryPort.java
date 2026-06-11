package com.udec.unidad3hexagonal.domain.port.out;

import com.udec.unidad3hexagonal.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
