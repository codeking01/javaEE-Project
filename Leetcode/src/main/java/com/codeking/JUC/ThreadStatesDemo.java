package com.codeking.JUC;

import java.security.PublicKey;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CodeKing
 * @since 2023/4/20  15:39
 */
public class ThreadStatesDemo {
    public static void main(String[] args) {
        stateTest1();
    }

    // 查看线程状态
    public static void stateTest1() {
        // 获取锁
        final Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getState() + "获取锁");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getState() + "获取锁");
                lock.notify();
            }
        }, "t2");
        t2.start();
    }
}
