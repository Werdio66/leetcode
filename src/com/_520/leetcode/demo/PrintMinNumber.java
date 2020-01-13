package com._520.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中组合结果最小的
 */
public class PrintMinNumber {

    private String getMinNumber(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }

        list.sort(((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return Integer.valueOf(s1) - Integer.valueOf(s2);
        }));


        StringBuilder sb = new StringBuilder();
        for (int num : list){
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().getMinNumber(new int[]{1, 12, 11, 33, 42, 222, 221, 23}));
    }
}
