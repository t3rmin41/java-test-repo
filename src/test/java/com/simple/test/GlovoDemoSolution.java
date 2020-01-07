package com.simple.test;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GlovoDemoSolution {

    // you can also use imports, for example:
// import java.util.*;


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    private int[] test1 = {1,3,6,4,1,2};
    private int[] test2 = {-1,-2,0,1,3};
    private int[] test3 = {-5,-3,-1,-2,1,0,5,4};
    private int[] test4 = {1,2,3};
    private int[] test5 = {-1,-2,-3};
    private int[] test6 = {-5,-3,-1,-2,1,0,5,4,6,9};

    public class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            Arrays.sort(A);
            int smallest_positive = 1;
            boolean found = false;
            int i = 0;
            int j = 0;
            System.out.print("Sorted array : [");
            for (int e : A) {
                System.out.print("," + e);
            }
            System.out.println("]");

            for (i = 0; i < A.length; i++) {
                if (A[i] < 1) {
                    continue;
                } else {
                    for (j = i; j < A.length-1; j++) {
                        if (A[j+1] - A[j] > 1 && !found) {
                            smallest_positive = A[j] + 1;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        smallest_positive = A[j]+1;
                    }
                    break;
                }
            }
            System.out.println("i = " + i + " j = " +j);
            return smallest_positive;
        }
    }

    @Test
    public void testGlovoDemoSolution() {
        Solution solution = new Solution();
        //System.out.println("test1 : " + solution.solution(test1));
        //System.out.println("test2 : " + solution.solution(test2));
        //System.out.println("test3 : " + solution.solution(test3));
        //System.out.println("test4 : " + solution.solution(test4));
        //System.out.println("test5 : " + solution.solution(test5));
        System.out.println("test6 : " + solution.solution(test6));
    }

}
