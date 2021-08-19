package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class ZigzagLevelOrder_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> q1 = new LinkedBlockingQueue<>();
        Queue<TreeNode> q2 = new LinkedBlockingQueue<>();

        boolean left = false;
        q1.offer(root);

        while (!q1.isEmpty()) {

            List l = new ArrayList();
            left = !left;
            while (!q1.isEmpty()) {

                TreeNode node = q1.poll();
                if (left) {
                    l.add(node.val);
                } else {
                    l.add(0, node.val);
                }

                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            if (!l.isEmpty()) {
                res.add(l);
            }

            q1 = q2;
            q2 = new LinkedBlockingQueue<>();
        }
        return res;
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("3,9,20,#,#,15,7");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,3,4,#,#,5");
        ZigzagLevelOrder_103 method = new ZigzagLevelOrder_103();
        List<List<Integer>> res = method.zigzagLevelOrder(treeNode);
        System.out.println(res);
    }


}
