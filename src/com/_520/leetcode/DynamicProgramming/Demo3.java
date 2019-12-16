package com._520.leetcode.DynamicProgramming;

/**
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class Demo3 {

    // 暴力破解
    public static int maxProfit(int[] prices) {
        int max = 0;
        int dp = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                dp = prices[j] - prices[i] > 0 ? prices[j] - prices[i] : 0;
                max = Math.max(max,dp);
            }
        }
        return max;
    }
    public static int maxProfit1(int[] prices) {
        int minPoint = Integer.MAX_VALUE;
        int maxPoint = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPoint)
                minPoint = prices[i];
            if (prices[i] - minPoint > maxPoint)
                maxPoint = prices[i] - minPoint;
        }

        return maxPoint;
    }
    public static void main(String[] args) {
        int[] arr = {1,7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit1(arr));
    }
}
