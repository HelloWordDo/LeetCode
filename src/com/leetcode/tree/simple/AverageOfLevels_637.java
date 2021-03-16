package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 637. 二叉树的层平均值
 */
public class AverageOfLevels_637 {

    List res = new ArrayList();

    Queue<TreeNode> queue = new LinkedList<>();
    Queue<TreeNode> temp = new LinkedList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        queue.add(root);
        helper();
        return res;
    }

    public void helper() {
        double sum = 0.0;
        int size = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum += node.val;

            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
        }

        res.add(sum / size);
        queue = temp;
        temp = new LinkedList<>();
        if (!queue.isEmpty()) {
            helper();
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,3,4,#");
        AverageOfLevels_637 method = new AverageOfLevels_637();

        System.out.println("结果：" + method.averageOfLevels(treeNode));
    }
}
