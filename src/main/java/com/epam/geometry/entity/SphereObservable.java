package com.epam.geometry.entity;


import com.epam.geometry.observer.Observable;
import com.epam.geometry.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class SphereObservable extends Sphere implements Observable<Sphere> {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void setCenter(Point center) {
        super.setCenter(center);
        notifyObservers();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }


}
