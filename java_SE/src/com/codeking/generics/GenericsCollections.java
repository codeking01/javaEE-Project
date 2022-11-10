package com.codeking.generics;

import org.junit.Test;

import java.util.*;

/**
 * * 泛型的使用
 * * 1.jdk5.0新增的特征
 * *
 * * 2.在集合中使用泛型：
 * *  总结：
 * *  ①集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 * *  ②在实例化集合类时，可以指明具体的泛型类型
 * *  ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 * *    比如：add(E e)  --->实例化以后：add(Integer e)
 * *  ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 * *  ⑤如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 * @author : codeking
 * @date : 2022/11/10 13:08
 */
public class GenericsCollections {
    public static void main(String[] args) {
    }
    @Test
    public void arrayListTest() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(15);
        list1.add(20);
        list1.add((int) 's');
        for (Integer i : list1) {
            System.out.println("i:" + i);
        }
        // 用iterator去遍历
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator " + iterator.next().toString());
        }
    }

    @Test
    public void hashMapTest() {
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。在这指HashMap<>不需要指定泛型了
        Map<String, Integer> map1 = new HashMap<>(16);
        map1.put("key1", 12);
        map1.put("key2", 44);
        Set<Map.Entry<String, Integer>> set = map1.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator: " + iterator.next());
        }
    }
}
