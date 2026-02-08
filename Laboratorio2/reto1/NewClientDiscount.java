package Laboratorio2.reto1;

public class NewClientDiscount implements DiscountStrategy{

private static final double NEW_DISCOUNT_RATE = 0.05;

    @Override
    public double calculateDiscount(double subtotal) {
        return subtotal * NEW_DISCOUNT_RATE;
    }

}
