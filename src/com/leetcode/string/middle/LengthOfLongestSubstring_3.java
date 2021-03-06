package com.leetcode.string.middle;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap();

        int res = 0;
        int left = 0, right = 0;

        while (right < s.length()) {

            if (map.get(s.charAt(right)) == null || map.get(s.charAt(right)) == 0) {
                map.put(s.charAt(right), 1);

                res = Math.max(res, right - left + 1);

                right++;
                continue;
            } else {
                map.put(s.charAt(left), map.get(s.charAt(right)) - 1);

                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        LengthOfLongestSubstring_3 method = new LengthOfLongestSubstring_3();

        System.out.println(method.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(method.lengthOfLongestSubstring("bbbbb"));
        System.out.println(method.lengthOfLongestSubstring("pwwkew"));
        System.out.println(method.lengthOfLongestSubstring(""));
    }


}
