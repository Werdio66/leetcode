package com._520.leetcode._11_17;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * 遍历所有数据       时间复杂度为O(n^2)
 */
public class MaxArea1 {

    public int maxArea(int[] height) {

        int volume = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                volume = Math.max((Math.min(height[i],height[j]) * (j - i)),volume);
            }
        }

        return volume;
    }

    public static void main(String[] args) {
        MaxArea1 maxArea1 = new MaxArea1();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1.maxArea(arr));
    }
}
