package com._520.leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Demo13 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    private int minTotal(List<List<Integer>> triangle){
        return rouback(triangle, 0, 0);
    }
    private int rouback(List<List<Integer>> triangle, int floor, int n) {
        if (floor == triangle.size() - 1) {
            return triangle.get(floor).get(n);
        }
        int left = rouback(triangle, floor + 1, n);
        int right = rouback(triangle, floor + 1, n + 1);
        return Math.min(left, right) + triangle.get(floor).get(n);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>();
        List<Integer> integers2 = new ArrayList<>();
        List<Integer> integers3 = new ArrayList<>();
        integers.add(2);
        integers1.add(3);
        integers1.add(4);
        integers2.add(6);
        integers2.add(5);
        integers2.add(7);
        integers3.add(4);
        integers3.add(1);
        integers3.add(8);
        integers3.add(3);
        lists.add(integers);
        lists.add(integers1);
        lists.add(integers2);
        lists.add(integers3);
        System.out.println(new Demo13().minimumTotal(lists));
        System.out.println(new Demo13().minTotal(lists));
    }
}
