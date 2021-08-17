package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 */
public class RecoverTree_99 {

    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    TreeNode t1, t2 = null;

    public void recoverTree(TreeNode root) {

        findTree(root);

        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public void findTree(TreeNode root) {

        if (root.left != null) {
            findTree(root.left);
        }

        if (pre.val > root.val) {

            if (t1 == null) {
                t1 = pre;
            }
            if (t1 != null) {
                t2 = root;
            }
        }
        pre = root;
        if (root.right != null) {
            findTree(root.right);
        }
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("3,1,4,#,#,2,#");

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,3,#,#,2");
        RecoverTree_99 method = new RecoverTree_99();
        method.recoverTree(treeNode);
        System.out.println(treeNode);
    }
}
