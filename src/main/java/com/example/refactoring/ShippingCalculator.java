package com.example.refactoring;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CompletableFuture;

public class ShippingCalculator implements IShippingCalculator {
    @Override
    public CompletableFuture<Double> calculateShipping(Order order) {
        //Returns a new CompletableFuture that is asynchronously completed by a task running in the ForkJoinPool.commonPool()
        //with the value obtained by calling the given Supplier. In a spring boot application, if you annotate the method
        //with @Async, then spring will automatically execute in a thread from its threadpool. In such case, you only
        //need to do return like the last statement. Avoid passing DeferredResult as method parameter.
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (order == null) {
                throw new RuntimeException("Computation error! Order is null");
            }
            Double totalVolume = order.items().stream().map(Item::volumeInCubicMeters).reduce(0.0, Double::sum);
            double shppingCost = new BigDecimal(totalVolume * 1.5 / 20).setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println(shppingCost);
            //lets assume that it costs Rs 1.5 per 20 meter cube
            return shppingCost;
        });
        //calculate shipping cost like above
        //return CompletableFuture.completedFuture(shippingCost);
    }


}
