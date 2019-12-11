package com._520.leetcode.demo;

public class ArrayDemo1 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int n : nums){
            if(n > 0)
                sum += n;
            else{
                sum = n;
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-9,-4,-5,-6,-3,-1,-3};
        System.out.println(maxSubArray(arr));
    }
}
