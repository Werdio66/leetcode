package com._520.leetcode.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  查找出现一次的俩个数
 */
public class FindOnceNumber {
     public static void FindNumsAppearOnce(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            if (map.containsKey(array[left])){
                map.remove(array[left]);
                left++;
            }else {
                map.put(array[left], array[left]);
                left++;
            }

            if (map.containsKey(array[right])){
                map.remove(array[right]);
                right--;
            }else {
                map.put(array[right], array[right]);
                right--;
            }
        }
        int[] arr = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr[i++] = entry.getKey();
        }

    }

    public static void findNumsAppearOnce1(int [] array) {
        int[] count = new int[1000];
        for (int i : array) {
            count[i]++;
        }

        int[] arr = new int[2];
        int j = 0;
        for (int i : array){
            if (count[i] == 1){
                arr[j++] = i;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
         int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        FindNumsAppearOnce(arr);
        findNumsAppearOnce1(arr);
    }
}
