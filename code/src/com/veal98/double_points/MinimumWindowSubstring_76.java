package com.veal98.double_points;

import java.util.HashMap;

public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {

    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 记录 t 中的字符及其对应的个数
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < t.length(); i ++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        // 表示窗口中满足 need 条件的字符个数
        int vaild = 0;

        // 最小覆盖子串的长度
        Integer res = Integer.MAX_VALUE;
        // 记录最小覆盖子串的起始位置
        int start = 0;

        while (right < s.length()) {
            char newChar = s.charAt(right);
            // 扩大窗口
            right ++;

            // 如果该字符存在于字符串 t 中，则更新窗口数据以及 vaild (不存在的话没有更新的必要)
            if (need.containsKey(newChar)) {
                window.put(newChar, window.getOrDefault(newChar, 0) + 1);
                if (window.get(newChar).equals(need.get(newChar))) {
                    vaild ++;
                }
            }

            // 窗口中的字符完全覆盖 t, 则收缩窗口
            while (vaild == need.size()) {
                // 如果当前窗口的长度 < res, 则更新 res, 并记录该窗口的起始位置
                if (right - left < res) {
                    start = left;
                    res = right - left;
                }

                char removeChar = s.charAt(left);
                // 缩小窗口
                left ++;
                // 如果被移除掉的字符存在于字符串 s 中，则更新窗口数据以及 vaild (不存在的话没有更新的必要)
                if (need.containsKey(removeChar)) {
                    if (window.get(removeChar).equals(need.get(removeChar))) {
                        vaild --;
                    }
                    window.put(removeChar, window.get(removeChar) - 1);
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? "" : s.substring(start, start + res);
    }
}
