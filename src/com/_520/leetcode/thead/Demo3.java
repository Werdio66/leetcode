package com._520.leetcode.thead;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  俩个线程，一个输出 1,2,3,4,5,6,7，另一个输出 A,B,C,D,E,F,G
 *  最后的效果：1,A,2,B,3,C,4,D,5,E,6,F,7,G
 *
 *  使用lockSuppert
 */
public class Demo3 {

    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();


        new Thread(() -> {
            lock.lock();
            for (char c : chars1) {
                try {
                    condition2.signal();
                    condition1.await();
                    System.out.print(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
            condition2.signal();
        }).start();

        new Thread(() -> {
            lock.lock();
            for (char c : chars2) {
                System.out.print(c);
                condition1.signal();
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
            condition1.signal();
        }).start();


    }
}
