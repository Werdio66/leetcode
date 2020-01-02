package com._520.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *  使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *  并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Demo4 {

    private void reOrderArray(int[] array){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0){
                list2.add(num);
            }else {
                list1.add(num);
            }
        }
        list1.addAll(list2);

        Integer[] arr = (Integer[]) list1.toArray();

    }

    private void reOrderArray1(int[] array){

        int length = array.length;
        int i = 0;
        while (i < length) {
            // 找到第一个偶数
            while (array[i] % 2 != 0) {
                if (i == length - 1)
                    return;
                i++;
            }
            // 找到第一个奇数
            int j = i + 1;
            while (array[j] % 2 == 0){
                if (j == length - 1)
                    return;
                j++;
            }
            // 记录奇数的值
            int temp = array[j];
            // 所有的数都后移
            while (j > i){
                array[j] = array[j - 1];
                j--;
            }
            // 将奇数换到前面
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 5, 2, 4, 7};
        System.out.println(Arrays.toString(array));
        new Demo4().reOrderArray1(array);
        System.out.println(Arrays.toString(array));
    }
}
