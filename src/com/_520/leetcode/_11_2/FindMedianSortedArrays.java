package com._520.leetcode._11_2;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *45678      3579
 * 45 35     678 79
 *
 * 12345        6789
 *
 * 12 67        345 89
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//        if (nums1 != null && nums2 == null){
//            int len = nums1.length;
//            return len % 2 == 0 ? (nums1[len / 2] + nums1[len / 2 - 1]) / 2.0 : nums1[len / 2];
//        }
//        if (nums2 != null && nums1 == null){
//            int len = nums2.length;
//            return len % 2 == 0 ? (nums2[len / 2] + nums2[len / 2 - 1]) / 2.0 : nums2[len / 2];
//        }

        if (nums1.length == 1 && nums2.length == 1){
            return (nums1[0] + nums2[0]) / 2;
        }


        int length1 = nums1.length;
        int length2 = nums2.length;

        // 保证左边比右边大
        if (length1 > length2){
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int t = length1; length1 = length2; length2 = t;
        }

        /*
         12345        6789
         123         45
         6         789
         */
        /*
            i 表示数组1的分割点
            j 表示数组2的分割点    j = (length1 + length2) / 2 - i
            条件1：i + j = length1 - i + length2 - j       i + j = length1 - i + length2 - j + 1 (一奇一偶)
            条件2：数组1[i - 1] <= 数组2[j] && 数组2[j - 1] <= 数组1[i]
         */
        int iMin = 0, iMax = length1;
        System.out.println("num1 = " + Arrays.toString(nums1));
        System.out.println("num2 = " + Arrays.toString(nums2));
        System.out.println("len1 = " + length1 + " len2 = " + length2);
        while (iMin <= iMax){
            int i = (iMax + iMin) / 2;
            // 如果length1 + length2是奇数，保证分好的数组，右边大于左边
            int j = (length1 + length2) / 2 - i;

            System.out.println("i = " + i + " j = " + j);

            if (i < iMax && nums1[i - 1] > nums2[j]){// 数组1中的元素太大，i要变小
                iMax = i - 1;
            }else if (i < iMax && nums2[j - 1] > nums1[i]){// 数组2中的元素太大,i需要变大
                iMin = i - 1;
            }else {
                System.out.println("----");
                // 计算左边最大的数
                int maxleft = 0;

                if (i == 0)   // 数组1中的数都比数组2大
                    maxleft = nums2[j - 1];
                 else if (j == 0)   // 数组2中的数都比数组1大
                    maxleft = nums1[i - 1];
                else
                    maxleft = Math.max(nums1[i - 1], nums2[j - 1]);

                // 计算右边最小的数
                int minRight = 0;
                if (j == length2)
                    minRight = nums1[i];
                else if (i == length1)
                    minRight = nums2[j];
                else minRight = Math.min(nums1[i], nums2[j]);
                System.out.println("maxleft = " + maxleft + " minRight = " + minRight);
                if ((length1 + length2) % 2 != 0)
                    return minRight;
                else
                    return (maxleft + minRight) / 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        int[] nums2 = {1,4,7,9,11,13};
        int[] nums1 = {1,3,5,7};

        System.out.println(f.findMedianSortedArrays(nums1, nums2));
    }
}
