package com.codeking.assemblages;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Vector;

/**
 * @author : codeking
 * @date : 2022/11/5 16:36
 * <p>
 * /**
 * 1. List接口框架
 * <p>
 * |----Collection接口：单列集合，用来存储一个一个的对象
 * |----List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原有的数组
 * |----ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 * |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 * |----vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 * <p>
 * <p>
 * 面试题：比较ArrayList、LinkedList、Vector三者的异同？
 * 同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 * 不同：见上
 */
public class Demo2 {
    @Test
    public  void testLinkList(){
        LinkedList list1=new LinkedList();
        list1.add(1);
        System.out.println(list1);
        list1.add(2);
        System.out.println("list1: " + list1);
        list1.add(0,5);
        System.out.println(list1);
    }


    @Test
    public void testVector(){
        Vector list1 = new Vector();
        list1.add(0,5);
        System.out.println(list1);
    }
}
