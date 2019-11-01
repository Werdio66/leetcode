package com._520.leetcode._11_1;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。

 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    private static class ListNode{
        private int number;
        private ListNode nextNode;

        private ListNode(int number){
            this.number = number;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "number=" + number +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        ListNode left = l1;
        ListNode right = l2;
        int carry = 0;      // 进位
        while (left != null || right != null){
            int i = left.number;
            int j = right.number;
            int sum = i + j + carry;
            carry = sum / 10;

            temp.setNextNode(new ListNode(sum % 10));

            if (carry!= 0){
                if (left.nextNode == null)  left.setNextNode(new ListNode(0));
                if (right.nextNode == null) right.setNextNode(new ListNode(0));
            }

            left = left.nextNode;
            right = right.nextNode;
            temp = temp.nextNode;
        }

        return newNode.nextNode;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(4);
        l11.nextNode = l12;
        l12.nextNode = l13;
        System.out.println(l11);

        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(5);
        l3.nextNode = l4;
        System.out.println(l3);

        ListNode Node = addTwoNumbers(l11, l3);
        System.out.println(Node);
    }
}
