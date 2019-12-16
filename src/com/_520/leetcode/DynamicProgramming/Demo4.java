package com._520.leetcode.DynamicProgramming;

/**
 *  给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Demo4 {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);

        }
        return dp[nums.length];
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(rob(arr));
    }
}
