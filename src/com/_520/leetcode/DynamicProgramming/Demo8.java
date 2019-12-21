package com._520.leetcode.DynamicProgramming;

import java.util.function.BiFunction;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */
public class Demo8 {
    public int uniquePaths(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        if (arr[0][0] == 1)
            return 0;

        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = arr[0][i] == 0 && dp[0][i - 1] == 1 ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = arr[i][0] == 0 && dp[i][0] == 1 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0;
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[1][1] = 1;
        System.out.println(new Demo8().uniquePaths(arr));

    }
}
