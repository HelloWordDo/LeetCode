package com.leetcode.math.middle;

/**
 * 29. 两数相除
 * <p>
 * 举个例子：11 除以 3 。
 * 首先11比3大，结果至少是1，
 * 然后我让3翻倍，就是6，发现11比3翻倍后还要大，那么结果就至少是2了，那我让这个6再翻倍，得12，11不比12大
 * 最小解2也翻倍得到4。
 * 但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数
 * 让11减去刚才最后一次的结果6，剩下5，我们计算5是3的几倍，也就是除法
 * 递归出现了。
 */
public class Divide_29 {

    public static int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            // 只要不是最小的那个整数，都是直接返回相反数就好啦
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            // 是最小的那个，那就返回最大的整数啦
            return Integer.MAX_VALUE;
        }

        int a = dividend;
        int b = divisor;

        if (dividend < 0) {
            a = -a;
        }
        if (divisor < 0) {
            b = -b;
        }

        int res = div(a, b);

        if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return res;
    }

    public static int div(int dividend, int divisor) {

        if (dividend < divisor) {
            return 0;
        }
        int count = 1;
        int a = divisor;
        while (a + a < 0 && dividend >= a + a) {

            count += count;
            a += a;
        }
        return count + div(dividend - a, divisor);
    }


    public static void main(String[] args) {
        System.out.println("结果：" + divide(11, 2));
    }
}
