package com._520.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

public class Ddemo2 {
    public static List<Integer> FindNumbersWithSum(int [] array, int sum) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] + array[j] == sum){
                    int sum1 = array[i] * array[j];
                    if (sum1 < min){
                        list.clear();
                        list.add(array[i]);
                        list.add(array[j]);
                        min = sum1;
                    }
                }

                if (array[i] + array[j] > sum){
                    break;
                }

            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14};
        System.out.println(FindNumbersWithSum(arr, 10));
    }
}
