package com.leetcode.array.hard;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class Largest_Rectangle_In_Histogram_84 {

    public int largestRectangleArea2(int[] heights) {

        int res = 0;
        for (int i = 0; i < heights.length; i++) {

            int height = heights[i];

            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && heights[left] >= height) {
                left--;
            }
            while (right < heights.length && heights[right] >= height) {
                right++;
            }

            int region = height * (right - 1 - left);
            res = Math.max(region, res);
        }

        return res;
    }


    public int largestRectangleArea(int[] heights) {

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }


    public static void main(String[] args) {

        Largest_Rectangle_In_Histogram_84 method = new Largest_Rectangle_In_Histogram_84();
//        System.out.println(method.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(method.largestRectangleArea(new int[]{5, 2, 2, 2}));
    }
}
