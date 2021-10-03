package com.veal98.double_points;

public class RemoveElement_27 {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }

        return slow;
    }
}
