package com.leetcode.tree.simple;

import com.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 590. N 叉树的后序遍历
 */
public class Postorder_590 {

    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {

            Node node = stack1.pop();
            stack2.push(node);

            if (node.children == null) {
                continue;
            }

            for (int i = 0; i < node.children.size() ; i++) {

                stack1.push(node.children.get(i));
            }

        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
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

        Postorder_590 postorder_590 = new Postorder_590();
        List l = postorder_590.postorder(root);
        System.out.println("结果:" + l);
    }
}
