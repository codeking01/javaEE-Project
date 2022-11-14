package com.codeking.reflection;

import org.jetbrains.annotations.NotNull;

/**
 * @author : codeking
 * @date : 2022/11/14 18:33
 */

@MyAnnotation(value = "我是User")
public class User extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    @MyAnnotation(value = "我是show方法...")
    public String show(String nation){
        System.out.println("我是来自 "+nation);
        return nation;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @MyAnnotation(value="c++")
    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public User() {
    }

    @Override
    public int compareTo(@NotNull String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("实现的MyInterface的info方法！");
    }
}
