package com.codeking.Basic;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @author CodeKing
 * @since 2023/4/9  19:49
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 8, 6, 1, 5, 7};
        /*int i = quickSortOneSide(arr, 0, arr.length - 1);
        System.out.println("i = " + i);
        System.out.println("arr = " + Arrays.toString(arr));*/
        quickSortOneSideCircle(arr, 0, arr.length - 1);
        int[] arr1 = {3, 4, 8, 9, 5, 8, 6, 1, 5, 7, 5};
        quickSortOneSideCircle(arr1, 0, arr1.length - 1);
        System.out.println("*******下面是双边循环的代码*******");
        int[] arr2 = {3, 4, 8, 9, 2, 5, 8, 6, 1, 5, 7, 5};
        quickSortTwoSideCircle(arr2, 0, arr2.length - 1);
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    private static void quickSortTwoSideCircle(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = quickSortTwoSide(arr, l, r);
        quickSortTwoSideCircle(arr, l, mid - 1);
        quickSortTwoSideCircle(arr, mid + 1, r);
    }

    private static int quickSortTwoSide(int[] arr, int l, int r) {
        // 记录前面的索引
        int i = l;
        int j = r;
        int pv = arr[l];
        while (i < j) {
            // 先从右边向左边找，从j开始
            while (i < j && arr[j] > pv) {
                j--;
            }
            while (i < j && arr[i] <= pv) {
                i++;
            }
            // 交换位置
            swap(arr, i, j);
        }
        // 换出中间位置
        swap(arr, i, l);
        return j;
    }

    private static void quickSortOneSideCircle(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = quickSortOneSide(arr, l, r);
        quickSortOneSideCircle(arr, l, mid - 1);
        quickSortOneSideCircle(arr, mid + 1, r);
    }

    // 单边循环
    private static int quickSortOneSide(int[] arr, int l, int r) {
        int pv = arr[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] < pv) {
                swap(arr, i, j);
                // i 与j换位置
                i++;
            }
        }
        swap(arr, i, r);
        System.out.println("arr = " + Arrays.toString(arr));
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
