package com.codeking.oop;

/**
 * @author : codeking
 * @dates : 2022/9/3 20:31
 */
public class Application {
    {
        //  匿名代码快
        System.out.println("匿名代码！");
    }
    static {
        System.out.println("静态代码块！");
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01("张三");
        System.out.println("-------------------");
        Student tom = new Student();
        Student Jack = new Student("lisa");
        System.out.println("-------------------");
        B b = new A();
        b.test();
        System.out.println("-------------------");
        // 开始测试instanceof
        B b2 = new B();
        System.out.println(b2 instanceof A);
    }
}
