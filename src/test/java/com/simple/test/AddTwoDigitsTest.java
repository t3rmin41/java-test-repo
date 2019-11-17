package com.simple.test;

import org.junit.jupiter.api.Test;

public class AddTwoDigitsTest {

    private int addTwoDigits(int n) {
        return n / 10 + n % 10;
    }

    @Test
    public void testAddTwoDigits() {
        int n = 29;
        addTwoDigits(n);
    }

}
