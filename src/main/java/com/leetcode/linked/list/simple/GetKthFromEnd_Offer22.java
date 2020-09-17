package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd_Offer22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;

        int count = 0;
        while (fast != null) {
            if (count >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        return slow;
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

        getKthFromEnd(n1, 3);
    }

}
