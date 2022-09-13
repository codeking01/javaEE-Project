package com.codeking.multi_threading;

import java.util.Objects;

/**
 * @author : codeking
 * @date : 2022/9/9 20:45
 */
public class JoinTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("MyThread的线程状态："+Thread.currentThread().getState());
            System.out.println("Join进来的插队线程-->" + i + "..." + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest test = new JoinTest();
        Thread MyThread = new Thread(test);
        MyThread.start();
        System.out.println("MyThread的线程状态："+MyThread.getState());
        for (int i = 0; i < 300; i++) {
            //System.out.println("主线程开始-->" + i + "..." + Thread.currentThread().getName());
            // 当获取到的线程是主线程的时候礼让一下  子线程权限好像抢不过主线程
            if (Objects.equals(Thread.currentThread().getName(), "main")) {
                System.out.println("当前是主线程--->" + Thread.currentThread().getName());
                System.out.println("开始礼让，重新抢占线程..");
                System.out.println("这次抢到的线程是-->" + Thread.currentThread().getName());
            }
            if (i == 100) {
                MyThread.join();
            }
            // 查看线程状态
            System.out.println("MyThread的线程状态："+MyThread.getState());
        }
    }
}
