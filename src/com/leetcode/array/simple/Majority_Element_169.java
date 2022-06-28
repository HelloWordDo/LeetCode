package com.leetcode.array.simple;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Majority_Element_169 {

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int count = 0, x = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                count = 1;
                x = nums[i];
                continue;
            }

            if (nums[i] != x) {
                --count;
            } else {
                ++count;
            }
        }
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) {

        Majority_Element_169 method = new Majority_Element_169();
        method.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        method.majorityElement(new int[]{7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7});
    }
}
