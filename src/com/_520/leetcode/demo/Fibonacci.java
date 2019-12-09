package com._520.leetcode.demo;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer,Integer> map = new HashMap<>();
    private static int fibonacci(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (map.containsKey(n)){
            return map.get(n);
        }else {
            int value = fibonacci(n - 1) + fibonacci(n - 2);
            map.put(n,value);
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(9));
    }
}
