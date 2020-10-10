package com.skurski.designpatterns.observer.complex;

import java.io.Serializable;

public interface EventNotificationListener<T> extends Serializable {
    void onClientAdded(T client);
}