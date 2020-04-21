package com.leetcode.dynamic.programming;

/**
 * 5.最长公共子回文串
 *
 */
public class longestPalindrome_5 {

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {

                char a = s.charAt(i);
                char b = s.charAt(j);

                dp[i][j] = a == b && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + longestPalindrome("aaaa"));
    }
}
