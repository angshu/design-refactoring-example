package com.example.design.ocp;

public class Addition implements CalcOperation {
    private final double arg1;
    private final double arg2;

    public Addition(double arg1, double arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public double perform() {
        return arg1 + arg2;
    }
}
