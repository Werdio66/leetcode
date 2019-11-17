package com._520.leetcode._11_17;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * 双指针法
 *      从数组的左右俩端
 * 时间复杂度为 O(n)
 */
public class MaxArea2 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int volume = 0;         // 容积
       while (left < right){

           int temp = Math.min(height[left], height[right]) * (right - left);
           volume = Math.max(temp,volume);
           if (height[left] <= height[right])
               left++;
           else
               right--;
       }

        return volume;
    }

    public static void main(String[] args) {
        MaxArea2 maxArea1 = new MaxArea2();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1.maxArea(arr));
    }
}
