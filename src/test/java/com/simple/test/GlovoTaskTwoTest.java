package com.simple.test;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlovoTaskTwoTest {

    private int [][] test1 = {{5,4,4},{4,3,4},{3,2,4},{2,2,2},{3,3,4},{1,4,4},{4,1,1}}; //11
    private int [][] test2 = {{1,2,2},{3,2,5},{4,6,8}}; //7
    private int [][] test3 = {{1,2,3,3},{3,2,4,5},{6,7,8,8}}; //9
    private int [][] test4 = {{1,2,2},{3,2,5},{4,6,8}}; //7
    private int [][] testRealWorld1 = {{1,2,2},{3,2,4},{5,6,7}}; //7
    private int [][] test5 = {{1,2,2},{3,2,1},{4,3,2}}; //7

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
            int countryCount = 0;

            for (int i = 0; i < A[0].length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    currentCountryColor = A[i][j];
                    int n = j;
                    while (n < A[i].length) {
                        while (n < A[i].length)
                        if (currentCountryColor != A[j][n]) {
                            countryCount = countryCount + 1;
                        }
                        n++;
                    }
                }
            }
            return countryCount;
        }

        public int testSolution(int[][] A) {
            int currentCountryColor = 0;
            int countryCount = 0;

            boolean[][] visitedMap = new boolean[A.length][A[0].length];

            boolean loopInterrupted = true;
            int i = 0;
            while (i < A.length) {
                if (!loopInterrupted) {
                    countryCount++;
                }
                int j = 0;
                currentCountryColor = A[i][j];
                List<Integer> sameColorAdjacentColumns = new ArrayList<>();
                loopInterrupted = false;

                while (j < A[i].length) {
                    //currentCountryColor = A[i][j];
                    if (currentCountryColor == A[i][j] && !visitedMap[i][j]) {
                        visitedMap[i][j] = true;
                        sameColorAdjacentColumns.add(j);
                    } else if (currentCountryColor == A[i][j] && visitedMap[i][j]) {
                        j++;
                        currentCountryColor = A[i][j];
                        continue;
                    } else if (currentCountryColor != A[i][j] && !visitedMap[i][j]) {
                        countryCount++;
                        loopInterrupted = true;
                        i--;
                        break;
                    }
                    j++;
                }
                for (Integer column : sameColorAdjacentColumns) {
                    int n = 0;
                    int m = 0;
                    if (loopInterrupted) {
                        n = i+1;
                        m = i+1;
                    } else {
                        n = i;
                        m = i;
                    }
                    while (n < A[m].length) {
                        if (currentCountryColor == A[n][column]) {
                            visitedMap[n][column] = true;
                        } else {
                            break;
                        }
                        n++;
                    }
                }
                i++;
            }
/*
            for (int i = 0; i < A.length; i++) {



                for (int j = 0; j < A[i].length; j++) {
                    currentCountryColor = A[i][j];
                    List<Integer> sameColorAdjacentColumns = new ArrayList<>();
                    int n = j;
                    boolean interruptedLoop = false;
                    while (n < A[i].length) {
                        if (currentCountryColor == A[i][n] && !visitedMap[i][n]) {
                            visitedMap[n][j] = true;
                            sameColorAdjacentColumns.add(n);
                        } else {
                            interruptedLoop = true;
                            countryCount = countryCount + 1; // if loop is always interrupted - OK, but what to do when loop finishes normally because of reaching array length?
                            break;
                        }
                        n++;
                    }
                    if (!interruptedLoop) {
                        countryCount = countryCount + 1;
                    }
                    int m = i;
                    for (Integer column : sameColorAdjacentColumns) {
                        while (m < A[i].length) {
                            if (currentCountryColor == A[m][column]) {
                                visitedMap[i][column] = true;
                            } else {
                                break;
                            }
                            m++;
                        }
                    }
                }
            }*/
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
        //assertEquals(11, solution.realWorldSolution(test1));
        assertEquals(7, solution.testSolution(test5));
    }

}
