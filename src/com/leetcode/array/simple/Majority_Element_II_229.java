package com.leetcode.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. 多数元素 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class Majority_Element_II_229 {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> x = new ArrayList();
        int len = nums.length / 3;

        int c1 = 0, x1 = 0;
        int c2 = 0, x2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (x1 == nums[i]) {
                c1++;
            } else if (x2 == nums[i]) {
                c2++;
            } else if (c1 == 0) {
                c1 = 1;
                x1 = nums[i];
                continue;
            } else if (c2 == 0) {
                c2 = 1;
                x2 = nums[i];
            } else {
                c1--;
                c2--;
            }
        }


        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == x1) {
                count1++;
            } else if (nums[i] == x2) {
                count2++;
            }

        }

        if (count1 > len) {
            x.add(x1);
        }
        if (count2 > len) {
            x.add(x2);
        }
        System.out.println(c1 + " " + x1);
        System.out.println(c2 + " " + x2);
        System.out.println(x);
        return x;
    }


    public static void main(String[] args) {

        Majority_Element_II_229 method = new Majority_Element_II_229();
//        method.majorityElement(new int[]{1, 2, 3, 1, 1, 2, 3});
        method.majorityElement(new int[]{3, 2, 2, 2, 3});
//        method.majorityElement(new int[]{1});
//        method.majorityElement(new int[]{1, 2});
//        method.majorityElement(new int[]{0, 0, 0});
//        method.majorityElement(new int[]{2, 1, 1, 3, 1, 4, 5, 6});
    }

}
