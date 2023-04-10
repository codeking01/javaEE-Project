package com.codeking.DataStructure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CodeKing
 * @since 2023/4/10  20:08
 */
public class HashMapTest {
    public static void main(String[] args) {
        // 查看扩容问题，起始16,负载因子为0.75f
        HashMapExpansion();
        // 查看 ==存在的问题
        StringTest();
    }

    // 测试扩容
    public static void HashMapExpansion() {
        HashMap<String, Integer> map = new HashMap();
        System.out.println("map:" + map.size());
        map.put("a", 1);
        System.out.println("capacity:" + capacity(map) + " map:" + map.size());
        System.out.println("****");
    }

    // 查看容量大小
    public static <T> int capacity(Map a) {
        Class<? extends Map> mapType = a.getClass();
        Method capacity = null;
        try {
            capacity = mapType.getDeclaredMethod("capacity");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        capacity.setAccessible(true);
        try {
            return (int) capacity.invoke(a);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    // 模拟String中的-127~128存在的缓存问题
    public static void StringTest() {
        String s = "1";
        String s2 = new String();
        s2 = "1";
        System.out.println(s == s2); //true
        new String("5");
        String a=new String("5");
        String b=new String("5");
        System.out.println("a==b "+a==b); //false
    }
}
