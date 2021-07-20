package com.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个人进了一个房间，房间有一排椅子，椅子上有一些人坐着，还剩一些空位，他要选择一个位子坐下，这个位子要尽可能远离已经坐着的人，
 * 请给出算法。请自行定义数据结构和输入输出。
 */
public class Sitdown {

    public int sitdown(int[] chairs) {

        List<Integer> full = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        for (int i = 0; i < chairs.length; i++) {
            if (chairs[i] == 0) {
                empty.add(i);
            } else {
                full.add(i);
            }
        }

        int res = 0;
        int max = 0;
        for (int i = 0; i < full.size(); i++) {

            int a = 0;
            if (i == 0) {
                if (full.get(0) != 0) {
                    a = full.get(0);
                    res = 0;
                    max = a + 1;
                    continue;
                }
            } else {
                a = full.get(i) - full.get(i - 1);
            }

            if (a > max) {
                res = full.get(i) - a / 2;
                max = a;
            }

            if (i == full.size() - 1) {
                if (full.get(full.size() - 1) < chairs.length - 1) {

                    int b = chairs.length - 1 - full.get(full.size() - 1);

                    if ((res != 0 && 2 * b >= max) || (res == 0 && b >= max)) {
                        res = chairs.length - 1;
                        continue;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Sitdown method = new Sitdown();
//        System.out.println(method.sitdown(new int[]{1, 0, 1, 0, 0, 1, 0, 0, 0, 1}));
//        System.out.println(method.sitdown(new int[]{0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1}));
        System.out.println(method.sitdown(new int[]{1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0}));

    }
}
