package com.codeking.tests;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : codeking
 * @date : 2022/9/7 20:46
 */
public class Demo01Test {
    @Test
    public void intChange() {
        //定义基本数据类型
        int a = 1;
        System.out.println(a);
        // 将int基本数据类型转化为包装类
        // 自动装箱
        Integer a1 = a;
        // 自动拆箱
        Integer a2 = a1;
        System.out.println(a2);
        Integer a3 = new Integer(12);
        // 自动拆箱
        int a4 = a3;
        System.out.println(a4);
        // 转化为int转化为String类
        String a5 = String.valueOf(a4);
        System.out.println(a5);
        // String转化为基本数据类型 int
        int a6 = Integer.parseInt(a5);
        System.out.println(a6);
        //  先装箱，再转化为String
        Integer a7=a6;
        // 调用包装类的方法
        String a8=Integer.toString(a7);
        // 调用包装类对象的方法
        String a9=a7.toString();
        System.out.println(a8);
        System.out.println(a9);
        System.out.println("中文老夫大多数；康拉丁教父");
    }
}