package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/12 14:18
 * <p>
 * 模拟银行取钱问题,未加锁 会出现不安全的问题
 */
public class UnsafeExamples {
    public static void main(String[] args) {
        Account account = new Account(5000, 20221314);
        // 两个人去取钱
        Bank bank1 = new Bank(account, 4000, "李白");
        Bank bank2 = new Bank(account, 4000, "张飞");
        bank1.start();
        bank2.start();
    }
}

class Bank extends Thread {
    private Account account;
    private int count;
    private int balance;

    public Bank(Account account, int count, String name) {
        super(name);
        this.account = account;
        this.count = count;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (count - account.getMoney() > 0) {
                System.out.println("账户不够这多钱。" + Thread.currentThread().getName());
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(account.getMoney() - count);
            account.setMoney(account.getMoney() - count);
            System.out.println(Thread.currentThread().getName() + "正在取钱,取走了" + count + "，余额为：" + this.getBalance());
        }
    }
}

// 账户
class Account {
    private int money;
    private int id;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(int money, int id) {
        this.money = money;
        this.id = id;
    }
}