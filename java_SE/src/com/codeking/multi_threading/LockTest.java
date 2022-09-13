package com.codeking.multi_threading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : codeking
 * @date : 2022/9/12 16:43
 * <p>
 * 显示锁 Lock  加上ReentrantLock类的
 */
public class LockTest implements Runnable {
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(lockTest, "window01");
        Thread t2 = new Thread(lockTest, "window02");
        Thread t3 = new Thread(lockTest, "window03");
        t1.start();
        t2.start();
        t3.start();
    }

    private int tickets = 2000;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // 还是卖票问题
        try {
            while (tickets > 0) {
                // 加锁
                lock.lock();
                System.out.println("正在卖票，当前票数" + tickets);
                tickets--;
            }
            System.out.println("卖票结束！");
        } finally {
            // 解锁
            lock.unlock();
        }

    }
}