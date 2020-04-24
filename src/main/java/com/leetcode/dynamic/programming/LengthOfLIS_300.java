package com.leetcode.dynamic.programming;

/**
 * 300. 最长上升子序列
 */
public class LengthOfLIS_300 {

    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int max = nums.length == 0 ? 0 : 1;

        for (int i = 1; i < nums.length; i++) {
            dp[0] = 1;
            int rangMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(rangMax, dp[j]) + 1;
                    max = Math.max(dp[i], max);
                    rangMax = dp[j];
                } else if (dp[i] < 1) {
                    dp[i] = 1;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println("结果：" + lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
