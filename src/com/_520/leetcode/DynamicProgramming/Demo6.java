package com._520.leetcode.DynamicProgramming;


/**
 *  上一次如果要查询多次每次都需要重新计算
 */
public class Demo6 {
    private int[] arr;
    public Demo6(int[] nums) {
        arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return arr[j + 1] - arr[i];
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        Demo6 d = new Demo6(arr);

        System.out.println(d.sumRange(0,2));
    }
}
