package com.leetcode.sliding.window.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 */
public class FindSubstring_30 {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        int wordLen = words[0].length();
        int wholeLen = wordLen * words.length;

        HashMap<String, Integer> needs = new HashMap();

        for (int i = 0; i < words.length; i++) {
            needs.put(words[i], needs.getOrDefault(words[i], 0) + 1);
        }

        int left = 0, right = wholeLen - 1;

        while (right < s.length()) {

            String cutWord = s.substring(left, right + 1);

            HashMap<String, Integer> visited = new HashMap();

            for (int i = 0; i < words.length; i++) {

                int start = i * wordLen;
                String w = cutWord.substring(start, start + wordLen);

                if (!needs.containsKey(w)) {
                    break;
                }

                if (needs.get(w) >= visited.getOrDefault(w, 0) + 1) {
                    visited.put(w, visited.getOrDefault(w, 0) + 1);
                } else {
                    break;
                }

                if (i == words.length - 1) {

                    res.add(left);
                }
            }

            System.out.println("window: [" + left + ", " + right + ")");

            left++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {

        FindSubstring_30 method = new FindSubstring_30();

//        method.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});

        method.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
    }
}
