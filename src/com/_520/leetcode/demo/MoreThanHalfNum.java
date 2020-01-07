package com._520.leetcode.demo;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i], 1);
            }else {

                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > array.length / 2)
                return entry.getKey();
        }

        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum m = new MoreThanHalfNum();
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4};
        System.out.println(m.MoreThanHalfNum_Solution(arr));
    }
}
