package com.codeking.processcontrol;

import java.util.Scanner;

/**
 * @author : codeking
 * @date : 2022/8/3 16:56
 */
public class Demo01 {
    public static void main(String[] args) {
        // 创建一个扫描类对象，用于接收键盘输入
        Scanner scanner = new Scanner(System.in);
        //  判断有没有输入 next()到空就结束了 包括 \n  和nextLine() 到最后
        if (scanner.hasNextLine()) {
            // 如果有输入，则获取输入的内容
            String name = scanner.nextLine();
            // 输出输入的内容
            System.out.println(name);
        }
        // 关闭扫描类对象，避免占用资源,
        scanner.close();
    }
}
