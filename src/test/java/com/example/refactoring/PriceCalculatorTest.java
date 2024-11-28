package com.example.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class PriceCalculatorTest {

    @Test
    public void shouldCalculatePriceOfItemsInOrder() throws ExecutionException, InterruptedException {
        List<Item> items = Arrays.asList(new Item(20.0, 100.0), new Item(25.0, 20.0), new Item(30.0, 15.0));
        Order order = new Order(items);
        Double price = new PriceCalculator().calculatePrice(order);
        Assertions.assertEquals(85.13, price);
    }

    /**
     * This example shows example of legacy seam, where we are passing a function pointer that allows us to mock/replace
     * the costly shipping cost call
     */
    @Test
    public void shouldCalculatePriceOfItemsInOrderWithCallback() throws ExecutionException, InterruptedException {
        List<Item> items = Arrays.asList(new Item(20.0, 100.0), new Item(25.0, 20.0), new Item(30.0, 15.0));
        Order order = new Order(items);
        CompletableFuture<Double> getShippingForItems = CompletableFuture.completedFuture(78.2);
        Double price = new PriceCalculator().calculatePrice(order, orderItems -> {
            return getShippingForItems;
        });
        Assertions.assertEquals(153.2, price);
    }



}