package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderBottom_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            res.add(0, list);
        }
        return res;
    }

    public static void main(String[] args) {

        LevelOrderBottom_107 method = new LevelOrderBottom_107();

        TreeNode node = Deserialize.LevelOrderDeserialize("3,9,20,#,#,15,7");
        method.levelOrderBottom(node);

    }
}
