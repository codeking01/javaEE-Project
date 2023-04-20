package com.codeking.JUC;

/**
 * @author CodeKing
 * @since 2023/4/20  18:55
 */
public class ThreadSynchronized {
    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        Account account = new Account();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (account) {
                    // b的值增加
                    account.balance++;
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (account) {
                    // b的值减少
                    account.balance--;
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(account);
    }
}

class Account {
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public Account() {
    }
}

