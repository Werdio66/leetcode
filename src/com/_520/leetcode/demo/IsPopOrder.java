package com._520.leetcode.demo;

import java.util.Stack;

/**
 *  判断后一个序列是不是正确出栈序列
 */
public class IsPopOrder {

    public boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int num : pushA) {
            stack.push(num);
            while (i < popA.length && stack.peek() == popA[i]){
                stack.pop();
                i++;
            }
        }


        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new IsPopOrder().isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
