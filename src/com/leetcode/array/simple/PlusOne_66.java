package com.leetcode.array.simple;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne_66 {

    public int[] plusOne(int[] digits) {

        int add;
        int n = digits[digits.length - 1];

        if (n + 1 >= 10) {
            digits[digits.length - 1] = n + 1 - 10;
            add = 1;
        } else {
            digits[digits.length - 1] = n + 1;
            add = 0;
        }

        for (int i = digits.length - 2; i >= 0; i--) {

            int num = digits[i];

            if (num + add >= 10) {
                digits[i] = num + add - 10;
                add = 1;
            } else {
                digits[i] = num + add;
                add = 0;
            }
        }
        if (add == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {

        PlusOne_66 method = new PlusOne_66();
        int[] i = method.plusOne(new int[]{9, 9});
        System.out.println(i);
    }
}
