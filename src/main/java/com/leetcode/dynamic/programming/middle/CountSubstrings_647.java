package com.leetcode.dynamic.programming.middle;

/**
 * 647. 回文子串
 */
public class CountSubstrings_647 {

    public static int countSubstrings(String s) {

        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {

            for (int j = i; j < s.length(); j++) {

                if (i == j) {
                    count++;
                    dp[i][j] = true;
                }
                char a = s.charAt(i);
                char b = s.charAt(j);

                if (j - i == 1 && a == b) {
                    count++;
                    dp[i][j] = true;
                }
                if (j - i > 1 && a == b && dp[i + 1][j - 1]) {
                    count++;
                    dp[i][j] = true;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println("结果：" + countSubstrings("aaa"));
    }
}
