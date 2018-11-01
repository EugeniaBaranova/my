package com.epam.geometry.observer;

import com.epam.geometry.entity.SphereObservable;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SphereObserverTest {

    private SphereObservable sphereObservable = mock(SphereObservable.class);
    private SphereObserver sphereObserver = new SphereObserver(sphereObservable);

   /* @Test
    public void shouldUpdateValuesWhenSetNewParameters() {
        //given
        when(sphereObservable.getRadius()).thenReturn(3.0);
        //when
        sphereObserver.update();
        //then
        Assert.assertThat(113.09733552923254,is(sphereObserver.getVolume()));
        Assert.assertThat(113.09733552923255,is(sphereObserver.getSurfaceArea()));
    }*/


}
