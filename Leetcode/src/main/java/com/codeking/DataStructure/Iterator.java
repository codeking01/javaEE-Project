package com.codeking.DataStructure;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author CodeKing
 * @since 2023/4/10  19:20
 */
public class Iterator {
    public static void main(String[] args) throws InterruptedException {
        //testArrayList();
        //testArrayListFailFast();
        CopyOnWriteArrayListTest();
    }

    // ArrayList 线程不安全
    public static void testArrayList() throws InterruptedException {
        // 创建两个线程去读写
        ArrayList<Integer> arrayList = new ArrayList<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                // 加锁，保证安全
                synchronized (arrayList) {
                    arrayList.add(i);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (arrayList) {
                    arrayList.add(i);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("arrayList = " + arrayList);
        System.out.println("arrayList.size = " + arrayList.size());
    }

    // 测试ArrayList读写的Fail-Fast
    public static void testArrayListFailFast() {
        // 添加20个元素
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        // debug的方式去模拟
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    // 测试 CopyOnWriteArrayList 这个是复制了一份去遍历的
    public static void CopyOnWriteArrayListTest() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i);
        }
        for (Integer i : copyOnWriteArrayList) {
            System.out.println("i = " + i);
        }
    }
}
