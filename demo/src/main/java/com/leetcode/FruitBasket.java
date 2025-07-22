package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class FruitBasket {
    /* Iterate through the array. Keep track of the last index of fruits of each kind.
     * If a new fruit type is encountered we need to adjust the current length to a
     * location beyond which only the fruits of one type are left.
     * We can keep checking the total trees to account for the maximum trees covered.
     */
    public int totalFruit(int[] fruits) {
	Map<Integer, Integer> lastPositionMap = new HashMap<>();
	int start = 0, end = 0;
	int maxLength = 0, currLength = 0;
	while(end < fruits.length) {
	    if (lastPositionMap.size() == 2 && !lastPositionMap.containsKey(fruits[end])) {
	        int previousFruit = fruits[end - 1];
		int lastDeletionIndex = -1;
		int deletionFruit = -1;
		for (int fruit: lastPositionMap.keySet()) {
		    if (fruit != previousFruit) {
			lastDeletionIndex = lastPositionMap.get(fruit);
			deletionFruit = fruit;
		    }
		}
            lastPositionMap.remove(deletionFruit);
		currLength = end - lastDeletionIndex - 1;
	    }
	    lastPositionMap.put(fruits[end], end);
	    currLength++;
	    maxLength = Math.max(maxLength, currLength);
	    end++;
	}
	return maxLength;
    }
}
