package com._520.leetcode._11_3;

/**
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 第2种解法
 */
public class LongestPalindrome2 {

    public static String getStr(String string){
        String str = "";

        for (int i = 0; i < string.length(); i++) {
            str += "#" + string.charAt(i);
        }

        str += "#";
        return str;
    }

    public static String longestPalindrome(String s) {

        String s1 = getStr(s);
//        System.out.println(s1);
//        System.out.println(s);
        String maxStr = "";
        int max = 0;        // 记录回文串的最大长度
        for (int i = 1; i < s1.length(); i++) {
           int start = i - 1;
            int end = i - 1;
            while (start >= 0 && end < s1.length()){
                if (s1.charAt(start) == s1.charAt(end)){
                    String newStr = s1.substring(start,end + 1);
//                    System.out.println("start = " + start + " 中点 = " + i + " end = " + end);
                    maxStr = newStr.length() > max ? newStr : maxStr;
                    max = maxStr.length();
//                    System.out.println(maxStr);
                }else
                    break;
                start--;
                end++;
            }

        }


        return maxStr.replaceAll("#","");
    }

    public static void main(String[] args) {
        String str = "ac";
        System.out.println(longestPalindrome(str));
    }
}
