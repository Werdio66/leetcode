package com._520.leetcode._11_25;


public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1)
            return lists[0];

        return null;
    }
}
