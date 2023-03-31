package com.codeking.hot100;/**
* @author : codeking
* @date   : 2023/3/31 20:23
*/
public class N_01 {
    // 两数之和
    public static void main(String[] args) {
        /**
         *      给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
         *      你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
         */
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = solution.twoSum(nums, target);
        System.out.printf("int[] = {%d, %d}", ints[0], ints[1]);
    }

}

class solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return ints;
    }
}
