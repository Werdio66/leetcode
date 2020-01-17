package com._520.leetcode.thead;

import java.util.concurrent.CountDownLatch;

/**
 *  俩个线程，一个输出 1,2,3,4,5,6,7，另一个输出 A,B,C,D,E,F,G
 *  最后的效果：1,A,2,B,3,C,4,D,5,E,6,F,7,G
 *
 *  使用synchronized的wait和notify
 */
public class Demo1 {

    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object obj = new Object();

        Thread t1 = new Thread(() -> {

             try {
                    // 要想先输出字母，在开始时可以将这个线程栓在这
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            synchronized (obj){


                for (char c : chars1) {
                    System.out.print(c);
                     obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();

            }


        });

        Thread t2 = new Thread(() -> {

            synchronized (obj){
                for (char c : chars2) {
                    System.out.print(c);

                    countDownLatch.countDown();

                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                obj.notify();
            }
        });



        t1.start();
        t2.start();
    }
}
