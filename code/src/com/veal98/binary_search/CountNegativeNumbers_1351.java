package com.veal98.binary_search;

import java.util.Scanner;

public class CountNegativeNumbers_1351 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowLen = sc.nextInt();
        int columnLen = sc.nextInt();
        int[][] grid = new int[rowLen][columnLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;

        int rowLen = grid.length; // 行数
        int columnLen = grid[0].length; // 列数

        int right = columnLen - 1;
        // 依次二分查找每一行
        for (int i = 0; i < rowLen; i++) {
            int left = 0;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                // 收缩左边界
                if (grid[i][mid] >= 0) {
                    left = mid + 1;
                } else {
                    // 收缩右边界
                    right = mid;
                }
            }

            // 打个补丁
            count += grid[i][left] >= 0 ? 0 : columnLen - left;
        }

        return count;
    }
}
