package com._520.leetcode.DynamicProgramming;

public class Demo9 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + dp[i - 1][j - 1] + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m + n];
        dp[0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + dp[j - 1] + grid[i][j];
            }
        }

        return dp[m + n - 1];
    }
    
    public int minPathSum2(int[][] grid){
//        for (int i = 1; i < grid.length; i++) {
//            grid[i][0] = grid[i - 1][0] + grid[i][0];
//        }
//        for (int i = 1; i < grid[0].length; i++) {
//            grid[0][i] = grid[0][i - 1] + grid[0][i];
//        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i - 1][j - 1] + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {
        int[][] arr = {
                {3,5,8},
                {5,2,3},
                {4,2,5}
        };
        System.out.println(new Demo9().minPathSum(arr));
//        System.out.println(new Demo9().minPathSum1(arr));
        System.out.println(new Demo9().minPathSum2(arr));
    }
}
