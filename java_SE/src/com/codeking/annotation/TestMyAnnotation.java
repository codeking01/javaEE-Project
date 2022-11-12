package com.codeking.annotation;

/**
 * @author : codeking
 * @date : 2022/11/5 13:53
 */
public class TestMyAnnotation {
    public static void main(String[] args) {
        Person p1 = new Person();
    }
}

@MyAnnotation()
class Person {
    public Person() {
    }
}