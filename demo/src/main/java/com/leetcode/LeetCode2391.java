package com.leetcode;

public class LeetCode2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[][] stat = new int[3][2];
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                switch (garbage[i].charAt(j)) {
                    case 'M':
                        stat[0][0] = i;
                        stat[0][1]++;
                        break;
                    case 'G':
                        stat[1][0] = i;
                        stat[1][1]++;
                        break;
                    case 'P':
                        stat[2][0] = i;
                        stat[2][1]++;
                        break;
                }
            }
        }
        int totalTime = stat[0][1] + stat[1][1] + stat[2][1];
        for (int i = 0; i < travel.length; i++) {
            if (stat[0][0] >= i + 1) {
                totalTime += travel[i];
            }
            if (stat[1][0] >= i + 1) {
                totalTime += travel[i];
            }
            if (stat[2][0] >= i + 1) {
                totalTime += travel[i];
            }
        }
        return totalTime;
    }
}
