package com._520.leetcode.DynamicProgramming;

/**
 *  直接在原来的数组修改，不需要额外的空间
 */
public class Demo10 {
    public int minPathSum(int[][] grid) {
        
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
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
        System.out.println(new Demo10().minPathSum(arr));
    }
}
