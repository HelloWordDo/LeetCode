package com.leetcode.dynamic.programming;

/**
 * 413. 等差数列划分
 */
public class NumberOfArithmeticSlices_413 {

    public static int numberOfArithmeticSlices(int[] a) {
        if (a.length < 3) return 0;

        int[] count = new int[a.length];
        int total = 0;

        count[0] = -1;
        count[1] = 0;
        int data = a[1] - a[0];
        for (int i = 2; i < a.length; i++) {

            if (a[i] - a[i - 1] != data) {
                if (count[i - 1] > 0)
                    count[i] = -1;

                else {
                    count[i - 1] = -1;
                    count[i] = 0;
                }
                data = a[i] - a[i - 1];
            } else {
                count[i] = count[i - 1] + 1;
            }
            if (count[i] == -1) continue;
            total = total + count[i];
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + numberOfArithmeticSlices(new int[]{1, 1, 2, 5, 7}));
    }
}
