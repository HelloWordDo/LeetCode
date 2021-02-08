package com.leetcode.dynamic.programming;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct_152 {

    public static int maxProduct(int[] nums) {

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int mx = max[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = max[i - 1];
                max[i - 1] = min[i - 1];
                min[i - 1] = temp;
            }
            max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
            min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            mx = Math.max(mx, max[i]);
        }
        return mx;
    }

    public static void main(String[] args) {

        System.out.println("结果：" + maxProduct(new int[]{2, 3, -2, 4, -1, -10, 0}));
    }
}
