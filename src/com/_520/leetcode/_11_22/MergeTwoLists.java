package com._520.leetcode._11_22;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode list = new ListNode(-1);
        ListNode head = list;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                list.next = list1;
                list1 = list1.next;
            }else {

                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;
        }

        if (list1 != null){
            list.next = list1;
        }

        if (list2 != null){
            list.next = list2;
        }

        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        MergeTwoLists m = new MergeTwoLists();
//        ListNode head = m.mergeTwoLists(l1, l2);
        ListNode head = m.Merge(l1, l2);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
