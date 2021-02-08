package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode node = slow;
        int count = 1;
        while (fast.next != null) {

            if (count >= n) {
                slow = slow.next;
            }
            fast = fast.next;
            ++count;
        }

        slow.next = slow.next.next;
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

        removeNthFromEnd(n1, 1);
    }
}
