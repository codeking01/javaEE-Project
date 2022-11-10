package com.codeking.assemblages;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 一、集合的框架
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 * 说明；此时的存储，主要是指能存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi,数据库中）
 * <p>
 * 2.1数组在存储多个数据封面的特点：
 * 》一旦初始化以后，它的长度就确定了。
 * 》数组一旦定义好，它的数据类型也就确定了。我们就只能操作指定类型的数据了。
 * 比如：String[] arr;int[] str;
 * 2.2数组在存储多个数据方面的特点：
 * 》一旦初始化以后，其长度就不可修改。
 * 》数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 * 》获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 * 》数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 * 二、集合框架
 * &---Collection接口：单列集合，用来存储一个一个的对象
 * &---List接口：存储有序的、可重复的数据。  -->“动态”数组
 * &---ArrayList、LinkedList、Vector
 * <p>
 * &---Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 * &---HashSet、LinkedHashSet、TreeSet
 * <p>
 * &---Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 * *          &---HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * @author : codeking
 * @date : 2022/11/5 15:11
 */
public class Demo1 {
    public static void main(String[] args) {
        testCollection();
    }
    static void testCollection() {
        Collection<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(5);
        System.out.println(list1);
        Collection list2 = new ArrayList();
        list2.addAll(list1);
        boolean result = list2.contains(1);
        System.out.println("result = " + result);
        System.out.println("list2: " + list2);
        Collection coll1 = Arrays.asList("测试", "加油");
        System.out.println("coll1 " + coll1);
    }

    @Test
    public void TestCollection() {
        Collection<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(5);
        System.out.println(list1);
        Collection list2 = new ArrayList();
        list2.addAll(list1);
        boolean result = list2.contains(1);
        System.out.println("result = " + result);
        System.out.println("list2: " + list2);
        Collection coll1 = Arrays.asList("测试", "加油");
        System.out.println("coll1 " + coll1);
        //System.out.println(iterator.next());
        for (Object o : coll1) {
            System.out.println(o);
        }
    }
}

