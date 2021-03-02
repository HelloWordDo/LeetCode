package com.leetcode.tree.simple;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 */
public class IsSymmetric_101 {

    public static boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();

            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if ((left == null && right != null) || (left != null && right == null)) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);

        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);

        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);

        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);

//        t1.left.left.left = new TreeNode(9);

        Boolean b = isSymmetric(t1);

        System.out.println("结果：" + b);
    }
}
