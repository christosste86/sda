package com.sda.generics;

public class MyClass<T> {
    private T object;

    public MyClass(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "object=" + object +
                '}';
    }
}
