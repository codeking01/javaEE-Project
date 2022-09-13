package com.codeking.multi_threading;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : codeking
 * @date : 2022/9/12 15:15
 */
public class UnsafeListTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            // 匿名对象+Lambda
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //Thread.sleep(1000);
        System.out.println(list.size());
    }
}
