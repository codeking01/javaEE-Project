package com.codeking.Basic;

import java.util.Arrays;

/**
 * @author CodeKing
 * @since 2023/4/9  15:53
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 2, 1, 8, 7};
        insertSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        // 大量换个达到数字测试这个算法
        int[] arr2 = {9, 2, 4, 8, 3, 9, 1, 6};
        insertSort(arr2);
        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println("*************");
        Arrays.sort(arr2);
        insertSort(arr2);
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    // 插入排序
    private static void insertSort(int[] arr) {
        // 优化：找到小的就退出内层循环；使用移动的方式 a[i+1]=a[i]
        for (int i = 1; i < arr.length; i++) {
            // 定义前一个位置的索引
            int pre = i - 1;
            // 记录插入变量
            int temp = arr[i];
            while (pre >= 0) {
                if (temp < arr[pre]) {
                    arr[pre + 1] = arr[pre];
                } else {
                    break;
                }
                pre--;
            }
            // 插入,发生改变才插入
            if (pre != i - 1) {
                arr[pre + 1] = temp;
            }
        }
    }

    // 希尔排序
    // N/2 步长去快速交换位置，最后达到简单实现插入排序
}
