package com.codeking.basicdatatype;

import java.math.BigDecimal;

/**
 * @author king
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println("Basic_DataType.Hello, World!哈哈哈");
        System.out.println();
    }

    static {
        char name = 'A';
        int a = name;
        System.out.println(name);
        System.out.println(a);
        System.out.println("---------------------");
        BigDecimal x = BigDecimal.valueOf(0.1);
        BigDecimal y = BigDecimal.valueOf(1.0 / 10);
        System.out.println("x == y:" + (x.equals(y)));
        System.out.println("x.compareTo(y):" + x.compareTo(y));
        System.out.println("*********************");
        int c = 2;
        // 左移是乘法，右移是除法
        System.out.println(2 << 3);
        c = c > 1 ? c : 1;
        System.out.println("c:" + c);
        //logger.info("c:" + c);
    }


    /**
     * @param name 名字
     * @return 名字
     */
    public static String test(String name) {
        return name;
    }

    // package: com.codeking.basicDataType 一般是公司的域名倒置
}
