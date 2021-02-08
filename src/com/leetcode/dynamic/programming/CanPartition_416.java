package com.leetcode.dynamic.programming;

/**
 * 416. 分割等和子集
 */
public class CanPartition_416 {

    public static boolean canPartition(int[] nums) {

        if (nums.length == 0) return false;

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) return false;

        int half = total / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];

        if (nums[0] <= half) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= half; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][half];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + canPartition(new int[]{1, 2, 3}));
    }

}
