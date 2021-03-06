package com._520.leetcode.DynamicProgramming;

/**
 *  给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Demo12 {
    private int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Demo12().numTrees(3));
    }
}
