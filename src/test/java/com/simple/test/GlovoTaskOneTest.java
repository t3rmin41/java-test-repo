package com.simple.test;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlovoTaskOneTest {

    private int N1 = 5;
    private int K1 = 3; //10

    private int N2 = 3;
    private int K2 = 5; //-1

    private int N3 = -2147483648;
    private int K3 = 2_147_483_647;

    private int N4 = 40;
    private int K4 = 20; //-1

    private int N5 = 0;
    private int K5 = 0; //1

    class Solution {
        public int solution(int N, int K) {
            BigInteger binomialCoeff = BigInteger.valueOf(-1);
            long difference = N - K;
            BigInteger numerator = BigInteger.valueOf(1);
            BigInteger denominator = BigInteger.valueOf(1);

            if (difference < 0 || N < 0 || K < 0) {
                return binomialCoeff.intValue();
            } else {
                for (int i = 2; i <= difference; i++) {
                    denominator = denominator.multiply(BigInteger.valueOf(i));
                }
                for (int j = N; j > K; j--) {
                    numerator = numerator.multiply(BigInteger.valueOf(j));
                }
                binomialCoeff = numerator.divide(denominator);
            }
            if (binomialCoeff.compareTo(BigInteger.valueOf(1_000_000_000)) > 0) {
                return -1;
            }
            return binomialCoeff.intValue();
        }
    }

    @Test
    public void runGlovoTaskOneTest() {
        Solution solution = new Solution();
        assertEquals(10, solution.solution(N1, K1));
        assertEquals(-1, solution.solution(N2, K2));
        //assertEquals(10, solution.solution(N3, K3));
        assertEquals(-1, solution.solution(N4, K4));
        assertEquals(1, solution.solution(N5, K5));
    }

/*    @Test
    public void runContinueBreakSample() {
        System.out.println("Running task 1");
        System.out.println("break inside loop if");
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }

        System.out.println("Continue inside loop");
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
    }*/

}
