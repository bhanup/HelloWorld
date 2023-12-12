package com.leetcode;

public class LeetCode5M {

    private String palindrome = "";
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        maxLength = 1;
        palindrome = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            int length = 1 + longestPalindromeAtIndex(s, i-1, i+1);
            if (length > maxLength) {
                maxLength = length;
                palindrome = s.substring(i- (length / 2), i+1+(length/2));
            }
            length = longestPalindromeAtIndex(s, i, i+1);
            if (length > maxLength) {
                maxLength = length;
                palindrome = s.substring(i+1-(length/2), i+(length/2)+1);
            }
            length = longestPalindromeAtIndex(s, i-1, i);
            if (length > maxLength) {
                maxLength = length;
                palindrome = s.substring(i-(length/2), i+length/2);
            }
        }
        return palindrome;
    }

    private int longestPalindromeAtIndex(String s, int start, int end) {
        int length = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                length += 2;
            } else {
                break;
            }
            start--;
            end++;
        }
        return length;
    }

}
