package com.veal98.double_points;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 无重复的最长子串的长度
        int res = 0;

        // 滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char newChar = s.charAt(right);
            // 扩大窗口
            right ++;
            // 处理窗口中新加入的元素 newChar
            window.put(newChar, window.getOrDefault(newChar, 0) + 1);

            // 如果窗口中该元素重复，则缩小窗口直至不重复
            while (window.get(newChar) > 1) {
                char removeChar = s.charAt(left);
                // 缩小窗口
                left ++;
                // 处理下窗口被移除的元素 removeChar
                window.put(removeChar, window.get(removeChar) - 1);
            }

            // 我们的窗口是左开右闭的，所以这里窗口的长度不要 +1 !!!
            res = Math.max(res, right - left);
        }

        return res;
    }
}
