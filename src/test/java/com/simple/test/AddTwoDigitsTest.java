package com.simple.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoDigitsTest {


    private int addTwoDigits(int n) {
        //Given a two-digit integer n, return the sum of its digits
        return n / 10 + n % 10;
    }

    @Test
    public void testAddTwoDigits() {
        int n = 29; // 2 + 9 = 11
        assertEquals(11, addTwoDigits(n));
    }

}
