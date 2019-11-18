package com._520.leetcode._11_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组nums,判断nums中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 */
public class ThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        // 数组中的元素少于三个
        if (nums.length < 3)
            return list;

        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            // 都是正数或者负数
            if (nums[0] > 0 || nums[nums.length - 1] < 0)
                return list;
//            if (i + 1 < nums.length && nums[i] == nums[i + 1])
//                continue;
            int left = i + 1;
            int right = nums.length - 1;
            int sum = 0;
//            System.out.println("i = " + i + " begin left = " + left + " right = " + right);
            while (left < right) {
                // 1,2,3,4,5,6,7,8,9
                sum = nums[i] + nums[left] + nums[right];
//                System.out.println("sum = " + sum);
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
//                System.out.println("i = " + i + " end left = " + left + " right = " + right);
                if (sum == 0){
                    if (!list.contains(Arrays.asList(nums[i],nums[left],nums[right]))){
                        list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeNums t = new ThreeNums();
        int[] arr = {};
        System.out.println(t.threeSum(arr));
    }
}
