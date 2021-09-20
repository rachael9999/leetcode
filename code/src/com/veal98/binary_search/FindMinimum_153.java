package com.veal98.binary_search;

public class FindMinimum_153 {

    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 收缩左边界
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 收缩右边界
                right = mid;
            }
        }

        return nums[left];
    }

}
