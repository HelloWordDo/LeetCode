package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 897. 递增顺序查找树
 * <p>
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 *     5
 *    / \
 *   3    6
 *  / \    \
 *  2   4    8
 *  /        / \
 *  1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreasingBST_897 {

    TreeNode curr = null;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode();
        curr = ans;
        help(root);

        return ans.right;
    }

    public void help(TreeNode root) {

        if (root.left != null) {
            help(root.left);
        }
        root.left = null;
        curr.right = root;
        curr = curr.right;

        if (root.right != null) {
            help(root.right);
        }
    }


    public static void main(String[] args) {

        TreeNode treeNode1 = Deserialize.LevelOrderDeserialize("5,3,6,2,4,#,8,1,#,#,#,7,9");

        IncreasingBST_897 method = new IncreasingBST_897();

        System.out.println("结果：" + method.increasingBST(treeNode1));
    }
}
