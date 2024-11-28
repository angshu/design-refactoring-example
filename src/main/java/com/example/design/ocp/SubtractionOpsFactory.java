package com.example.design.ocp;

public class SubtractionOpsFactory implements OperationFactory {
    @Override
    public CalcOperation create(InputPair inputs) {
        return new Subtraction(inputs.arg1(), inputs.arg2());
    }
}
