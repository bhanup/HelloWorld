package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Intuitively i'm going to use the general maths addition.
 * Which is reverse the array. Add the integer k to the unit
 * place digit. Do a mod 10 to get the number and divide by 10
 * to get the carry. keep on continuing till you reach the end
 * of the array.
 *
 * This works for all the integers not just single digit k value.
 */
public class LeetCode989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> reverseNumber = new ArrayList<>();
        int carry = k;
        num = reverseTheNumber(num);
        for (int i = 0; i < num.length; i++) {
            int sum = num[i] + carry;
            reverseNumber.add(sum % 10);
            carry = sum / 10;
        }
        while (carry != 0) {
            reverseNumber.add(carry % 10);
            carry = carry / 10;
        }
        Collections.reverse(reverseNumber);
        return reverseNumber;
    }

    private int[] reverseTheNumber(int[] number) {
        int start = 0;
        int end = number.length - 1;
        while (start < end) {
            int temp = number[end];
            number[end] = number[start];
            number[start] = temp;
            start++;
            end--;
        }
        return number;
    }
}
