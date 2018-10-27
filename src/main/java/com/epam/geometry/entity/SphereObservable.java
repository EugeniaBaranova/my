package com.epam.geometry.entity;


import com.epam.geometry.observer.Observable;
import com.epam.geometry.observer.Observer;

import java.util.List;

public class SphereObservable extends Sphere implements Observable<Sphere> {

    private List<Observer> observers;

    public void notifyObservers(){

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
