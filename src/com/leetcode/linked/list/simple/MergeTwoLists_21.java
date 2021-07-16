package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists_21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);

        ListNode l3 = prehead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {

                l3.next = l1;
                l1 = l1.next;
            } else {

                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        l3.next = l1 == null ? l2 : l1;
        return prehead.next;
    }


    /**
     * 2021.7.16
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(-1);
        ListNode l4 = l3;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                l3.next = new ListNode(l1.val);
                l1 = l1.next;

            } else {
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (l1 == null) {
            l3.next = l2;
        } else {
            l3.next = l1;
        }
        return l4.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        MergeTwoLists_21 method = new MergeTwoLists_21();
        method.mergeTwoLists2(n1, n2);
    }
}
