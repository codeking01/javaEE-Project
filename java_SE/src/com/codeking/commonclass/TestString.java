package com.codeking.commonclass;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 *  * String、StringBuffer、StringBuilder三者的异同？
 *  * String:不可变的字符序列；底层使用char[]存储
 *  * StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
 *  * StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储
 *
 * @author : codeking
 * @date : 2022/11/4 11:34
 */


public class TestString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "12hello34world5java7891mysql456";
        String str1 = str.replaceAll("\\d+", "#").replaceAll("^#|#$", "");
        System.out.println(str1);
        str = "123456";
        boolean result = str.matches("\\d+");
        System.out.println(result);
        String tel = "0571-4534289";
        result = tel.matches("0571-\\d{7,8}");
        System.out.println("result:" + result);
        // String转成基本数据类型
        int num = Integer.parseInt(str);
        System.out.println(num);
        //  基本数据类型转成String
        String str2 = String.valueOf(num);
        System.out.println(str2);
        // String转成数组char[]
        char[] char1 = str2.toCharArray();
        System.out.println("char1: " + Arrays.toString(char1));
        String str3 = new String(char1);
        System.out.println("char1: " + Arrays.toString(char1));
        System.out.println("str3: " + str3);
        stringToBytes();
        testStringBuffer();
    }

    public static void stringToBytes() throws UnsupportedEncodingException {
        String str1 = "abc123重工";
        //使用默认的字符编码集,进行转换
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));
        //使用gbk字符集进行编码。
        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
        //使用默认的字符集，进行解码。
        String str2 = new String(bytes);
        System.out.println(str2);
        //出现乱码。原因：编码集和解码集不一致！
        String str3 = new String(gbks);
        System.out.println("str3会乱码···" + str3);
        //没有出现乱码。原因：编码集和解码集一致！
        String str4 = new String(gbks, "gbk");
        System.out.println(str4);
    }

    public static void testStringBuffer() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
}