package com.veal98.hash_table;

import java.util.*;

public class ThreeSum_15 {

    private final static Integer TARGET = 0;

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 存储三元组
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return res;
        }

        // 对数组进行排序
        Arrays.sort(nums);

        // 将数组存入 map, 相等的值只会放进去一个, i为下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }

        // 两层循环固定 a 和 b
        // 遍历获得 a
        for (int i = 0; i < nums.length; i ++) {
            // 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
            if (nums[i] > 0) {
                continue;
            }

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

                int c = TARGET - nums[i] - nums[j];
                // 尝试从哈希表中获取第三个数字 c, 若存在，并且第三个数字需要在第二个数字右侧(防止重复)
                if (map.containsKey(c) && map.get(c) > j) {
                    res.add(Arrays.asList(nums[i], nums[j], c));
                }
            }
        }

        return res;
    }
}
