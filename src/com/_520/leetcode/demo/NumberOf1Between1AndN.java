package com._520.leetcode.demo;

/**
 *  求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {

    private int getCount(int n){
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += findOne(i);
        }
        return count;
    }

    private int findOne(int i) {
        int count = 0;
        String str = Integer.toString(i);
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().getCount(55));
    }
}
