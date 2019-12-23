package com.simple.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlovoDemoTest {

    private int[] test1 = {1, 3, 6, 4, 1, 2}; //5
    private int[] test2 = {1, 2, 3}; //4
    private int[] test3 = {-2,-3,-1,-5,1,5,4}; //2
    private int[] test4 = {-1,-3}; //1
    private int[] test5 = {1, 2, 5, 9, 11, 482, 199}; //3
    private int[] test6 = {-3}; //1
    private int[] test7 = {0}; //1
    private int[] test8 = {9}; //1
    private int[] test9 = {1}; //2
    private int[] test10 = {3, 5, 9, 11, 482, 199}; //1
    private int[] test11 = {-1000000, 1000000}; //1

    class Solution {

        public int solution(int[] A) {
            Arrays.sort(A);

            int i = 0;
            int j = 0;
            int smallest_positive = 1;
            boolean contains_one = false;
            boolean found = false;

            for (i = 0; i < A.length; i++) {
                if (A[i] < 1) {
                    continue;
                } else {
                    for (j = i; j < A.length-1; j++) {
                        if (A[j] == 1) {
                            contains_one = true;
                        }
                        if (A[j+1] - A[j] > 1) {
                            smallest_positive = A[j] + 1;
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }
            if (!found) {
                if (A.length > 1 && contains_one) {
                    smallest_positive = A[j] + 1;
                } else if (A[0] == 1) {
                    smallest_positive = 2;
                }
            } else if (!contains_one) {
                smallest_positive = 1;
            }
            return smallest_positive;
        }

    }

    @Test
    public void runDemoSolutionTest() {
        Solution solution = new Solution();
        assertEquals(0, 0);
        assertEquals(5, solution.solution(test1));
        assertEquals(4, solution.solution(test2));
        assertEquals(2, solution.solution(test3));
        assertEquals(1, solution.solution(test4));
        assertEquals(3, solution.solution(test5));
        assertEquals(1, solution.solution(test6));
        assertEquals(1, solution.solution(test7));
        assertEquals(1, solution.solution(test8));
        assertEquals(2, solution.solution(test9));
        assertEquals(1, solution.solution(test10));
        assertEquals(1, solution.solution(test11));
    }

}
