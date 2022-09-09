package com.codeking.processcontrol;

import java.util.Arrays;

import static java.util.Arrays.fill;

/**
 * @author : codeking
 * @date : 2022/8/29 18:35
 */
public class Demo04 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        //1.创建一个二维数组, 11*11
        // 空盘用0代表,黑棋用1代表,白棋用2代表
        int[][] a = new int[11][11];
        a[1][2] = 1;
        a[2][3] = 2;
        System.out.println("输出原始的数组a：");
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println("===========================================");
        int[] s = {1, 2, 3, 10, 20, 30, 40, 50, 6, 7, 8};
        System.out.println(Arrays.toString(s));
        System.out.println("===========================================");
        int[][] b = {{1, 2}, {3, 4}};
        int[] c = {1, 2, 32, 33, 34};
        for (int k : c) {
            System.out.println(k);
        }
        System.out.println(Arrays.toString(b));
        fill(c, 0, 1, 5);
        System.out.println(Arrays.toString(c));
    }
}
