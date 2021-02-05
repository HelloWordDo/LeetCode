package com.leetcode.linked.list.simple;

/**
 * 26.删除排序数组中的重复项
 */
public class RemoveDuplicates_26 {

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 1;

        int i = 0;
        int j = 1;
        while (i < nums.length - 1) {

            if (j >= nums.length) {
                break;
            }

            if (nums[i] == nums[j]) {
                j++;
                continue;
            }

            i = j;
            nums[index] = nums[j];
            index++;
            j++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0}));
    }
}
