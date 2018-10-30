package com.epam.geometry.repository;


import com.epam.geometry.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void add(T object);

    void remove(T object);

    void update(T object, long id);

    Optional<List<T>> findBy(Specification specification);
}
