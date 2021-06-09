package com.leetcode.linked.list.hard;

import com.leetcode.linked.list.ListNode;

/**
 * 23. 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode listNode = new ListNode(-1);
        ListNode res = listNode;

        int minIndex = 0;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {

                ListNode node = lists[i];
                if (node == null) {
                    continue;
                }

                int value = node.val;

                if (value < minValue) {
                    minValue = value;
                    minIndex = i;
                }
            }

            if (minValue == Integer.MAX_VALUE) {
                break;
            }
            listNode.next = new ListNode(minValue);
            listNode = listNode.next;
            lists[minIndex] = lists[minIndex].next;

        }
        return res.next;
    }


    public static void main(String[] args) {

        MergeKLists_23 method = new MergeKLists_23();

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);


        ListNode[] listNodes = new ListNode[]{n1, n2, n3};

        ListNode res = method.mergeKLists(listNodes);
        System.out.println(res);
    }
}
