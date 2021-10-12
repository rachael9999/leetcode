package com.veal98.array;

import java.util.Scanner;

public class NextPermutation_31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i ++) {
            arr[i] = sc.nextInt();
        }
        nextPermutation(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        // 1. 从后往前找第一个升序对 (nums[i], nums[i+1])
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // 如果不存在升序对，说明当前排列已经是最大，直接反转即可
        if (i == -1) {
            reverseArray(nums, 0, nums.length - 1);
            return ;
        }

        int j = i + 1;
        // 2. 此时 [j, end] 一定是降序的，在 [j, end] 中找到最后一个比 nums[i] 大的数
        // (或者说，从后往前 不超过 j 找到第一个比 nums[i] 大的数，) 然后交换
        for (int k = nums.length - 1; k >= j; k--) {
            if (nums[k] > nums[i]) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // 3. 反转 [j, end] 为升序
        reverseArray(nums, j, nums.length - 1);
    }

    private static void reverseArray(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) {
            return;
        }

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}
