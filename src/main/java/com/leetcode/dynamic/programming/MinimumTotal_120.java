package com.leetcode.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class MinimumTotal_120 {

    public static int minimumTotal(List<List<Integer>> triangle) {

        int[][] total = new int[triangle.size()][triangle.size()];

        if (triangle.size() == 1) {
            total[0][0] = triangle.get(0).get(0);
            return total[0][0];
        }
        if (triangle.size() == 2) {
            List<Integer> line = triangle.get(1);
            if (line.size() > 1) {
                total[0][0] = Math.min(triangle.get(1).get(0), triangle.get(1).get(1)) + triangle.get(0).get(0);
            } else {
                total[0][0] = triangle.get(1).get(0) + triangle.get(0).get(0);
            }
            return total[0][0];
        }
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> line = triangle.get(i);
            if (i == 0) {
                total[0][0] = Math.min(total[1][0] + line.get(0), total[1][1] + line.get(0));
                return total[0][0];
            }
            List<Integer> beforeLine = triangle.get(i - 1);
            for (int j = 1; j < line.size(); j++) {
                if (i == triangle.size() - 1) {
                    total[i - 1][j - 1] = Math
                            .min(beforeLine.get(j - 1) + line.get(j - 1), beforeLine.get(j - 1) + line.get(j));
                } else {
                    total[i - 1][j - 1] = Math
                            .min(beforeLine.get(j - 1) + total[i][j - 1], beforeLine.get(j - 1) + total[i][j]);
                }
            }
        }
        return total[0][0];
    }


    public static void main(String[] args) {
        List l = new ArrayList();

        List l0 = new ArrayList();
        l0.add(-10);
        List l1 = new ArrayList();
        l1.add(3);
//        l1.add(4);
        List l2 = new ArrayList();
        l2.add(6);
        l2.add(5);
        l2.add(7);
        List l3 = new ArrayList();
        l3.add(4);
        l3.add(1);
        l3.add(8);
        l3.add(3);

        l.add(l0);
        l.add(l1);
//        l.add(l2);
//        l.add(l3);
        System.out.println("结果:" + minimumTotal(l));
    }
}
