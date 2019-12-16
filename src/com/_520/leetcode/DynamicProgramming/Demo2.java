package com._520.leetcode.DynamicProgramming;

/**
 *  给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Demo2 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);

            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-9,-4,-5,-6,6,-3,-1,-3};
        System.out.println(maxSubArray(arr));
    }
}
