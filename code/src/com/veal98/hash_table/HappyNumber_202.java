package com.veal98.hash_table;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber_202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        while (n != 1) {
                // 如果这个 sum 曾经出现过，说明已经陷入了无限循环了，立刻 return false
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getSumOfSquares(n);

        }

        return true;
    }

    /**
     * 获取 n 所有数字的平方和
     */
    private static int getSumOfSquares(int n) {
        int res = 0;
        while (n > 0) {
            // n 的最后一个数字
            int temp = n % 10;
            // 每个数字的平方和
            res += temp * temp;
            // 从后往前处理
            n = n / 10;
        }
        return res;
    }
}


