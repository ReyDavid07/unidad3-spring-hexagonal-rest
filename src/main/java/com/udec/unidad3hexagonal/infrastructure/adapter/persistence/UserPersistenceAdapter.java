package com.udec.unidad3hexagonal.infrastructure.adapter.persistence;

import com.udec.unidad3hexagonal.domain.model.User;
import com.udec.unidad3hexagonal.domain.port.out.UserRepositoryPort;
import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.mapper.UserPersistenceMapper;
import com.udec.unidad3hexagonal.infrastructure.adapter.persistence.repository.JpaUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;
    private final UserPersistenceMapper mapper;

    public UserPersistenceAdapter(JpaUserRepository jpaUserRepository, UserPersistenceMapper mapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        return mapper.toDomain(jpaUserRepository.save(mapper.toEntity(user)));
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaUserRepository.existsById(id);
    }
}
