package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal_94 {

    List<Integer> res = new ArrayList<>();

    //迭代，中序遍历不忘左链入栈
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {

            if (root != null) {

                stack.push(root);
                root = root.left;

            } else {

                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("5,4,8,11,12,13,4");
        InorderTraversal_94 method = new InorderTraversal_94();
        List<Integer> res = method.inorderTraversal(treeNode);
        System.out.println(res);
    }
}
