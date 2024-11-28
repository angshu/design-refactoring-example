package com.example.design.ocp;

public class DivisionOpsFactory implements OperationFactory {
    @Override
    public CalcOperation create(InputPair inputs) {
        return new Division(inputs.arg1(), inputs.arg2());
    }
}
