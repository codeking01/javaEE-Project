package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/9 10:18
 *
 * 实现多个线程对象操作一个实现类对象
 * 模拟卖票问题 这个地方存在线程不安全的问题
 */
public class ThreadTest2 implements Runnable {
    private static  int tickets=50;
    @Override
    public void run() {
        while (true) {
            if (tickets<1) {
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("InterruptedException------");
            }
            System.out.println(Thread.currentThread().getName()+":-->"+ tickets-- + " is running");
        }
    }

    public static void main(String[] args) {
        ThreadTest2 RunnableTest = new ThreadTest2();
        Thread t1=new Thread(RunnableTest);
        Thread t2=new Thread(RunnableTest);
        Thread t3=new Thread(RunnableTest);
        t1.start();
        t2.start();
        t3.start();
    }
}
