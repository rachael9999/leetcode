package com.veal98.hash_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FourSum_II_454 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        // 构建 nums1
        int[] nums1 = new int[len];
        for (int i = 0; i < len; i ++) {
            nums1[i] = sc.nextInt();
        }
        // 构建 nums2
        int[] nums2 = new int[len];
        for (int i = 0; i < len; i ++) {
            nums1[i] = sc.nextInt();
        }
        // 构建 nums3
        int[] nums3 = new int[len];
        for (int i = 0; i < len; i ++) {
            nums1[i] = sc.nextInt();
        }
        // 构建 nums4
        int[] nums4 = new int[len];
        for (int i = 0; i < len; i ++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));

    }

    /**
     * 题目已经假设所有的 A, B, C, D 具有相同的长度
     * @return 返回符合条件的元组个数
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        // key 存放 a 和 b 两数之和，value 存放 a 和 b 两数之和出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 处理 A 数组和 B 数组
        for (int a : nums1) {
            for (int b : nums2) {
                int temp = a + b;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        // 再处理 C 数组和 D 数组
        for (int c : nums3) {
            for (int d : nums4) {
                int temp = c + d;
                // 如果 0-(c+d) 这个 key 在 map 中出现过的话, 即表示这 a b c d 是一个符合条件的元组
                if (map.containsKey(0 - temp)) {
                    count += map.get(0 - temp);
                }
            }
        }

        return count;
    }
}
