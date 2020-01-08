package com._520.leetcode.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<>();
        for (int n = 0; n < k; n++){
            list.add(input[n]);
        }
        return list;
    }
}
