package com.leetcode.tree.simple;

import com.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. N 叉树的最大深度
 */
public class MaxDepth_559 {

    public int maxDepth(Node root) {

        int max = 0;
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }

        List<Node> children = root.children;
        for (Node node : children) {

            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        List<Node> list = new ArrayList<>();
        Node node1 = new Node(3);

        List<Node> l1 = new ArrayList<>();
        Node node11 = new Node(5);
        Node node12 = new Node(6);
        l1.add(node11);
        l1.add(node12);

//        node1.children = l1;

        Node node2 = new Node(2);
        Node node3 = new Node(4);

        list.add(node1);
        list.add(node2);
        list.add(node3);
        root.children = list;

        MaxDepth_559 maxDepth_559 = new MaxDepth_559();
        int res = maxDepth_559.maxDepth(root);
        System.out.println("结果:" + res);
    }
}
