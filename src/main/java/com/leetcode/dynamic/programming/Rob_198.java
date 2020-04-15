package com.leetcode.dynamic.programming;

/**
 * 198. 打家劫舍
 */
public class Rob_198 {

    public static int rob(int[] nums) {

        int maxRob = 0;
        int[] r = new int[nums.length];
        if (nums.length > 0) {
            r[0] = nums[0];
            maxRob = r[0];
        }
        if (nums.length > 1) {
            r[1] = Math.max(nums[0], nums[1]);
            maxRob = r[1];
            for (int i = 2; i < nums.length; i++) {
                r[i] = Math.max(r[i - 2] + nums[i], r[i - 1]);
                maxRob = Math.max(r[i], r[i - 1]);
            }
        }
        return maxRob;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + rob(new int[]{1, 3, 1, 3, 100}));
    }
}
