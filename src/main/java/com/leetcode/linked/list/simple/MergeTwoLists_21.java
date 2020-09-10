package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 21. 合并两个有序链表
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


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        mergeTwoLists(n1, n2);
    }
}
