package com.leetcode.dynamic.programming.middle;

/**
 * 1143. 最长公共子序列
 */
public class LongestCommonSubsequence_1143 {

    public static int longestCommonSubsequence(String text1, String text2) {

        int l1 = text1.length();

        int l2 = text2.length();
        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        int[][] dp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {


            for (int j = 0; j < l2; j++) {

                char a = text1.charAt(i);
                char b = text2.charAt(j);
                if (i == 0) {
                    if (a == b) {
                        dp[0][j] = 1;
                    } else if (j != 0) {
                        dp[0][j] = dp[i][j - 1];
                    }
                    continue;
                }
                if (j == 0) {
                    if (a == b) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }

                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1 - 1][l2 - 1];
    }


    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));
    }
}
