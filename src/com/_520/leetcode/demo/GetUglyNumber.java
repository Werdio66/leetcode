package com._520.leetcode.demo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetUglyNumber {

    private int getUglyNumber(int index){
        if (index <= 0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < index; i++) {
            int num1 = result[p2] * 2;
            int num2 = result[p3] * 3;
            int num3 = result[p5] * 5;
            result[i] = Math.min(num1, Math.min(num2, num3));

            if (result[i] == result[p2] * 2){
                p2++;
            }
            if (result[i] == result[p3] * 3){
                p3++;
            }
            if (result[i] == result[p5] * 5){
                p5++;
            }
        }

        return result[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().getUglyNumber(4));
    }
}
