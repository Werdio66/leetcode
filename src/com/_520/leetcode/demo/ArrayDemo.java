package com._520.leetcode.demo;

import java.util.Arrays;

/**
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class ArrayDemo {
    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if (length == 0)
            return 0;
        int index = 0;
        for (int j = length - 1; j >= 0; ){
            if (array[j] <= array[0])
                j--;
            else{
                index = j + 1;
                break;
            }
        }
        return array[index];
    }

    public static void reOrderArray(int [] array) {

        int jishu = 0;
        int oushu = 0;
        // 1,2,3,4,5,6,7,8,9
        while (jishu < array.length && oushu < array.length){
            while (jishu < array.length && array[jishu] % 2 != 0)
                jishu++;
            oushu = jishu;
            while (oushu < array.length &&array[oushu] % 2 == 0)
                oushu++;
            swap(array,jishu,oushu);

        }

    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3};
        int[] array = {1,2,3,4,5,6,7,8,9};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
//        System.out.println(minNumberInRotateArray(arr));
    }
}
