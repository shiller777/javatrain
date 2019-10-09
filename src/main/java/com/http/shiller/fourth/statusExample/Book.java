package com.http.shiller.fourth.statusExample;

public class Book implements BookInterface {
    private int i;

    public Book(int i) {
        this.i = i;
    }

    public Status getStatus() {
        return null;
    }

    @Override
    public void setStatus(Status status) {

    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
