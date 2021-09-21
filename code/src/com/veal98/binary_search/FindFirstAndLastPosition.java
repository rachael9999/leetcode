package com.veal98.binary_search;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1}; // 存储左右边界

        if(nums == null || nums.length == 0)
            return res;

        // 寻找左边界
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = ((left + right) >> 1);
            // 收缩左边界
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 收缩右边界
                right = mid;
            }
        }
        res[0] = nums[left] == target ? left : -1;

        // 如果左边界是最后一个数的下标或者该数没有重复只存在一个，那么可以直接令右边界 = 左边界
        if (res[0] != -1) {
            if (left == nums.length - 1 || nums[left + 1] != target) {
                res[1] = left;
            } else {
                // 寻找右边界
                right = nums.length - 1;
                while (left < right) {
                    int mid = ((left + right) >> 1) + 1;
                    // 收缩右边界
                    if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        // 收缩左边界
                        left = mid;
                    }
                }

                res[1] = nums[right] == target ? right : -1;
            }

        }

        return res;
    }
}
