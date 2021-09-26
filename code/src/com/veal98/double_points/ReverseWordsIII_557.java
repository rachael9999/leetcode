package com.veal98.double_points;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseWordsIII_557 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0 || s.equals(" ")) {
            return s;
        }

        char[] arr = s.toCharArray();

        int start = 0;
        int end = 0;
        while (end < arr.length) {
            // 找到单词的结束位置（最后一个字符的位置）
            while (end < arr.length - 1 && arr[end + 1] != ' ') {
                end ++;
            }

            // 反转这个单词
            reverse(arr, start, end);

            // 继续寻找下一个单词
            end = end + 2;
            start = end;
        }

        // 注意这里不要用 Arrays.toString
        return new String(arr);
    }


    /**
     * 反转 arr[] 从 start 到 end 位置的字符
     */
    private static void reverse(char[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start == end || start > end) {
            return ;
        }

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
