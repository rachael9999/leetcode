package com.veal98.hash_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ValidAnagram_242 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        // 处理第一个字符串 s
        for (char ch : s.toCharArray()) {
            // 如果 map 中不存在该字符
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        // 处理第二个字符串 t
        for (char ch : t.toCharArray()) {
            // 如果 map 中不存在该字符
            if (!map.containsKey(ch)) {
                return false;
            } else {
                // map 中存在该字符但 value 已经为 0
                if (map.get(ch).equals(0)) {
                    return false;
                }
                map.put(ch, map.get(ch) - 1);
            }
        }

        // 若直到 t 全部处理完毕后，Hash 表中仍然存在 value > 0，则返回 false
        for (Character ch : map.keySet()) {
            if (map.get(ch) > 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] num = new int[26];

        // 处理第一个字符串 s
        for (char ch : s.toCharArray()) {
            num[ch - 'a'] += 1;
        }

        // 处理第二个字符串 t
        for (char ch : t.toCharArray()) {
            num[ch - 'a'] -= 1;
        }

        // 若 t 全部处理完毕后，数组中仍然存在 value != 0，则返回 false
        for (int i : num) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
