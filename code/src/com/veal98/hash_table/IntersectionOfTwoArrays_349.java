package com.veal98.hash_table;

import java.util.*;

public class IntersectionOfTwoArrays_349 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nums1 的长度
        int len1 = sc.nextInt();
        // nums2 的长度
        int len2 = sc.nextInt();
        // 构造 nums1
        int[] nums1 = new int[len1];
        for (int i = 0; i < len1; i ++) {
            nums1[i] = sc.nextInt();
        }
        // 构造 nums2
        int[] nums2 = new int[len2];
        for (int i = 0; i < len2; i ++) {
            nums2[i] = sc.nextInt();
        }

        int[] res = intersection(nums1, nums2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        // 存储交集
        Set<Integer> resSet = new HashSet<>();

        // 存储 nums1
        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }

        // set 转 数组
        int[] res = new int[resSet.size()];
        int index = 0;
        for (Integer i : resSet) {
            res[index ++] = i;
        }

        return res;
    }
}
