package com._520.leetcode.demo;

/**
 *  在字符串中查找第一个只出现一次的字符
 */
public class FirstNotRepeatingChar {

    private int findFirstNotRepeatingChar(String str){
        int[] result = new int[256];

        for (int i = 0; i < str.length(); i++) {
            result[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (1 == result[str.charAt(i)]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar f = new FirstNotRepeatingChar();
        System.out.println(f.findFirstNotRepeatingChar("google"));
    }
}
