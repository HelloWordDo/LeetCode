package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDiffInBST_783 {

    /**
     * 2021.4.1
     *
     * @param root
     * @return
     */
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {

        minDiffInBST(root, root.val);

        return min;
    }

    public int minDiffInBST(TreeNode root, int before) {

        if (root.left != null) {
            before = minDiffInBST(root.left, before);
        }

        System.out.println(root.val + "---" + before);

        if (root.val != before) {
            min = Math.min(min, Math.abs(root.val - before));
        }

        before = root.val;

        if (root.right != null) {
            before = minDiffInBST(root.right, before);
        }
        return before;
    }


    public static void main(String[] args) {

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("27,#,34,#,58,50,#,44,#");
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("90,69,#,49,89,#,52");

        MinDiffInBST_783 method = new MinDiffInBST_783();

        System.out.println("结果：" + method.minDiffInBST(treeNode));
    }

}
