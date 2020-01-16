package com._520.leetcode.demo;

import java.util.Arrays;
import java.util.Stack;

/**
 *  反转字符串
 *  例：      man. good a am i
 *  反转后：  i am a good man.
 */
public class ReverseSentence {

    private static String reverseSentence(String str){

        if (str.trim().equals("")){
            return str;
        }
        Stack<String> stack = new Stack<>();

        String[] s = str.split(" ");
        System.out.println(Arrays.toString(s));
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.append(stack.pop());
            if (stack.size() > 0){
                sb.append(" ");
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseSentence(" ").length());
    }
}
