package com._520.leetcode.demo;

public class MaxSubArray {

    private int maxSubArray(int[] arr){

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            if (dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(arr));
    }
}
