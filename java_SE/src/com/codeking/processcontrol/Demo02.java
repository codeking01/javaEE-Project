package com.codeking.processcontrol;

import java.util.Scanner;

/**
 * @author : codeking
 * @date : 2022/8/3 17:27
 */
public class Demo02 {
    public static void main(String[] args) {
        int m = 1;
        int n = m++;
        int o = ++m;
        System.out.println("---------");
        //System.out.println("m:" + m+" n:"+n+" o:"+o);
        new Demo02().test();
    }
    public void test(){
        Scanner scanner = new Scanner(System.in);
        //从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.println("请输入整数：");
        if (scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数数据为："+i);
        }else{
            System.out.println("你输入的不是整数数据！");
        }
        System.out.println("请输入小数：");
        if (scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("小数数据为："+f);
        }else{
            System.out.println("你输入的不是小数数据！");
        }
        scanner.close();
    }
}


