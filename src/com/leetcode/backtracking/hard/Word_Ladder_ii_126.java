package com.leetcode.backtracking.hard;

import java.util.*;

/**
 * 126. 单词接龙 II
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * <p>
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 7
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 */
public class Word_Ladder_ii_126 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return res;
        }

        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        HashMap<String, List<String>> neighborsMap = getNeighbors(queue, wordList, endWord, beginWord);

        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        backtrack(beginWord, endWord, list, neighborsMap);
        return res;
    }

    private HashMap<String, List<String>> getNeighbors(Queue<String> queue, List<String> wordList, String endWord, String beginWord) {

        HashMap<String, List<String>> neighborsMap = new HashMap<>();

        boolean flag = false;
        Set dict = new HashSet(wordList);
        Set visited = new HashSet();
        visited.add(beginWord);
        while (!queue.isEmpty()) {

            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                List<String> neighbors = neighborList(word, dict);

                Iterator<String> it = neighbors.iterator();//把元素导入迭代器
                while (it.hasNext()) {
                    String neighbor = it.next();
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            flag = true;
                        }
                        queue.offer(neighbor);
                        subVisited.add(neighbor);
                    } else {
                        it.remove();
                    }
                }
                neighborsMap.put(word, neighbors);
            }
            visited.addAll(subVisited);
            if (flag) {
                break;
            }
        }
        return neighborsMap;
    }

    private List<String> neighborList(String word, Set dict) {

        List<String> list = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {

            for (int i = 0; i < chs.length; i++) {

                if (ch == chs[i]) {
                    continue;
                }
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    list.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }

        return list;
    }


    private void backtrack(String beginWord, String endWord, LinkedList<String> list, HashMap<String, List<String>> neighborsMap) {

        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        List<String> neighbors = neighborsMap.getOrDefault(beginWord, new ArrayList<>());
        for (String neighbor : neighbors) {
            list.add(neighbor);
            backtrack(neighbor, endWord, list, neighborsMap);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {

        Word_Ladder_ii_126 method = new Word_Ladder_ii_126();
        System.out.println(method.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
