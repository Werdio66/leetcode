package com._520.leetcode.bookTest;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 *  逆序输出链表
 */
public class Test_5 {

    private static void xxx(ListNode node){
        if (node == null){
            return;
        }
        xxx(node.next);
        System.out.print(node.val + "    ");
    }

    private static void stack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + "    ");
        }

    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        xxx(listNode1);
        System.out.println();
        stack(listNode1);
    }
}
