package com._520.leetcode.DynamicProgramming;

import java.util.Comparator;
import java.util.function.BiFunction;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class Demo7 {
    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
        int[] dp = new int[n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = 1;
//        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[j] = dp[j - 1] + dp[j];
            }
        }

//        return dp[m - 1][n - 1];
        return dp[n - 1];
    }
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> function = new Demo7()::uniquePaths;
        System.out.println(function.apply(3, 2));
    }
}
