package com.veal98.double_points;

public class MoveZeroes_283 {

    public static void main(String[] args) {


    }

    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return ;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, fast, slow);
                slow ++;
            }
            fast ++;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return ;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }

        // 将 slow 之后的元素全部赋 0
        while (slow < nums.length) {
            nums[slow] = 0;
            slow ++;
        }
    }
}
