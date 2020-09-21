package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates_82 {


    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);

        ListNode l = node;
        ListNode slow = head;
        ListNode fast = slow;
        boolean same = false;

        while (fast != null) {

            if (fast.next == null || fast.val != fast.next.val) {

                if (same) {
                    slow = fast.next;
                } else {
                    slow = fast;
                }

                if (slow == null) {
                    fast = null;
                } else {
                    fast = slow.next;
                }

                if (fast != null && slow.val == fast.val) {
                    same = true;
                } else {
                    node.next = slow;
                    node = node.next;
                    same = false;
                }
            } else {
                fast = fast.next;
                same = true;
            }
        }

        return l.next;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(2);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(5);
        n2 = n2.next;
        n2.next = new ListNode(5);

        deleteDuplicates(n1);
    }
}
