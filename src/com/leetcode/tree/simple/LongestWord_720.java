package com.leetcode.tree.simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * 720. 词典中最长的单词
 */
public class LongestWord_720 {

    public String longestWord(String[] words) {

        int index = 0;

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word, ++index);
        }

        String res = "";
        Stack<Node> stack = new Stack<>();

        stack.push(trie.root);
        while (!stack.isEmpty()) {

            Node node = stack.pop();

            if (node.index > 0 || node == trie.root) {

                if (node != trie.root) {

                    String word = words[node.index - 1];

                    if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                        res = word;
                    }
                }
                for (Node n : node.children.values()) {
                    stack.push(n);
                }

            }
        }

        return res;
    }


    class Node {

        char c;
        HashMap<Character, Node> children = new HashMap<>();
        int index;

        Node(char c) {
            this.c = c;
        }
    }

    class Trie {

        Node root;

        public Trie() {
            this.root = new Node('0');
        }

        public void insert(String word, int i) {

            Node cur = root;
            for (int j = 0; j < word.length(); j++) {

                char c = word.charAt(j);
                HashMap<Character, Node> children = cur.children;
                children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.index = i;
        }
    }

    public static void main(String[] args) {

        LongestWord_720 longestWord_720 = new LongestWord_720();
        String t = longestWord_720.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});

        System.out.println("结果:" + t);
    }
}
