package com.leetcode.dynamic.programming.middle;

/**
 * 740. 删除与获得点数
 */
public class DeleteAndEarn_740 {

    public static int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[10001];
        int[] all = new int[10001];
        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            all[value] += 1;
        }

        for (int i = 0; i < all.length; i++) {

            if (i == 0) {
                continue;
            }
            if (i == 1) {
                dp[i] = all[i];
                continue;
            }

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[all.length - 1];
    }


    public static void main(String[] args) {

        System.out.println(deleteAndEarn(new int[]{3, 7, 10, 5, 2, 4, 8, 9, 9, 4}));
    }
}
