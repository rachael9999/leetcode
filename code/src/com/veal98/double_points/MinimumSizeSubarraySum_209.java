package com.veal98.double_points;

public class MinimumSizeSubarraySum_209 {

    public static void main(String[] args) {

    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 滑动窗口
        int window = 0;
        int left = 0;
        int right = 0;

        // 记录最小子数组的长度
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            // 扩大窗口
            window += nums[right];
            right ++;

            // 如果数组中元素的和 >= target，收缩窗口
            while (window >= target) {
                // 我们的窗口是左开右闭区间，所见这里窗口的长度是 right - left，不要 +1！
                res = Math.min(res, right - left);
                // 缩小窗口
                window -= nums[left];
                left ++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
