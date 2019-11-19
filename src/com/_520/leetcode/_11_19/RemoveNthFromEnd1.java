package com._520.leetcode._11_19;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 单指针，俩次遍历
 */
public class RemoveNthFromEnd1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        ListNode first = head;
        while (first != null){
            count++;
            first = first.next;
        }
        System.out.println(count);

        int index = count - n;

        first = head;

        for (int i = 0; i < index; i++) {
            first = first.next;
        }

        first.next = first.next.next;

        return temp;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd1 r = new RemoveNthFromEnd1();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = r.removeNthFromEnd(head,2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
