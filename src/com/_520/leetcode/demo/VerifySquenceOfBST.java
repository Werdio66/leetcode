package com._520.leetcode.demo;

import java.util.Arrays;

/**
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *  如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence){
        if (sequence.length == 0)
            return false;
        return isBST(sequence, 0, sequence.length);
    }

    private boolean isBST(int[] sequence, int begin, int end){
        // 比较完了
        if (begin >= end - 1)
            return true;
        // 记录根结点的位置
        int position = begin;
        // 根结点的值
        int root = sequence[end - 1];
        // 找到根结点的位置
        for (int i = begin; i < end; i++) {
            // 必须用 >= 有特殊情况，单链表
            if (sequence[i] >= root){
                position = i - 1;
                break;
            }
        }
        // 遍历右子树，看是否有结点比根结点的值小
        for (int i = position + 1; i < end; i++) {
            if (sequence[i] < root)
                return false;
        }

        return isBST(sequence, begin, position + 1) && isBST(sequence, position + 1, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().verifySquenceOfBST(new int[]{1,2,3,4,5}));
    }
}
