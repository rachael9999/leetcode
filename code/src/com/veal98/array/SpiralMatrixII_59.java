package com.veal98.array;

public class SpiralMatrixII_59 {

    public static void main(String[] args) {

    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 最左列
        int left = 0;
        // 最右列
        int right = n - 1;
        // 最上行
        int up = 0;
        // 最下行
        int bottom = n - 1;

        // 当前填充的数
        int curNum = 1;

        while (curNum <= n * n) {
            // 左 -> 右
            for (int j = left; j <= right; j++) {
                res[up][j] = curNum++;
            }
            up++;

            // 上 -> 下
            for (int j = up; j <= bottom; j++) {
                res[j][right] = curNum++;
            }
            right--;

            // 右 -> 左
            for (int j = right; j >= left; j--) {
                res[bottom][j] = curNum++;
            }
            bottom--;

            // 下 -> 上
            for (int j = bottom; j >= up; j--) {
                res[j][left] = curNum++;
            }
            left++;
        }

        return res;
    }

    public static int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];

        // 四个方向: 右下左上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 指定哪个方向
        int directionIndex = 0;

        // 当前填充的数
        int curNum = 1;
        // 最后一个数
        int maxNum = n * n;

        // 行数
        int row = 0;
        // 列数
        int column = 0;

        while (curNum <= maxNum) {
            // 填充一个数
            res[row][column] = curNum;
            curNum ++;

            // 若下一步的位置超出矩阵边界，或者是已经被赋过值的位置，则进入下一个方向
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || res[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }

            // 进入下一个位置
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }

        return res;
    }
}
