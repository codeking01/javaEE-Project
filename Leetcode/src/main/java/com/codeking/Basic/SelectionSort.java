package com.codeking.Basic;

import java.util.Arrays;

/**
 * @author CodeKing
 * @since 2023/4/9  15:05
 */
public class SelectionSort {
    public static void main(String[] args) {
        Arrays a;
        // 选择排序
        int[] arr = {9, 2, 4, 8, 3, 9, 1, 6};
        selectionSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    // 选择排序，优化：只记录最小索引吗，在最后去交换
    private static void selectionSort(int [] arr) {
        // 记录最小的索引
        int minIndex ;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[minIndex]>arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex!=i) {
                swap(arr, minIndex, i);
            }
        }
    }

    private static void swap(int[] arr, int minIndex, int i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }

}
