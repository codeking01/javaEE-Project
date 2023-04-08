package com.codeking.Basic;


import java.util.Arrays;

/**
 * @author CodeKing
 * @since 2023/4/8  14:56
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 10, 56, 3, 1, 2};
        bubbleSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        // 优化：1.减少冒泡次数 2.判断有序就不要在进行了 3.记录最后一次的索引，直接从这次开始比较
        // 记录最后一次交换的索引
        int last = 0;
        int outIndex = arr.length - 1;
        int innerIndex = arr.length - 1;
        for (int i = 0; i < outIndex; i++) {
            boolean flag = false;
            if (last != 0) {
                innerIndex = last;
            }
            for (int j = 0; j < innerIndex; j++) {
                // 判断有序
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = true;
                    // 记录最后一次交换的索引
                    last = j;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
