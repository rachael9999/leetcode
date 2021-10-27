package com.veal98.linkedlist;

public class ZuoXuanZhuanZiFuChuan_Icof58 {

    public String reverseLeftWords(String s, int k) {
        char[] arr = s.toCharArray();
        // 1.
        reverse(arr, 0, k - 1);
        // 2.
        reverse(arr, k, arr.length - 1);
        // 3.
        reverse(arr, 0, arr.length - 1);

        return new String(arr);
    }


    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
