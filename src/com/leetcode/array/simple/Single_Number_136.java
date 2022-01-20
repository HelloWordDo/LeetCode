package com.leetcode.array.simple;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Single_Number_136 {

    public int singleNumber(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i + 1 == nums.length) {
                return nums[i];
            }
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                return nums[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Single_Number_136 method = new Single_Number_136();

        System.out.println(method.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(method.singleNumber(new int[]{2, 2, 1}));
    }
}
