package com.udec.unidad3hexagonal.domain.port.in;

import com.udec.unidad3hexagonal.domain.model.User;
import java.util.List;

public interface UserUseCase {
    User create(User user);
    List<User> findAll();
    User findById(Long id);
    User update(Long id, User user);
    void delete(Long id);
}
