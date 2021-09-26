package com.veal98.double_points;

import java.util.Scanner;

public class ReverseWords_151 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        // 去除首尾以及中间多余的空格
        StringBuilder sb = removeExtraSpace(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 挨个反转每个单词
        reverseWordsByEach(sb);
        return sb.toString();

    }

    /**
     * 去除首尾以及中间多余的空格
     */
    private static StringBuilder removeExtraSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        // 去除开头多余的空格
        while (s.charAt(start) == ' ') {
            start ++;
        }
        // 去除末尾多余的空格
        while (s.charAt(end) == ' ') {
            end --;
        }

        // 去除中间多余的空格
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 不是空格的字符肯定是要加入 sb 的
            // 还有,如果不是连续空格,也需要加入(或者说, 如果是连续空格, 我们只加入第一个空格)
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start ++;
        }

        return sb;
    }

    /**
     * 逐个反转每个单词
     */
    private static void reverseWordsByEach(StringBuilder sb) {
        if (sb == null || sb.length() == 0 || sb.equals(" ")) {
            return ;
        }

        int start = 0;
        int end = 0;
        while (end < sb.length()) {
            // 找到单词的结束位置（最后一个字符的位置）
            while (end < sb.length() - 1 && sb.charAt(end + 1) != ' ') {
                end ++;
            }

            // 反转这个单词
            reverse(sb, start, end);

            // 继续寻找下一个单词
            end = end + 2;
            start = end;
        }
    }

    /**
     * 反转从 left 到 right 位置的字符串
     */
    private static void reverse(StringBuilder sb, int left, int right) {
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left ++;
            right --;
        }
    }



}
