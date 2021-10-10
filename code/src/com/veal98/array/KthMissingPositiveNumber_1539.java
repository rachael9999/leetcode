package com.veal98.array;

import java.util.Scanner;

public class KthMissingPositiveNumber_1539 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i ++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {
        // 当前位置应当出现的数
        int cur = 1;

        int i = 0;
        while (i < arr.length || k == 0) {
            if (cur != arr[i]) {
                // cur 缺失
                k --;
                cur ++;
            } else {
                i ++;
                cur ++;
            }
        }

        // 最后 + k 是为了处理特殊情况:遍历完数组但是 k 还没有减完
        return cur + k;
    }
}
