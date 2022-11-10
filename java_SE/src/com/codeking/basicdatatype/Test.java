package com.codeking.basicdatatype;

/**
 * @author : codeking
 * @date : 2022/11/3 16:01
 */
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("tom");
        Person p2 = new Person("tom");
        System.out.println(p1.name==p2.name);
        System.out.println(p1.name.hashCode());
        System.out.println(p2.name.hashCode());
        p1.setName("jack");
        System.out.println(p1.name.equals(p2.name));
        String d="jac";
        String a=d+"k";
        String b="jack";
        System.out.println(a.intern().hashCode()==b.intern().hashCode());
        String s1 = "a";
        s1 = s1 + "b";
        String s4 = s1.intern();
        System.out.println(s4);
        System.out.println(s4.intern());
        System.out.println(s1.equalsIgnoreCase(s4));
        String str1 = "abc123"; //题目： a21cb3

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }
}

class Person {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name =name;
    }

    public Person() {
    }
}