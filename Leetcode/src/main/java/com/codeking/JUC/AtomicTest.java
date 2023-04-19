package com.codeking.JUC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author CodeKing
 * @since 2023/4/11  11:57
 */
public class AtomicTest {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****");
        AtomicCas();
        System.out.println("*****");
        //MultithreadingTest();
        System.out.println("*****");
        MultithreadingTest2();
        System.out.println("*****");
        StringBufferTest();
    }

    // 测试 StringBuffer
    private static void StringBufferTest() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sb.append("a");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sb.append("b");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("sb = " + sb.length());
    }

    private static void AtomicCas() throws InterruptedException {
        // 创建多线程去测试
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                count.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                count.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }

    // 普通多线程测试,数据量大的时候，还有可能出错
    public static void MultithreadingTest() throws InterruptedException {
        // 新建 LinkedList
        ArrayList<Integer> list = new ArrayList<>();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("list = " + list.size());
    }
    // 加锁的
    public static void MultithreadingTest2() throws InterruptedException {
        // 新建 LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (list) {
                    list.add(i);
                }
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (list) {
                    list.add(i);
                }
            }
        });
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("list = " + list.size());
    }
}
