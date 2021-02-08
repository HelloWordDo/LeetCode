package com.leetcode.dynamic.programming.middle;

/**
 * 516. 最长回文子序列
 */
public class LongestPalindromeSubseq_516 {

    public static int longestPalindromeSubseq(String s) {

        int dp[][] = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {

                if (i == j) {
                    dp[i][j] = 1;
                }
                char a = s.charAt(i);
                char b = s.charAt(j);
                if (j - i == 1) {

                    if (a == b) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                if (j - i > 1) {
                    if (a != b) {

                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }


    public static void main(String[] args) {
        System.out.println("结果：" + longestPalindromeSubseq("cbbcaddcbbc"));
    }
}
