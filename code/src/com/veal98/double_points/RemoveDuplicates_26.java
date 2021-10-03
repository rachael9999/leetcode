package com.veal98.double_points;

import java.util.Scanner;

public class RemoveDuplicates_26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return 1;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow ++;
                nums[slow] = nums[fast];
            }
            fast ++;
        }

        // 返回新数组的长度
        return slow + 1;
    }
}
