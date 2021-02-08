package com.leetcode.dynamic.programming;

/**
 * 46. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs_746 {

    public static int minCostClimbingStairs(int[] cost) {

        int[] m = new int[cost.length + 1];
        m[0] = m[1] = 0;

        for (int i = 2; i <= cost.length; i++) {

            m[i] = Math.min(m[i - 1] + cost[i - 1], m[i - 2] + cost[i - 2]);
            System.out.println(i + "->>>>" + m[i]);
        }

        return m[cost.length];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + minCostClimbingStairs(new int[]{10, 15, 20}));
    }

}
