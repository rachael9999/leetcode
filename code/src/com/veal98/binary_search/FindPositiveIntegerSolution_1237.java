package com.veal98.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolution_1237 {

    private final static Integer leftBoundary = 1000;
    private final static Integer rightBoundary = 1;

    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();

        for (int x = rightBoundary; x <= leftBoundary; x ++) {
            // 固定 x, 二分查找 y
            int left = rightBoundary;
            int right = leftBoundary;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (customfunction.f(x, mid) == z) {
                    res.add(Arrays.asList(x, mid));
                    // 既然 y 是单调递增且无重复的, 显然一个 x 只可能对应一个 y, 找到了就可以直接 break 开始处理下一个 x
                    break;
                }
                else if (customfunction.f(x, mid) < z) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        return res;
    }

    // This is the custom function interface.
    // You should not implement it, or speculate about its implementation
    abstract class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public abstract int f(int x, int y);
    }
}
