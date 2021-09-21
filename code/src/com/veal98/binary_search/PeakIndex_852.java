package com.veal98.binary_search;

public class PeakIndex_852 {

    public static void main(String[] args) {

    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 峰顶
            if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid -1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1]){
                // 峰顶在 mid 左边
                right = mid - 1;
            } else {
                // 峰顶在 mid 右边
                left = mid + 1;
            }
        }

        return -1;
    }
}
