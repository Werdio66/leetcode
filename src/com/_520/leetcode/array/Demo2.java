package com._520.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 *  使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0, j = nums.length - 1; i <= j; i++) {
            int begin = i + 1;
            int end = j - 1;
            while (begin < end){
                int ans = nums[i] + nums[begin] + nums[end] + nums[j];
                if (ans > target){
                    end--;
                }else if (ans < target){
                    begin++;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    list.add(nums[j]);
                    lists.add(list);
                    begin++;
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(new Demo2().fourSum(arr, 0));
    }
}
