package com.epam.geometry.observer;

public interface Observable<T> {

    void notifyObservers();

    void attach(T observer);


}
