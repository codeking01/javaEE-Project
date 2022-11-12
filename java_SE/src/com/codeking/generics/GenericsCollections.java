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
 * <p>
 * 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
 * <p>
 * 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * <p>
 * 泛型类的构造器如下：public GenericClass(){}。而下面是错误的：public GenericClass(){}
 * <p>
 * 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 * <p>
 * 泛型不同的引用不能相互赋值。尽管在编译时ArrayList和ArrayList是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
 * <p>
 * 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。
 * 经验：泛型要使用一路都用。要不用，一路都不要用。
 * <p>
 * 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 * <p>
 * jdk1.7，泛型的简化操作：ArrayList flist = new ArrayList<>();
 * <p>
 * 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * <p>
 * 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
 * <p>
 * 异常类不能是泛型的
 * <p>
 * <p>
 * * 1.泛型在继承方面的体现
 * * 1.泛型在继承方面的体现
 * * 虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。
 * * 补充：类A是类B的父类，A<G> 是 B<G> 的父类
 * <p>
 * <p>
 * * 2.通配符的使用
 * 使用类型
 * 通配符：？
 * * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
 * <p>
 * 比如：List<?> ，Map<?,?>
 * List<?>是List、List等各种泛型List的父类。
 * 读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
 * <p>
 * 写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
 * <p>
 * 唯一的例外是null，它是所有类型的成员。
 * <p>
 * 将任意元素加入到其中不是类型安全的：
 * <p>
 * - Collection<?> c = new ArrayList();
 * - c.add(new Object()); // 编译时错误因为我们不知道c的元素类型，我们不能向其中添加对象。add方法有类型参数E作为集合的元素类型。我们传给add的任何参数都必须是一个未知类型的子类。因为我们不知道那是什么类型，所以我们无法传任何东西进去。
 * <p>
 * 另一方面，我们可以调用get()方法并使用其返回值。返回值是一个未知的类型，但是我们知道，它总是一个Object。
 * <p>
 * 有限制条件的通配符的使用
 * 说明：
 * <?>
 * 允许所有泛型的引用调用
 * 通配符指定上限上限
 * extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
 * 通配符指定下限
 * 下限super：使用时指定的类型不能小于操作的类，即>=
 * 举例：
 * <?extends Number> (无穷小, Number]
 * 只允许泛型为Number及Number子类的引用调用
 * <p>
 * <? super Number> [Number , 无穷大)
 * 只允许泛型为Number及Number父类的引用调用
 * <p>
 * <? extends Comparable>
 * 只允许泛型为实现Comparable接口的实现类的引用调用
 * ————————————————
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
