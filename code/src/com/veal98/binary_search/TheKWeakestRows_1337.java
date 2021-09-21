package com.veal98.binary_search;

import java.util.Arrays;

public class TheKWeakestRows_1337 {

    public static void main(String[] args) {


    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        // 行数
        int rowLen = mat.length;

        // 存储最终结果 res[i][0] 存储行的下标 res[i][1] 存储该行最后一个 1 的下标
        int[][] res = new int[rowLen][2];

        for (int i = 0; i < rowLen; i++) {
            // 查找该行元素 1 的右边界的下标
            int index = binarySearchRightBoundary(mat[i]);
            res[i][0] = i;
            res[i][1] = index;
        }

        // 按最后一个 1 的下标进行升序排序. 相等时，小的行数优先排在前面
        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        // 获取前 k 个结果
        int[] res_k = new int[k];
        for (int i = 0; i < k; i ++) {
            res_k[i] = res[i][0];
        }

        return res_k;
    }

    /**
     * 返回 i 行中元素 1 的右边界的下标
     */
    private static int binarySearchRightBoundary(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1) + 1;
            // 收缩右边界
            if (arr[mid] == 0) {
                right = mid - 1;
            } else {
                // 收缩左边界
                left = mid;
            }
        }

        // 因为 1 不一定总是存在，所以此处需要打个补丁
        return arr[right] == 1 ? right : -1;
    }

}
