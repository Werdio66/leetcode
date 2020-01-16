package com._520.leetcode.demo;

import java.util.TreeSet;

public class IsContinuous {

    private static boolean isContinuous(int [] numbers){
        TreeSet<Integer> treeSet = new TreeSet<>();

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                count++;
            }else {
                treeSet.add(numbers[i]);
            }
        }
        if (count >= 4){
            return true;
        }

        if (treeSet.size() + count < 5){
            return false;
        }

        return treeSet.last() - treeSet.first() == 4;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 5};
        System.out.println(isContinuous(arr));
    }
}
