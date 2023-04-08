package com.codeking.tests;

/**
 * @author : codeking
 * @date : 2023/4/5 19:56
 */
public class Demo02Test {
    public static void main(String[] args) {
        char a = 258;
        char b = 255;
        System.out.println();
        System.out.println(b);
        // 这个char 相加会自动转为int
        System.out.println((a + b));
        numTest.test();
    }
}

// 测试关于小数相加是否相等问题
class numTest {
    static void test() {
        double a = 0.1;
        double b = 0.1;
        System.out.println(a+b == 0.2);
        System.out.println(0.2 == 0.2F);
    }
}
