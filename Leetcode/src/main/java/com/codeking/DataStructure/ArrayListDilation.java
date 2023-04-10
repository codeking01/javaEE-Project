package com.codeking.DataStructure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author CodeKing
 * @since 2023/4/10  10:03
 * 扩容 ArrayList 1.5倍
 * 1）add方法：
 * 初始化为0
 * add后，变成10
 * 超过10，扩容为1.5倍（通过移位去实现的，x+x>>1）
 * 10--》15
 * 2）addAll方法：
 * 初始化为0
 * 执行  Math.max(DEFAULT_CAPACITY, minCapacity);
 * 取出一个最大值
 * addAll(1,2)后，变成2
 * *
 * 扩容 Vector 2倍
 */

public class ArrayListDilation {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 查看实际容量大小
        System.out.println("arrayList = " + arrayList.size());
        arrayList.add(new Integer(1));
        System.out.println("arrayList = " + arrayList.size());
        System.out.println("add方法扩容");
        System.out.println("arrayList = " + getSize(arrayList));
        //  添加十个元素
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Integer(i));
        }
        System.out.println("arrayList = " + getSize(arrayList));
        System.out.println("addAll方法扩容");
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        System.out.println("arrayList1 = " + getSize(arrayList1));
        ArrayList<Integer> arrayList1Copy = (ArrayList<Integer>) arrayList1.clone();
        arrayList.add(new Integer(10));
        arrayList1.addAll(arrayList);
        System.out.println("arrayList1 = " + getSize(arrayList1));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer(10));
        arrayList1Copy.addAll(list);
        System.out.println("arrayList1Copy = " + getSize(arrayList1Copy));
        System.out.println("**Vector**");
        Vector<Integer> vector = new Vector<>();
        vector.add(new Integer(10));
        vector.add(new Integer(20));
        vector.add(new Integer(30));
        System.out.println("vector = " + getVectorSize(vector));
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        vector.addAll(arrayList);
        System.out.println("vector addAll= " + getVectorSize(vector));

    }

    private static int getSize(ArrayList<Integer> list) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 查看实际容量大小

        //获取Class对象
        Class c = Class.forName("java.util.ArrayList");
        //映射Class对象c所表示类(即Arraylist)的属性
        Field field = c.getDeclaredField("elementData");
        //设置访问状态表示为true
        field.setAccessible(true);
        //返回指定对象上此 Field 表示的字段的值
        Object[] object = (Object[]) field.get(list);
        return object.length;
    }

    private static int getVectorSize(Vector<Integer> list) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 查看实际容量大小

        //获取Class对象
        Class c = Class.forName("java.util.Vector");
        //映射Class对象c所表示类(即Arraylist)的属性
        Field field = c.getDeclaredField("elementData");
        //设置访问状态表示为true
        field.setAccessible(true);
        //返回指定对象上此 Field 表示的字段的值
        Object[] object = (Object[]) field.get(list);
        return object.length;
    }
}
