package com.veal98.hash_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two_Sum_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 数组长度
        int len = sc.nextInt();
        // target
        int target = sc.nextInt();
        // 构造数组
        int[] nums = new int[len];
        for (int i = 0; i < len; i ++) {
            nums[i] = sc.nextInt();
        }
        int[] res = twoSum(nums, target);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    /**
     * 在数组中找出和为目标值 target 的那两个整数
     * @return 返回两个整数的数组下标
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // key: 元素值, value: 元素下标
        Map<Integer, Integer> map = new HashMap<>();
        
        // 处理数组存入 map
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        
        // 遍历数组
        for (int i = 0; i < nums.length; i ++) {
            // 当前元素 nums[i] + j = target
            int j = target - nums[i];
            // 在 map 中查找下 j 对应的键值对是否存在, 并且还要注意这个数不能是 nums[i] 本身
            if (map.containsKey(j) && map.get(j) != i) {
                return new int[]{i, map.get(j)};
            }
        }

        return new int[0];
    }
}
