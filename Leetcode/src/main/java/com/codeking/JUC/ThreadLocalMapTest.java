package com.codeking.JUC;

/**
 * @author CodeKing
 * @since 2023/4/20  21:27
 */
public class ThreadLocalMapTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 创建不同的线程
        Thread t1 = new Thread(() -> {
            ThreadLocal<Object> local = new ThreadLocal<>();
            local.set(new Account(100));
            Account account = (Account) local.get();
            System.out.println(account);
        }, "t1");
        Thread t2 = new Thread(() -> {
            ThreadLocal<Account> local = new ThreadLocal<>();
            local.set(new Account(20000));
            Account account = local.get();
            System.out.println(account);
        });
        t1.start();
        t2.start();

    }
}
