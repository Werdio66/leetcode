package com._520.leetcode.array;

import java.util.Arrays;

/**
 *  给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 *  使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo1 {
    private int threeSum(int[] nums, int target){
        Arrays.sort(nums);
        // 初始化sum，
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            // 双指针
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int ans = nums[i] + nums[begin] + nums[end];
                // 如果ans离目标值近，就将它赋给sum
                if (Math.abs(ans - target) < Math.abs(sum - target)){
                    sum = ans;
                }
                if (ans > target)
                    end--;
                else if (ans < target)
                    begin++;
                else    // ans和target相等
                    return ans;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(new Demo1().threeSum(arr, 82));
    }
}
