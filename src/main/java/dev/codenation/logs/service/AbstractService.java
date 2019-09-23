package dev.codenation.logs.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public abstract class AbstractService<R extends JpaRepository<T, ID>, T, ID> {

    protected JpaRepository repository;

    public Optional<T> findById(UUID id) {
        return repository.findById(id);
    }

    public Page<T> findAll(Example<T> example, Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return repository.findAll(example, pageable);
    }

    public void delete(T object) {
        repository.delete((T) object);
    }

    public T save(T object) {
        return (T) repository.save(object);
    }

    public List<T> save(List<T> list) {
        return repository.saveAll(list);
    }
}
