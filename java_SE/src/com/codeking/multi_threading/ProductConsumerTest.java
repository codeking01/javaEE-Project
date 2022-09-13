package com.codeking.multi_threading;

/**
 * @author : codeking
 * @date : 2022/9/12 21:22
 * <p>
 * 生产者消费者模式  PV
 */
public class ProductConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product p1 = new Product(clerk, "p1");
        Product p2 = new Product(clerk, "p2");
        Product p3 = new Product(clerk, "p3");
        Consumer c1 = new Consumer(clerk, "c1");
        Consumer c2 = new Consumer(clerk, "c2");
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Clerk {
    private int productNumber = 0;

    //生产产品
    public synchronized void productNumber() {
        if (productNumber < 10000) {
            productNumber++;
            System.out.println(Thread.currentThread().getName() + "在生产...，" + "productNumber=" + productNumber);
            // 唤醒消费者
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeNumber() {
        if (productNumber > 0) {
            productNumber--;
            System.out.println(Thread.currentThread().getName() + "在消费...，" + "productNumber=" + productNumber);
            //唤醒生产者
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 定义生产类
class Product implements Runnable {
    private Clerk clerk;
    private String name;

    public Product(Clerk clerk, String name) {
        this.name = name;
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始生产····");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productNumber();
        }
    }
}

// 消费类
class Consumer implements Runnable {
    private Clerk clerk;
    private String name;

    public Consumer(Clerk clerk, String name) {
        this.clerk = clerk;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("开始消费····");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeNumber();
        }

    }
}