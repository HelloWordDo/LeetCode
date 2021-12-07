package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect_117 {

    public TreeNode connect(TreeNode root) {

        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        q1.add(root);

        TreeNode pre = null;
        while (q1 != null && q1.size() != 0) {

            TreeNode node = q1.poll();
            node.next = pre;

            pre = node;
            if (node.right != null) {
                q2.add(node.right);
            }

            if (node.left != null) {
                q2.add(node.left);
            }

            if (q1.size() == 0) {
                q1 = q2;
                q2 = new LinkedList<>();
                pre = null;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        Connect_117 method = new Connect_117();

//        TreeNode root = Deserialize.LevelOrderDeserialize("1,2,3,4,5,#,7");
//        TreeNode root = Deserialize.LevelOrderDeserialize("1,2,3,4,5,#,7,8,9,10,11,12,13");
        TreeNode root = Deserialize.LevelOrderDeserialize("1,2,3,4,5,#,7,8,9,10,#,12,13");
        method.connect(root);
    }
}
