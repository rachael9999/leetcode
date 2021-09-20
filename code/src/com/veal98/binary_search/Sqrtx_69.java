package com.veal98.binary_search;

import java.util.Scanner;

public class Sqrtx_69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        // 考虑到 x = 0 的情况，将左边界设为 0
        int left = 0;
        // 考虑到 x = 1 的情况，将右边界设置为 x / 2 + 1
        int right = x / 2 + 1;

        while (left <= right) {
            // 如果中点 mid 声明为 int 类型，无法通过大整型测试用例，因此变量需要声明为 long 类型
            long mid = left + ((right - left) >> 1);
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x)
                return (int) mid;
            else if (mid * mid < x) {
                left = (int) mid + 1;
            } else
                right = (int) mid - 1;
        }

        return -1;
    }
}
