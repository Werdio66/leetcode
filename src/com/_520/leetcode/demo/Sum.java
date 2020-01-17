package com._520.leetcode.demo;

public class Sum {

    private static void sum(int n){
        int sum = (int) (Math.pow(n, 2) + n);
        System.out.println(sum >> 1);
    }

    private static int addTwoNum(int m, int n){

        do {
            int sum1 = m ^ n;
            int sum2 = (m & n) << 1;
            m = sum1;
            n = sum2;
        }while (n != 0);
        return m;
    }

    public static void main(String[] args) {
//        sum(1);
        System.out.println(addTwoNum(3, 1));
    }
}
