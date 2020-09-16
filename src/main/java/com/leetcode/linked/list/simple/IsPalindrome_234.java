package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

import java.util.Stack;

/**
 * 234. 回文链表
 */
public class IsPalindrome_234 {

    public static boolean isPalindrome(ListNode head) {

        ListNode l = head;
        int index = 0;
        if (head == null || head.next == null) {
            return true;
        }

        while (head != null) {
            index++;
            head = head.next;
        }

        Stack<Integer> stack = new Stack<>();

        int i = 0;

        while (l != null) {

            ++i;
            if (stack.isEmpty()) {
                stack.push(l.val);
            } else {
                if (index % 2 != 0) {
                    if (i == index / 2 + 1) {
                        l = l.next;
                        continue;
                    }

                }
                if (i <= index / 2 || stack.peek() != l.val) {
                    stack.push(l.val);
                } else {
                    stack.pop();
                }
            }
            l = l.next;

        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(1);

        System.out.println(isPalindrome(n1));
    }
}
