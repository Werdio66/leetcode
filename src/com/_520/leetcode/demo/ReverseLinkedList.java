package com._520.leetcode.demo;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseLinkedList {
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode temp = newHead;
        while (stack.size() > 0){
            temp.next = stack.pop();
            temp = temp.next;
        }

        return newHead;
    }
}
