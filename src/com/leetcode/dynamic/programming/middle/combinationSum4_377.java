package com.leetcode.dynamic.programming.middle;

/**
 * 377. 组合总和 Ⅳ
 * <p>
 * s[0] = 1
 * s[1] = 1 + s[1-1] ==> s[0]个数
 * s[2] = 1 + s[2-1] = 2 + s[2-2] ==> s[1] + s[0] 个数
 * ...
 * <p>
 */
public class combinationSum4_377 {

    public static int combinationSum4(int[] nums, int target) {

        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int j = 0; j < len; j++) {
                if (i < nums[j]) continue;
                int a = i - nums[j];
                dp[i] += dp[a];
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {
        System.out.println("结果：" + combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
