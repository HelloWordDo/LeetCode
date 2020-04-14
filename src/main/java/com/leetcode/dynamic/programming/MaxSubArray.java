package com.leetcode.dynamic.programming;

/**
 * 53.最大子序和
 */
public class MaxSubArray {


    public static int maxSubArray(int[] nums) {

        int maxCount = nums[0];

        int[] f = new int[nums.length];

        f[0] = maxCount;
        for (int i = 1; i < nums.length; i++) {

            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);

            maxCount = Math.max(maxCount, f[i]);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
