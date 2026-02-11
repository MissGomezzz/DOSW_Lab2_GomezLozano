package Laboratorio2.reto1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {

    private Cart cart;
    private Product apple;
    private Product milk;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        apple = new Product("apple", 2.0);
        milk = new Product("milk", 3.5);
    }

    @Test
    void testAddProduct() {
        cart.addProduct(apple, 3);

        assertEquals(6.0, cart.getTotal());
    }

    @Test
    void testAddMultipleProducts() {
        cart.addProduct(apple, 2);
        cart.addProduct(milk, 1);

        assertEquals(7.5, cart.getTotal());
    }

    @Test
    void testClearCart() {
        cart.addProduct(apple, 5);
        cart.clear();

        assertEquals(0.0, cart.getTotal());
    }
}
