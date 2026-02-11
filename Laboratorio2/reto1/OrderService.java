package Laboratorio2.reto1;

public class OrderService {

    private final DiscountStrategy discountStrategy;

    public OrderService (DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(Cart cart) {
        double subtotal = cart.calculateSubtotal();
        return subtotal - discountStrategy.calculateDiscount(subtotal);
    }
}




