package Laboratorio2.reto1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void testProductCreation() {
        Product p = new Product("apple", 2.5);

        assertEquals("apple", p.getName());
        assertEquals(2.5, p.getPrice());
    }

    @Test
    void testPriceIsPositive() {
        Product p = new Product("banana", 1.99);

        assertTrue(p.getPrice() > 0);
    }
}
