package com.codeking.assemblages;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Set接口是Collection的子接口，set接口没有提供额外的方法
 * Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set 集合中，则添加操作失败。
 * Set 判断两个对象是否相同不是使用==运算符，而是根据equals()方法
 * 1.Set接口的框架：
 * * |----Collection接口：单列集合，用来存储一个一个的对象
 * * |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 * * |----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 * * |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 * * 对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
 * * |----TreeSet：可以按照添加对象的指定属性，进行排序。
 * * <p>
 * * 一、Set:存储无序的、不可重复的数据
 * * 1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
 * *<p>
 * * 2.不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。
 * * <p>
 * 二、添加元素的过程：以HashSet为例：
 * *      我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
 * *      此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
 * *      数组此位置上是否已经有元素：
 * *          如果此位置上没有其他元素，则元素a添加成功。 --->情况1
 * *          如果此位置上有其他元素b(或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
 * *              如果hash值不相同，则元素a添加成功。--->情况2
 * *              如果hash值相同，进而需要调用元素a所在类的equals()方法：
 * *                    equals()返回true,元素a添加失败
 * *                    equals()返回false,则元素a添加成功。--->情况2
 * *
 * *      对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
 * *      jdk 7 :元素a放到数组中，指向原来的元素。
 * *      jdk 8 :原来的元素在数组中，指向元素a
 * *      总结：七上八下
 * *
 * * HashSet底层：数组+链表的结构。
 * <p>
 * LinkedHashSet的使用
 * LinkedHashSet是HashSet的子类
 * LinkedHashSet根据元素的hashCode值来决定元素的存储位置，但它同时使用双向链表维护元素的次序，这使得元素看起来是以插入顺序保存的。
 * LinkedHashSet插入性能略低于HashSet，但在迭代访问Set 里的全部元素时有很好的性能。
 * LinkedHashSet不允许集合元素重复。
 * /**
 * * LinkedHashSet的使用（双向链表）
 * * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个
 * * 数据和后一个数据。
 * * 优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *
 * * TreeSet的自然排序
 * TreeSet是SortedSet接口的实现类，TreeSet可以确保集合元素处于排序状态。
 * TreeSet底层使用红黑树结构存储数据
 *TreeSet两种排序方法：自然排序和定制排序。默认情况下，TreeSet采用自然排序。
 * TreeSet和后面要讲的TreeMap采用红黑树的存储结构
 * 特点：有序，查询速度比List快
 * 自然排序：TreeSet会调用集合元素的compareTo(Object obj)方法来比较元素之间的大小关系，然后将集合元素按升序(默认情况)排列。
 *
 * @author : codeking
 * @date : 2022/11/5 21:13
 */

public class Set {
    class User {
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;

            if (age != user.age) {
                return false;
            }
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }


        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        String name;
        int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Test
    public void testSet() {
        java.util.Set set = new HashSet();
        set.add(123);
        set.add("444");
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}