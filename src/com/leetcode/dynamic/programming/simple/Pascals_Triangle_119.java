package com.leetcode.dynamic.programming.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= rowIndex <= 33
 */
public class Pascals_Triangle_119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    list2.add(1);
                } else {
                    list2.add(list1.get(j - 1) + list1.get(j));
                }
            }

            list1 = list2;
            list2 = new ArrayList<>();
        }
        return list1;
    }

    public static void main(String[] args) {

        Pascals_Triangle_119 method = new Pascals_Triangle_119();
        System.out.println(method.getRow(3));
    }
}
