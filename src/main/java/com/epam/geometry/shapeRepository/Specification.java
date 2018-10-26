package com.epam.geometry.shapeRepository;

public interface Specification<T> {

    boolean specified(T object);

}
