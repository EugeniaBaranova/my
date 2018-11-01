package com.epam.geometry.observer;

import com.epam.geometry.entity.SphereObservable;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SphereObserverObservableIT {

    private SphereDataStorage sphereDataStorage = new SphereDataStorage();
    private SphereObservable sphereObservable = new SphereObservable(sphereDataStorage);
    private SphereObserver sphereObserver = new SphereObserver(sphereObservable);

    @Test
    public void shouldUpdateDataWhenSetSphereParameters() {
        //when
        sphereObservable.setRadius(3);
        //then
        Assert.assertThat(
                sphereDataStorage.getVolume(), is(113.09733552923254));
        Assert.assertThat(
                sphereDataStorage.getSurfaceArea(), is(113.09733552923255));
    }


}
