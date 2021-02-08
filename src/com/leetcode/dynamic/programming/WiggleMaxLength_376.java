package com.leetcode.dynamic.programming;

/**
 * 376. 摆动序列
 */
public class WiggleMaxLength_376 {

    public static int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int[] dp = new int[nums.length];

        int a = 0;
        if (nums.length > 1) {
            dp[0] = 1;
            if (nums[1] == nums[0])
                dp[1] = 1;
            else {
                dp[1] = 2;
                a = nums[1] - nums[0] > 0 ? 1 : -1;
            }
        }
        for (int i = 2; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
                continue;
            }

            int b = nums[i] - nums[i - 1] > 0 ? 1 : -1;
            if (a == 0)
                a = -b;

            if (b == -1 * a) {
                dp[i] = dp[i - 1] + 1;
                a *= -1;
            } else
                dp[i] = dp[i - 1];
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + wiggleMaxLength(new int[]{0, 0, 3, 0, 0}));
    }
}
