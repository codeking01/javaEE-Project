package com.codeking.Basic;

/**
 * @author CodeKing
 * @since 2023/4/8  14:10
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        int index = binarySearch(arr, target);
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int target) {
        // 判断边界
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //定义边界
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left +(right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // **解决整数溢出问题: 使用移位 (l+r)>>1 右移就是除法；或者 l+(r-l)/2
}
