package com._520.leetcode.array;

import java.util.Arrays;

public class Demo1 {
    private int threeSum(int[] nums, int target){
        Arrays.sort(nums);
        int end = nums.length - 1;
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int begin = i + 1;
            while (begin < end) {
                int ans = nums[i] + nums[begin] + nums[end];
                sum = Math.abs(ans - target) > Math.abs(sum - target) ? sum : ans;
                if (sum > target)
                    end--;
                else if (sum < target)
                    begin++;
                else
                    return sum;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        System.out.println(new Demo1().threeSum(arr, 1));
    }
}
