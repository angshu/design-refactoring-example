package com.example.refactoring;

import java.util.concurrent.CompletableFuture;

public interface IShippingCalculator {
    CompletableFuture<Double> calculateShipping(Order order);
}
