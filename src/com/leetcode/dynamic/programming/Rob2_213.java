package com.leetcode.dynamic.programming;

/**
 * 213. 打家劫舍 II
 */
public class Rob2_213 {

    public static int rob(int[] nums) {

        if (nums.length == 0) return 0;
        int[] r1 = new int[nums.length];
        int[] r2 = new int[nums.length];
        r1[0] = nums[0];
        int max1 = r1[0];
        int max2 = 0;
        if (nums.length > 1) {
            max1 = r1[1] = Math.max(r1[0], r1[1]);
            max2 = r2[1] = nums[1];
        }
        for (int i = 2; i < nums.length - 1; i++) {
            r1[i] = Math.max(r1[i - 2] + nums[i], r1[i - 1]);
            max1 = Math.max(max1, r1[i]);
        }
        for (int i = 2; i < nums.length; i++) {
            r2[i] = Math.max(r2[i - 2] + nums[i], r2[i - 1]);
            max2 = Math.max(max2, r2[i]);
        }
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        System.out.println("结果：" + rob(new int[]{4, 1, 2, 7, 5, 3, 1}));
    }
}
