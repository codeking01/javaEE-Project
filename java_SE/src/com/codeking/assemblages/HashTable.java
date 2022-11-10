package com.codeking.assemblages;

/**
 *
 * Hashtable是个古老的Map 实现类，JDK1.0就提供了。不同于HashMap，Hashtable是线程安全的。
 * Hashtable实现原理和HashMap相同，功能相同。底层都使用哈希表结构，查询速度快，很多情况下可以互用。
 * 与HashMap不同，Hashtable不允许使用null 作为key和value
 * 与HashMap一样，Hashtable也不能保证其中Key-Value 对的顺序
 * Hashtable判断两个key相等、两个value相等的标准，与HashMap一致。
 *
 * --Properties 类是Hashtable的子类，该对象用于处理属性文件
 * 由于属性文件里的key、value都是字符串类型，所以**Properties 里的key和value都是字符串类型**
 * 存取数据时，建议使用setProperty(String key,Stringvalue)方法和getProperty(String key)方法
 *
 * @author : codeking
 * @date : 2022/11/9 18:56
 */
public class HashTable {
}
