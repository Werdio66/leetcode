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
 * 第一种解法：       时间复杂度为O（n^3）
 */
public class LongestPalindrome1 {

    // 判断字符串是不是回文
    private static boolean ispalindrome(String str){

        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
           if (str.charAt(i) != str.charAt(length - i - 1))
               return false;
        }

        return true;
    }
    public static String longestPalindrome(String s) {
        String maxStr = "";
        int max = 0;        // 记录回文串的最大长度
        System.out.println(s + "   " + s.length());
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i,j);      // 遍历所有的字串
                System.out.println(str);
                int len = str.length();             // 字串的长度,如果没有现在最长的字串长，就没有必须计算了
                if (ispalindrome(str) && len > max){//

                    maxStr = s.substring(i,j);      // 记录当前字串
                    max = Math.max(max,len);        // 更新max值
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        String str = "abcbay";
        System.out.println("最长字串：" + longestPalindrome(str));
    }
}
