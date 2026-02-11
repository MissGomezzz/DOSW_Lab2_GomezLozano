package Laboratorio2.reto1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class InputUtilsTest {

    @Test
    void testValidQuantity() {
        assertTrue(InputUtils.isValidQuantity(3));
    }

    @Test
    void testInvalidQuantity() {
        assertFalse(InputUtils.isValidQuantity(0));
        assertFalse(InputUtils.isValidQuantity(-2));
    }
}

