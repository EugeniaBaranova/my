package com.epam.geometry.shapeRepository;


import java.util.List;

public interface Repository<T> {

    void add(T object);

    void remove(T object);

    void update(T object);

    List<T> findBy(Specification specification);
}
