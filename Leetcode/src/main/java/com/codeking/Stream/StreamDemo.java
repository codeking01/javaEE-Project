package com.codeking.Stream;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author CodeKing
 * @since 2023/4/19  15:29
 */
public class StreamDemo {
    public static void main(String[] args) {
        streamtest();
        streamtest2();
    }

    // 结合foreach
    public static void streamtest() {
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.forEach(System.out::println);
    }

    // 结合Collector
    public static void streamtest2() {
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-----------------");
        // 设置一个HashMap去接受这个学生
        HashMap<String, Student> map = new HashMap<>();
        map.put("1", new Student("1", 1));
        map.put("2", new Student("2", 2));
        map.put("3", new Student("3", 3));
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v.getName());
        });
        System.out.println("-----------------");
        // 转成流，并添加一个属性
        List<String> list = map.entrySet().stream().map(item -> item.getKey() + ":" + item.getValue().getName() + "time：" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))).collect(Collectors.toList());
        System.out.println("list = " + list);
    }
}

class Student {
    public String name;
    public int age;

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

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
