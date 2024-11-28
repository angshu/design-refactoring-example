package com.example.refactoring;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class PriceCalculator {
    public Double calculatePrice(Order order) throws ExecutionException, InterruptedException {
        double itemsCost = order.items().stream().map(this::calculateItemPrice).reduce(0.0, Double::sum);
        //calculateShipping makes an api call and returns a future
        Double shippingCost = calculateShipping(order).get();
        return itemsCost + shippingCost;
    }

    public Double calculatePrice(Order order, Function<List<Item>, CompletableFuture<Double>> shippingCostCalculator)
            throws ExecutionException, InterruptedException {
        double itemsCost = order.items().stream().map(this::calculateItemPrice).reduce(0.0, Double::sum);
        //calculateShipping makes an api call and returns a future
        Double shippingCost = shippingCostCalculator.apply(order.items()).get();
        return itemsCost + shippingCost;
    }

    private CompletableFuture<Double> calculateShipping(Order order) {
        //lets assume that this method takes a lot of time
        Double totalVolume = order.items().stream().map(item -> item.volumeInCubicMeters()).reduce(0.0, Double::sum);
        //lets assume that it costs Rs 1.5 per 20 meter cube
        double shippingCost = new BigDecimal(totalVolume * 1.5 / 20).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return CompletableFuture.completedFuture(shippingCost);
    }

    private double calculateItemPrice(Item item) {
        return item.price();
    }

}
