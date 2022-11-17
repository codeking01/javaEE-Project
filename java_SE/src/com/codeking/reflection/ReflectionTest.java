package com.codeking.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;


/**
 * @author : codeking
 * @date : 2022/11/13 15:16
 */

/**
 * newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。
 * <p>
 * 要想此方法正常创建运行时类的对象，要求：
 * 1.运行时类必须提供空参的构造器
 * 2.空参的构造器的访问权限得够。通常，设置为public。
 * <p>
 * 在javabean中要求提供一个public的空参构造器。原因：
 * 1.便于通过反射，创建运行时类的对象
 * 2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
 */

public class ReflectionTest {
    @Test
    public void testReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 通过反射去操作，可以加上泛型
        Class<Person> clazz = Person.class;
        //1.通过反射，创建Person类的对象
        // 调用它无参的构造器
        Constructor<Person> cons = clazz.getConstructor();
        Object o = cons.newInstance();
        // 向下转型
        Person p = (Person) o;
        System.out.println("无参构造器" + p.toString());
        // 调用有参构造器
        Constructor cons2 = clazz.getConstructor(String.class, int.class);
        Object o2 = cons2.newInstance("张三", 18);
        Person p2 = (Person) o2;
        System.out.println("有参构造器 " + p2.toString());
        // 调用私有属性
        Field age = clazz.getDeclaredField("age");
        // 设置可以修改
        age.setAccessible(true);
        age.set(p2, 55);
        System.out.println("有参构造器 " + p2.toString());
        // 调用私有方法
        Method showMethod = clazz.getDeclaredMethod("show", String.class);
        showMethod.setAccessible(true);
        String nation = (String) showMethod.invoke(p2, "好多喷子啊！");
        System.out.println("nation" + nation);
        /**
         * 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
         * 建议：直接new的方式。
         * 什么时候会使用：反射的方式。 反射的特征：动态性
         * 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
         * 不矛盾。
         */

    }

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.codeking.reflection.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}

class Person {
    public String name;
    private int age;

    private String show(String nation) {
        System.out.println("我是私有方法！" + nation);
        return nation;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}