package com.example.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class ShippingCalculatorTest {

    @Test
    public void shouldCalculateShippingChargesForOrder() throws Exception {
        System.out.println("Hello! I am initiating the calculation");
        List<Item> items = Arrays.asList(new Item(20.0, 100.0), new Item(25.0, 20.0), new Item(30.0, 15.0));
        Order order = new Order(items);
        CompletableFuture<Double> shippingCostFuture = new ShippingCalculator().calculateShipping(order).whenComplete((result, error) -> {
            if (error != null) {
                System.out.println("Error returned from calculation: " + error.getMessage());
            } else {
                System.out.println("Result returned from calculation: " + result);
            }
        });
        System.out.println("Hello! I am done initiating the calculation. Not my job anymore");
        Assertions.assertEquals(10.13, shippingCostFuture.get());
    }

}