package com.codeking.generics;

/**
 * @author : codeking
 * @date : 2022/11/10 15:44
 */
public class Order<T> extends Object {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private String name;
    private int age;
    T orderT;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderT=" + orderT +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public Order(String name, int age, T orderT) {
        this.name = name;
        this.age = age;
        this.orderT = orderT;
    }
}
