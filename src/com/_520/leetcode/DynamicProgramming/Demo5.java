package com._520.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 *  给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */
public class Demo5 {
    private int[] arr;
    public Demo5(int[] nums) {
        arr = Arrays.copyOf(nums,nums.length);
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        Demo5 d = new Demo5(arr);

        System.out.println(d.sumRange(0,2));
    }
}
