package com.leetcode.array.simple;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {

        int i = 0, j = 1;

        while (j < nums.length) {

            if (nums[i] != 0) {
                i++;
                j++;
                continue;
            } else {
                if (nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                j++;
            }
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {

        MoveZeroes_283 method = new MoveZeroes_283();

        method.moveZeroes(new int[]{0, 0, 3, 12, 0});
    }
}
