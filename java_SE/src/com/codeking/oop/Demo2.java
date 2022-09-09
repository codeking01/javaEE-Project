package com.codeking.oop;

/**
 * @author : codeking
 * @date : 2022/9/5 11:48
 */
public class Demo2 {
    public Demo2(int age) {
        this();
        this.age = age;
    }

    public Demo2() {
        System.out.println("Testing Demo");
    }

    private int age;

    public int getAge() {
        return this.age;
    }

}
