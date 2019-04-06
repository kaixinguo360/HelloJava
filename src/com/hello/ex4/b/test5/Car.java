package com.hello.ex4.b.test5;

public class Car implements ICommon {

    private double a, b, c;

    @Override
    public void setParams(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getSpeed() {
        return a * b / c;
    }
}
