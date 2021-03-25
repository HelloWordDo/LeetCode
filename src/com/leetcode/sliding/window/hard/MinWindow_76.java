package com.leetcode.sliding.window.hard;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow_76 {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap(), window = new HashMap();

        for (char c : t.toCharArray()) {

            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        String res = "";
        int min = Integer.MAX_VALUE;

        while (right < s.length()) {

            char c = s.charAt(right);

            right++;

            if (need.containsKey(c)) {

                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {

                char cl = s.charAt(left);

                if (need.containsKey(cl)) {
                    window.put(cl, window.get(cl) - 1);

                    if (window.get(cl).compareTo(need.get(cl)) < 0) {
                        valid--;
                    }
                }

                if (right - left < min) {
                    min = right - left;
                    res = s.substring(left, right);
                }
                left++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        MinWindow_76 method = new MinWindow_76();

        String s = method.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("结果：" + s);
    }
}
