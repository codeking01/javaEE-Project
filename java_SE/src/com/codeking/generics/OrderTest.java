package com.codeking.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : codeking
 * @date : 2022/11/10 15:50
 */
public class OrderTest<T> {
    @Test
    public void testOrder() {
        // 结合匿名内部类使用
        Order<HashMap<String, Integer>> order = new Order<>("张三", 18, new HashMap<String, Integer>() {{
            put("s", 18);
        }});
        //order.setAge(18);
        //order.setOrderT("s");
        //order.setOrderT("t");
        System.out.println("order1: " + order);
    }


    @Test
    public void testSubOrder() {
        subOrder subOrder1 = new subOrder();
        //subOrder1.setOrderT("s");
        subOrder1.setOrderT((Integer) 15);
        System.out.println("subOrder1: " + subOrder1);
    }

    @Test
    public void testSubOrder2() {
        subOrder<String> subOrder1 = new subOrder<>();
        subOrder1.setOrderT("哈哈哈");
        System.out.println("subOrder1: " + subOrder1);
    }

    @Test
    public void testSubOrder3(){
        subOrder<String> Order1 = new subOrder<>();
        Integer[] arr= new Integer[]{1,2,3,4,5,6,7,8,9};
        // 会提示： 不应该通过类实例访问静态成员
        //List<Integer> list = Order1.copyArrayList(arr);
        //System.out.println(list);
    }
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E item : arr) {
            list.add(item);
        }
        return list;
    }
}