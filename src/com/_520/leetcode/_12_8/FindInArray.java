package com._520.leetcode._12_8;

/**
 *  在一个二维数组中（每个一维数组的长度相同），
 *  每一行都按照从左到右递增的顺序排序，每一列
 *  都按照从上到下递增的顺序排序。请完成一个函数，
 *  输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInArray {
    public static boolean Find(int target, int [][] array) {
        int cols = array[0].length;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i][cols - 1])
                return true;
            if (target < array[i][cols - 1]) {
                for (int j = 0; j < cols; j++) {
                    if (target == array[i][j])
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[1][1];
        arr[0][0] = 0;
        System.out.println(Find(12, arr));
    }
}
