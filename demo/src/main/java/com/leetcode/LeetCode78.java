package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> finalResult;

    public List<List<Integer>> subsets(int[] nums) {
        finalResult = new ArrayList<>();
        backTrack(new ArrayList<>(), nums, 0);
        return finalResult;
    }

    private void backTrack(List<Integer> currentList, int[] nums, int i) {
        if (i == nums.length) {
            finalResult.add(new ArrayList<>(currentList));
            return;
        }
        // including the element
        currentList.add(nums[i]);
        backTrack(currentList, nums, i+1);
        currentList.remove(currentList.size() - 1);
        backTrack(currentList, nums, i+1);
    }
}
