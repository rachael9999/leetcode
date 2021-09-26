package com.veal98.double_points;

import java.util.*;

public class FourSum_18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 数组长度
        int len = sc.nextInt();
        // 构造数组
        int[] nums = new int[len];
        for (int i = 0; i < len; i ++) {
            nums[i] = sc.nextInt();
        }
        // target
        int target = sc.nextInt();
        List<List<Integer>> res = fourSum(nums, target);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 存储四元组
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        // 两层循环遍历排序后的数组，确定前两个元素 nums[i] 和 nums[j]
        for (int i = 0; i < nums.length; i ++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j ++) {
                // 跳过重复元素
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 找到剩下的两个元素
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 跳过重复元素
                        while (left < right && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        while (left < right  && nums[right] == nums[right - 1]) {
                            right --;
                        }

                        // 开始寻找新的解
                        left ++;
                        right --;
                    } else if (sum < target) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }
        }

        return res;
    }


}
