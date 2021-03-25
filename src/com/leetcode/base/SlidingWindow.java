package com.leetcode.base;

import java.util.HashMap;

public class SlidingWindow {

    public void template(String s, String t) {

        HashMap<Character, Integer> need = new HashMap(), window = new HashMap();

        for (char c : t.toCharArray()) {

            //保存需要 t 中每个字符个数
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {

            // c 是将移入窗口的字符
            char c = s.charAt(right);

            //向右滑动
            right++;

            // 进行窗口内数据的一系列更新
            // ...

            /*** debug 输出的位置 ***/
            System.out.println("window: [" + left + ", " + right + ")");
            /********************/

            // while (window needs shrink)
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {

                // d 是将移出窗口的字符
                char d = s.charAt(left);

                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                // ...
            }

        }

    }
}
