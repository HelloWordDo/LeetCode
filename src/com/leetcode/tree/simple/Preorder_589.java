package com.leetcode.tree.simple;

import com.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 */
public class Preorder_589 {

    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            res.add(node.val);

            List<Node> children = node.children;
            if (children == null) {
                continue;
            }
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return res;
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

        node1.children = l1;

        Node node2 = new Node(2);
        Node node3 = new Node(4);

        list.add(node1);
        list.add(node2);
        list.add(node3);
        root.children = list;

        Preorder_589 preorder_589 = new Preorder_589();
        List l = preorder_589.preorder(root);
        System.out.println("结果:" + l);
    }
}
