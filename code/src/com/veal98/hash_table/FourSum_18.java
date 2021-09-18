package com.veal98.hash_table;

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

        // key: 数组元素, value: 该元素对应的下标
        Map<Integer, Integer> map = new HashMap<>();

        // 将数组存入 map, 相等的值只会放进去一个,
        for (int i = 0; i< nums.length; i ++) {
            map.put(nums[i], i);
        }

        // 三层循环决定 a b c
        // 遍历获得 a
        for (int i = 0; i < nums.length; i ++) {
            // 对 a 进行去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 遍历获得 b
            for (int j = i + 1; j < nums.length; j ++) {
                // 对 b 进行去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 遍历获得 c
                for (int k = j + 1; k < nums.length; k ++) {
                    // 对 c 进行去重
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    // 尝试从哈希表中获取第四个数字 d, 若存在，并且第四个数字需要在第三个数字右侧(防止重复)
                    int temp = target - nums[i] - nums[j] - nums[k];
                    if (map.containsKey(temp) && map.get(temp) > k) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], temp));
                    }
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {

        // 存储四元组
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        // key: 数组元素, value: 该元素对应的下标
        Map<Integer, Integer> map = new HashMap<>();

        // 将 c 和 d 的和存入 map, 并保存 c 的下标
        // 遍历获得 c
        for (int i = 0; i< nums.length; i ++) {
            // 对 c 进行去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 遍历获得 b
            for (int j = 0; j < nums.length; j ++) {
                // 对 d 进行去重
                if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }
                map.put(nums[i] + nums[j], i);
            }
        }

        // 两层循环决定 a b
        // 遍历获得 a
        for (int i = 0; i < nums.length; i ++) {
            // 对 a 进行去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 遍历获得 b
            for (int j = i + 1; j < nums.length; j ++) {
                // 对 b 进行去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // map 中查找 c 和 d
                int temp = target - nums[i] - nums[j];
                if (map.containsKey(temp) && map.get(temp) > j) {
                    // c 的值
                    int c = nums[map.get(temp)];
                    // d 的值
                    int d = temp - c;
                    res.add(Arrays.asList(nums[i], nums[j], c, d));
                }
            }
        }

        return res;
    }
}
