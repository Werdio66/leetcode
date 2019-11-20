package com._520.leetcode._11_19;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 双指针，一次遍历
 */
public class RemoveNthFromEnd2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = new ListNode(0);
        temp.next = head;
        // 第一个结点
        ListNode first = head;
        // 第二个结点
        ListNode second = head;


        for (int i = 0; i < n; i++) {
            // 拉开n个单位距离
            first = first.next;
            // 删除第一个结点结点
            if (first == null)
                return temp.next.next;
        }

        // 俩个指针一起移动
        while (first.next != null){
            first = first.next;
            second = second.next;
        }

        // 删除指定结点
        second.next = second.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd2 r = new RemoveNthFromEnd2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = r.removeNthFromEnd(head,3);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
