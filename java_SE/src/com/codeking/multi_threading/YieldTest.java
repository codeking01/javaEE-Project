package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/9 21:40
 * <p>
 * 线程礼让 yield ()
 */
public class YieldTest implements Runnable {
    String name;

    public YieldTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("YieldTest开始--> " + name + "**");
        Thread.yield();
        System.out.println("YieldTest结束--> " + name + "**");
    }

    public static void main(String[] args) {
        YieldTest test = new YieldTest("李白");
        YieldTest test2 = new YieldTest("张飞");
        // 创建线程对象
        Thread t = new Thread(test);
        Thread t2 = new Thread(test2);
        // 设置 优先级
        t.setPriority(4);
        t2.setPriority(Thread.MAX_PRIORITY);
        t.start();
        t2.start();
    }
}
