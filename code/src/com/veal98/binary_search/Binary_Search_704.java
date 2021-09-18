package com.veal98.binary_search;

public class Binary_Search_704 {

    public static void main(String[] args) {

    }

    /**
     * 返回 target 的下标, 若不存在, 返回 -1
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < nums[left]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
