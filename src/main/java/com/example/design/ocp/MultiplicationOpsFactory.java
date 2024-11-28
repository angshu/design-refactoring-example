package com.example.design.ocp;

public class MultiplicationOpsFactory implements OperationFactory {
    @Override
    public CalcOperation create(InputPair inputs) {
        return new Multiplication(inputs.arg1(), inputs.arg2());
    }
}
