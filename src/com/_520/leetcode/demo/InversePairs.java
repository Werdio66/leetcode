package com._520.leetcode.demo;

/**
 *  在数组中的两个数字，如果前面一个数字大于后面的数字，
 *  则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 *  并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {

    private Integer inverseParis(int[] array){
        int sum = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        return sum % 1000000007;
    }

    private Integer inverseParis1(int[] array){
        mergeCaculation(array, 0, array.length - 1);
        return count;
    }

    private Integer count = 0;
    private void mergeCaculation(int[] array, int begin, int end) {
        if (begin >= end){
            return;
        }
        int mid = (end - begin) >> 2;

        mergeCaculation(array, begin,mid - 1);

        mergeCaculation(array, mid, end);

        count += merge(array, begin, mid, end);
    }

    private Integer merge(int[] array, int begin, int mid, int end) {
        int sum = 0;

        while (begin < mid && mid + 1 < end){
            sum += array[begin++] > array[++mid] ? 1 : 0;
        }

        if (begin < mid){
            sum += mid - begin;
        }

        if (mid < end){
            sum += end - mid;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new InversePairs().inverseParis(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }
}
