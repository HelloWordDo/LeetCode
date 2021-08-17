package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> queue2 = new LinkedBlockingQueue<>();
        queue1.offer(root);

        while (!queue1.isEmpty()) {

            List<Integer> l = new ArrayList<>();

            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                l.add(node.val);

                if (node.left != null) {
                    queue2.offer(node.left);
                }

                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }

            if (!l.isEmpty()) {
                res.add(l);
            }
            queue1 = queue2;
            queue2 = new LinkedBlockingQueue<>();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("3,9,20,#,#,15,7");

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,3,4,#,#,5");
        LevelOrder_102 method = new LevelOrder_102();
        System.out.println(method.levelOrder(treeNode));
    }
}
