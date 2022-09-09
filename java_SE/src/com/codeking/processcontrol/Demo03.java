package com.codeking.processcontrol;

/**
 * @author : codeking
 * @date : 2022/8/4 16:55
 */
public class Demo03 {
    public static void main(String[] args) {
        for (int i = 0; i <args.length; i++) {
            System.out.println(args[i]);
        }
        int a=1;
        System.out.println(a);
        for (int i=0; i<1; i++) {
            System.out.println("123");
        }
        //arg.length数组长度
        for (int i = 0; i < args.length; i++) {
            System.out.println("args["+ i +"]:"+args[i]);
        }
    }
    // 方法的重载
    public static int test(int a, float b,int c){
        System.out.println("123");
        return c;
    }
    public static int test(float a, int b,int c){
        System.out.println(a);
        return  c;
    }
    public static void test1(float a, int b){

    }
    public static void test1(int b, float a){

    }
}
