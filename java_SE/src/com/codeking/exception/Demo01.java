package com.codeking.exception;

/**
 * @author : codeking
 * @date : 2022/9/6 20:04
 */
public class Demo01 {
    public static void main(String[] args) {
        int a = 0;

        try {
            test(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void test(int x){
        if (x == 0) {
           //throw new IllegalArgumentException("x must be positive");
            int i = 5 / x;
        }
    }

}
