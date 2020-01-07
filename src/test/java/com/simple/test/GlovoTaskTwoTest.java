package com.simple.test;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlovoTaskTwoTest {

    private int [][] test1 = {{5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}}; //11
    private int [][] test2 = {{1,2,2},{3,2,5},{4,6,8}}; //7
    private int [][] test3 = {{1,2,3,3},{3,2,4,5},{6,7,8,8}}; //9
    private int [][] test4 = {{1,2,2},{3,2,5},{4,6,8}}; //7
    private int [][] testRealWorld1 = {{1,2,2},{3,2,4},{5,6,7}}; //7

    class Solution {
        public int realWorldSolution(int[][] A) {

            //Map<Integer, Set<AbstractMap.SimpleEntry<Integer, Integer>>> countryMap = new HashMap<>();
            Map<AbstractMap.SimpleEntry<Integer, Integer>, Set<AbstractMap.SimpleEntry<Integer, Integer>>> countryMap = new HashMap<>();

            int currentCountryColor = 0;
            int nextId = 1; // next ID of country as color codes may duplicate

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    currentCountryColor = A[i][j];
                    //countryMap.putIfAbsent(currentCountryColor, new HashSet<>());
                    countryMap.putIfAbsent(new AbstractMap.SimpleEntry<>(nextId, currentCountryColor), new HashSet<>());
                    int n = j;
                    while (n < A[i].length) {
                        int m = i;
                        while (m < A.length) {
                            if (currentCountryColor == A[m][n]) {
                                //countryMap.get(currentCountryColor).add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
                                countryMap.get(new AbstractMap.SimpleEntry<>(nextId, currentCountryColor)).add(new AbstractMap.SimpleEntry<>(i, j));
                            }
                            m++;
                        }
                        n++;
                    }
                    nextId++; //here?
                }
            }
            return countryMap.values().size();
        }

        public int solution(int[][] A) {
            int currentCountryColor = 0;
            int countryCount = 1;

            for (int i = 0; i < A[0].length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    currentCountryColor = A[i][j];
                    int n = j;
                    while (n < A[i].length) {
                        if (currentCountryColor != A[j][n]) {
                            countryCount = countryCount + 1;
                        }
                        n++;
                    }
                }
            }
            return countryCount;
        }
    }

    @Test
    public void runGlovoTaskTwoTest() {
        Solution solution = new Solution();
        //assertEquals(11, solution.solution(test1));
        //assertEquals(7, solution.solution(test2));
        //assertEquals(9, solution.solution(test3));
        //assertEquals(7, solution.solution(test4));
        //assertEquals(7, solution.solution(testRealWorld1));
        //assertEquals(7, solution.realWorldSolution(testRealWorld1));
        assertEquals(11, solution.realWorldSolution(test1));
    }

}
