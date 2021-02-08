package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs_24 {

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {

            ListNode temp1 = fast.next;
            ListNode temp2 = null;

            if (slow == head) {
                node.next = fast;
            }
            fast.next = slow;

            if (temp1 != null) {
                temp2 = temp1.next;
            }

            if (temp2 == null) {
                slow.next = temp1;
            } else {
                slow.next = temp2;
            }

            slow = temp1;
            fast = temp2;
        }

        return node.next;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(5);

        swapPairs(n1);
    }
}
