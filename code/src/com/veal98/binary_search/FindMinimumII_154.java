package com.veal98.binary_search;

public class FindMinimumII_154 {

    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 收缩左边界
            if (nums[mid] > nums[right]) {
                // 说明 mid 在最小值的左边（最小值在 mid 的右边）
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 收缩右边界（说明 mid 在最小值的右边，最小值在 mid 的左边）
                right = mid;
            } else {
                // 保守收缩右边界
                right --;
            }
        }

        return nums[left];
    }
}
