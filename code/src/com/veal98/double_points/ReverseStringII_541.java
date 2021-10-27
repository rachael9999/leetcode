package com.veal98.double_points;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStringII_541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        StringBuilder str = new StringBuilder(s);

        // 每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符
        for (int i = 0; i < str.length(); i += (2 * k)) {
            // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
            if (i + k <= str.length()) {
                reverse(str, i, i + k - 1);
            }
            // 如果剩余字符少于 k 个，则将剩余字符全部反转
            else  {
                reverse(str, i, str.length() - 1);
            }
        }

        return str.toString();
    }

    // 反转 str[left, right]
    private static void reverse(StringBuilder str, int left, int right) {
        while (left < right) {
            char tempLeft = str.charAt(left);
            char tempRight = str.charAt(right);
            str.setCharAt(left, tempRight);
            str.setCharAt(right, tempLeft);
            left ++;
            right --;
        }
    }
}
