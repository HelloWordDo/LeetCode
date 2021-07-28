package com.leetcode.string.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i]) {
                continue;
            }

            String s = strs[i];
            visited[i] = true;
            List<String> list = new ArrayList<>();
            list.add(s);

            for (int j = i + 1; j < strs.length; j++) {

                String ss = strs[j];

                if (check(s, ss)) {

                    visited[j] = true;
                    list.add(ss);
                }
            }
            res.add(list);
        }

        return res;
    }


    boolean check(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap();

        for (Character c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>(map);
        for (int i = 0; i < s2.length(); i++) {

            if (map.containsKey(s2.charAt(i))) {

                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {

        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        HashMap<Long, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {

            long k = 1;
            for (int j = 0; j < strs[i].length(); j++) {
                k *= prime[strs[i].charAt(j) - 'a'];
            }

            if (map.containsKey(k)) {
                map.get(k).add(strs[i]);

            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(k, temp);
            }
        }

        return new ArrayList(map.values());
    }


    public static void main(String[] args) {

        GroupAnagrams_49 method = new GroupAnagrams_49();
        List<List<String>> res = method.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);

        res = method.groupAnagrams(new String[]{"", ""});
        System.out.println(res);

        res = method.groupAnagrams2(new String[]{"ac", "c", "acd"});
        System.out.println(res);
        res = method
                .groupAnagrams2(new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"});
        System.out.println(res);
    }
}
