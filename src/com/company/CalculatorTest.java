package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void testAdder() {
        Calculator adder = new Adder();
        int sum = adder.calculate(2, 3);
        assertEquals(5, sum);
    }

    @Test
    public void testMultiplier() {
        Calculator multiplier = new Multiplier();
        int product = multiplier.calculate(2, 3);
        assertEquals(6, product);
    }

    @Test
    @DisplayName("test Divider")
    public void testDivider() {
        Calculator divider = new Divider();
        assertAll(
                () -> assertEquals(2, divider.calculate(4, 2)),
                () -> assertDoesNotThrow(() -> divider.calculate(2, 0))
                );
    }
}
