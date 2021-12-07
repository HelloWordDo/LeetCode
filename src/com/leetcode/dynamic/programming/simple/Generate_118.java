package com.leetcode.dynamic.programming.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 */
public class Generate_118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> list2 = res.get(i - 1);
                    list.add(list2.get(j - 1) + list2.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {

        Generate_118 method = new Generate_118();
        System.out.println(method.generate(5));
    }
}
