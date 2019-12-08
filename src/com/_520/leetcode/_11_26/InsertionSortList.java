package com._520.leetcode._11_26;

/**
 * 对链表进行插入排序。
 */
public class InsertionSortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode left = head;
        ListNode right = head.next;



        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        InsertionSortList i = new InsertionSortList();
        i.insertionSortList(l1);

        while (l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
