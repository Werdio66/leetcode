package com._520.leetcode.demo;

import java.util.Stack;

/**
 *  俩个栈模拟队列
 */
public class QueueDemo {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    private static void push(int node) {
        stack1.push(node);
    }

    private static int pop() {
        if (stack2.empty() && !stack1.empty()){
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        System.out.println(pop());
    }
}
