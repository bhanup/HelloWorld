package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> result = new ArrayList<>();
        int firstPointer = 0, secondPointer = 0;
        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int[][] earlierList, laterList;
            int earlierPointer, laterPointer;
            if (firstList[firstPointer][0] <= secondList[secondPointer][0]) {
                earlierList = firstList;
                laterList = secondList;
                earlierPointer = firstPointer;
                laterPointer = secondPointer;
            } else {
                earlierList = secondList;
                laterList = firstList;
                earlierPointer = secondPointer;
                laterPointer = firstPointer;
            }
            if (laterList[laterPointer][0] <= earlierList[earlierPointer][1]) {
                // intersection
                List<Integer> intersectionPart = new ArrayList<>();
                intersectionPart.add(laterList[laterPointer][0]);
                if (laterList[laterPointer][1] < earlierList[earlierPointer][1]) {
                    intersectionPart.add(laterList[laterPointer][1]);
                    laterPointer++;
                } else if (earlierList[earlierPointer][1] < laterList[laterPointer][1]) {
                    intersectionPart.add(earlierList[earlierPointer][1]);
                    earlierPointer++;
                } else {
                    intersectionPart.add(earlierList[earlierPointer][1]);
                    earlierPointer++;
                    laterPointer++;
                }
                result.add(intersectionPart);
            } else {
                earlierPointer++;
            }
            if (firstList[firstPointer][0] <= secondList[secondPointer][0]) {
                firstPointer = earlierPointer;
                secondPointer = laterPointer;
            } else {
                secondPointer = earlierPointer;
                firstPointer = laterPointer;
            }
        }
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i][0] = result.get(i).get(0);
            finalResult[i][1] = result.get(i).get(1);
        }
        return finalResult;
    }
}
