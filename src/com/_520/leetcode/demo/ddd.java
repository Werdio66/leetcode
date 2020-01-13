package com._520.leetcode.demo;

import java.util.Arrays;

public class ddd {

     public static int GetNumberOfK(int [] array , int k) {

        int left = 0;
        int right = array.length - 1;
        int count = 0;
        int index;
        if (array[left] > k || k > array[right]){
            return 0;
        }
        while (left < right){
            int mid = (right + left) >> 1;
            if (k > array[mid]){
                left = mid;
            }else if (k < array[mid]){
                right = mid;
            }else {
                index = mid;
                while (index + 1 <= right && array[index + 1] == k){
                    count++;
                    index++;
                }
                index = mid;
                while (index >= 0 && array[index] == k){
                    count++;
                    index--;
                }
                return count;
            }
        }
        return count;
    }

    public static int GetNumberOfK1(int [] array , int k) {
        int count = 0;
        int index = Arrays.binarySearch(array, k);
        if (index < 0){
            return 0;
        }
        for (int i = index; i < array.length; i++) {
            if (array[i] == k){
                count++;
            }else {
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (array[i] == k){
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3};
        System.out.println(GetNumberOfK(array, 6));
    }
}
