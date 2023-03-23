package org.codeking.steam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : codeking
 * @date : 2023/3/15 21:02
 */
public class streamTest01 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(11);
        student1.setName("codeking");
        Student student2 = new Student();
        student1.setAge(12);
        student1.setName("codeking");
        Student student3 = new Student();
        student1.setAge(13);
        student1.setName("codeking");
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        List<Integer> list1 = list.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println(list1);
    }
}

class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}