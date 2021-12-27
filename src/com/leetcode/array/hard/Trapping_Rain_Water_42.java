package com.leetcode.array.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class Trapping_Rain_Water_42 {

    int res = 0;

    public int trap(int[] height) {

        if (height.length == 0 || height.length == 1) {
            return res;
        }

        int i = 0;

        List<Integer> split = new ArrayList<>();

        while (i < height.length) {

            if (i == 0) {
                if (height[i] > height[i + 1]) {
                    split.add(i);
                }
            } else {
                if (height[i - 1] <= height[i]) {
                    if (i + 1 == height.length || height[i] >= height[i + 1]) {

                        split.add(i);
                        int size = split.size();

                        while (size >= 3) {
                            if (height[split.get(size - 2)] <= height[split.get(size - 3)] &&
                                    height[split.get(size - 2)] <= height[split.get(size - 1)]) {
                                split.remove(size - 2);
                            }
                            size--;
                        }
                    }
                }
            }
            i++;
        }

        System.out.println(split);
        for (int j = 0; j < split.size() - 1; j++) {
            getRegion(split.get(j), split.get(j + 1), height);
        }

        return res;
    }

    void getRegion(int start, int end, int[] height) {

        int min = Math.min(height[start], height[end]);

        int range_1 = start;
        int range_2 = end;
        for (int i = start + 1; i < end; i++) {

            if (height[i] > height[end]) {
                range_1 = i;
            }
        }

        for (int i = end - 1; i > start; i--) {

            if (height[i] > height[start]) {
                range_2 = i;
            }
        }

        int maxArea = (range_2 - range_1 - 1) * min;

        for (int i = range_1 + 1; i < range_2; i++) {

            maxArea -= height[i];
        }
        res += maxArea;
    }

    public static void main(String[] args) {

        Trapping_Rain_Water_42 method = new Trapping_Rain_Water_42();
//        System.out.println(method.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(method.trap(new int[]{4, 2, 0, 3, 2, 5}));
//        System.out.println(method.trap(new int[]{5, 4, 1, 2}));
        System.out.println(method.trap(new int[]{8, 8, 1, 5, 6, 2, 5, 3, 3, 9}));

    }
}
