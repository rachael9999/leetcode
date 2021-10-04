package com.veal98.binary_search;

public class SquaresOfSortedArray_977 {

    public static void main(String[] args) {

    }

    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        // res 数组的下标
        int index = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;

        // 注意这里是 left <= right, 因为最后要处理最后一个元素
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index --] = nums[left] * nums[left];
                left ++;
            } else {
                res[index --] = nums[right] * nums[right];
                right --;
            }
        }

        return res;
    }
}
