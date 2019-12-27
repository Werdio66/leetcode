package com._520.leetcode.DynamicProgramming;

/**
 *  一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Demo11 {

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ?  0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26){
                dp[i] = dp[i + 1] + dp[i + 2];
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    /**
     *  递归遍历
     * @param s     字符串
     * @param start 从字符串的哪个下标开始
     * @return    解码数
     */
    public int numDecodings(String s, int start) {
        // 判断是不是递归到了最后一个字符
        if (s.length() == start)
            return 1;
        if (s.charAt(start) == '0')
            return 0;
        int num1 = numDecodings(s, start + 1);
        int num2 = 0;
        // 判断俩个数是不是小于26
        if (start < s.length() - 1){
            if ((s.charAt(start) - '0') * 10 + (s.charAt(start + 1) - '0') <= 26){
                num2 = numDecodings(s, start + 2);
            }
        }
        return num1 + num2;
    }


    private int decondings(String s){
        return numDecodings(s, 0);
    }
    public static void main(String[] args) {
        System.out.println(new Demo11().numDecodings("456"));
        System.out.println(new Demo11().decondings("120"));
    }
}
