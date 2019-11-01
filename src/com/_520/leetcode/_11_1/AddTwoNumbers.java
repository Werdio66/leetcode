package com._520.leetcode._11_1;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。

 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    // 结点类
    private static class ListNode{
        private int number;             // 结点值
        private ListNode nextNode;      // 指向下一个结点

        private ListNode(int number){
            this.number = number;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "number=" + number +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }

    /**
     *  计算结点中数字的和
     * @param l1            结点1
     * @param l2            结点2
     * @return              存放结果的结点
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        ListNode left = l1;
        ListNode right = l2;
        int carry = 0;      // 进位
        while (left != null || right != null){      // 位数不同的计算
            int i = left.number;
            int j = right.number;
            int sum = i + j + carry;
            carry = sum / 10;

            temp.nextNode = (new ListNode(sum % 10));

            if (carry!= 0 || left.nextNode != null || right.nextNode != null){ // 当前有进位
                if (left.nextNode == null)  left.nextNode = (new ListNode(0));      // 创建一个新结点，赋值为0
                if (right.nextNode == null) right.nextNode = (new ListNode(0));
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
