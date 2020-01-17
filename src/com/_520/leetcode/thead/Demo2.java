package com._520.leetcode.thead;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 *  俩个线程，一个输出 1,2,3,4,5,6,7，另一个输出 A,B,C,D,E,F,G
 *  最后的效果：1,A,2,B,3,C,4,D,5,E,6,F,7,G
 *
 *  使用lockSuppert
 */
public class Demo2 {

    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        Thread t2 = null;
        Thread t1 = new Thread(() -> {

            for (char c : chars1) {
                LockSupport.park();
                System.out.print(c);
//                LockSupport.unpark(t2);
            }

        });

        t2 = new Thread(() -> {

            for (char c : chars2) {
                System.out.print(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });


        t2.start();
        t1.start();

    }
}
