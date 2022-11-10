package com.codeking.assemblages;

import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 一、Map的实现类的结构：
 * |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 * |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 * |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 * ---------原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 * ---------对于频繁的遍历操作，此类执行效率高于HashMap。
 * |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 * -----------底层使用红黑树
 * |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 * |----Properties:常用来处理配置文件。key和value都是String类型
 * <p>
 * <p>
 * HashMap的底层：数组+链表  （jdk7及之前）
 * 数组+链表+红黑树 （jdk 8）
 * <p>
 * 面试题：
 * 1. HashMap的底层实现原理？
 * 2. HashMap 和 Hashtable的异同？
 * 3. CurrentHashMap 与 Hashtable的异同？（暂时不讲）
 * 上面已经知道HashMap是线程不安全的了，后来在jdk1.5的时候就出来了CurrentHashMap来弥补HashMap的线程不安全的特性；
 * CurrentHashMap，是将HashMap分成了很多个片（一般默认是16片），引入了分段锁的概念，然后对每一片加锁，
 * 具体可以理解成一把大的Map分解成N个小的HashTable，根据key.hashCode（）来决定放到哪一个片上；
 * --由于安全机制的原因，HashMap的效率比HashTable，CurrentHashMap的效率高；
 * 但是由于CurrentHashMap加锁的高效性,HashTable是整个加锁，他的效率比HashTable高；
 * 总的来说 HashMap>CurrentHashMap>HashTable;
 *
 * @author : codeking
 * @date : 2022/11/7 16:34
 */
public class MapTest {
    @Test
    public void HashmapTest(){
        HashMap map1=new HashMap();
        map1.put("key1", "value1");
        map1.put("5", "value1");
        map1.put("6", "value1");
        System.out.println(map1);
    }

    @Test
    public void TreeMapTest(){
        // 默认会排序
        TreeMap map1=new TreeMap();
        map1.put("key1", "value1");
        map1.put("5", "value1");
        map1.put("6", "value1");
        System.out.println(map1);

    }

}
