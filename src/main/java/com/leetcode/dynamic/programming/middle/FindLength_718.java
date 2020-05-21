package com.leetcode.dynamic.programming.middle;

/**
 * 718. 最长重复子数组
 */
public class FindLength_718 {

    public static int findLength(int[] A, int[] B) {

        int max = 0;
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < B.length; j++) {

                int a = A[i];
                int b = B[j];

                if (a == b) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println("结果：" + findLength(new int[]{1, 2, 3, 2, 1}, new int[]{4, 2, 2, 4, 7}));
    }
}
