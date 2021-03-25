package com.leetcode.sliding.window.middle;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInclusion_567 {

    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        int left = 0, right = 0, valid = 0;

        for (Character c : s2.toCharArray()) {

            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s1.length()) {

            char c = s1.charAt(right);

            right++;

            if (need.containsKey(c)) {

                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }

            }
            System.out.println("window: [" + left + ", " + right + ")");

            while (valid == need.size()) {

                char d = s1.charAt(left);

                if (right - left == s2.length()) {
                    return true;
                }

                if (need.containsKey(d)) {

                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        CheckInclusion_567 method = new CheckInclusion_567();
        boolean s = method.checkInclusion("eidbaooo", "ab");
        System.out.println("结果：" + s);
    }
}
