package com._520.leetcode.demo;

public class LeftRoateString {
     public static String LeftRotateString(String str,int n) {
         StringBuilder stringBuilder = new StringBuilder();
         String subString = str.substring(0, n);
         stringBuilder.append(str, n, str.length());
         stringBuilder.append(subString);
         return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcdefgh", 3));
    }
}
