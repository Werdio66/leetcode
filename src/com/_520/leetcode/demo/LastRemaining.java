package com._520.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining {

    private static int lastRemaining(int n, int m){
        if (n < 1){
            return -1;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1){

            for (int i = 0; i < m; i++) {

                if (count > list.size()){
                    count = 0;
                }

                 count ++;
            }
            list.remove(count);
            count--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(6, 7));
    }
}
