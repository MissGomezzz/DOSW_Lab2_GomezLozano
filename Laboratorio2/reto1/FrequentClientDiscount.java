package Laboratorio2.reto1;

public class FrequentClientDiscount implements DiscountStrategy{

private static final double FREQUENT_DISCOUNT_RATE = 0.10;


    @Override
    public double calculateDiscount(double subtotal) {
        return subtotal * FREQUENT_DISCOUNT_RATE;
    }

}
