package com._520.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Integer remove = list.remove(0);
            System.out.println(remove);
        }
    }
}
