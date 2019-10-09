package com.http.shiller.fourth.statusExample;

public interface HasStatus<T> {
    T getStatus();

    void setStatus(T status);
}
