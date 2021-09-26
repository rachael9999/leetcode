package com.veal98.double_points;

import java.util.Scanner;

public class TwoSumII_167 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i ++) {
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] res = twoSum(numbers, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0 || numbers[0] > target) {
            return res;
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            // 左右指针指向的数之和
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }

        return res;
    }
}
