package com._520.leetcode.demo;

import java.util.ArrayList;

/**
 *  和为 S 的连续序列
 */
public class Demo {
     public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();

         for (int i = 1; i < sum; i++) {
             int temp = 0;
             int j = i;

             while (temp < sum) {
                 temp += j;
                 j++;
             }

             if (temp == sum){
                 ArrayList<Integer> list = new ArrayList<>();
                 for (int k = i; k < j; k++) {
                     list.add(k);
                 }
                 result.add(list);
             }
         }
         return result;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }
}
