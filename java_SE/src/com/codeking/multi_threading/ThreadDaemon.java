package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/12 11:28
 */
public class ThreadDaemon implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("我是守护线程");
        }
    }

    public static void main(String[] args) {
        ThreadDaemon threadDaemon = new ThreadDaemon();
        Thread t = new Thread(threadDaemon);
        t.setDaemon(true);
        t.start();
        ThreadDaemon UserThread = new ThreadDaemon();
        new Thread(new UserThread()).start();
        /**
         * 当进程中不存在用户线程的时候 守护线程会自动销毁
         */
    }
}

class UserThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("活着**" + i);
        }
        System.out.println("我走了··");
    }
}
