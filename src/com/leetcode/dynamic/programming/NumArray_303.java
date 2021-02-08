package com.leetcode.dynamic.programming;

/**
 * 303. 区域和检索 - 数组不可变
 */
public class NumArray_303 {

    int[] sum;

    public NumArray_303(int[] nums) {

        sum = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        if (nums.length > 0) {
            sum[0] = nums[0];
        } else {
            sum[0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {

        int total;
        if (i == 0) {
            total = sum[j];
        } else {
            total = sum[j] - sum[i - 1];
        }
        return total;
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    public static void main(String[] args) {
        NumArray_303 obj = new NumArray_303(new int[]{-2, 0, 3, -5, 2, -1});
        int total = obj.sumRange(5, 5);
        System.out.println("结果：" + total);
    }
}
