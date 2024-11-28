package com.example.design.ocp;

public class AdditionOpsFactory implements OperationFactory {
    @Override
    public CalcOperation create(InputPair inputs) {
        return new Addition(inputs.arg1(), inputs.arg2());
    }
}
