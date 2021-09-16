package com.veal98.hash_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ransom_Note_383 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ransomNote = sc.nextLine();
        String magazine = sc.nextLine();
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (magazine == null || magazine.length() == 0) {
            return true;
        }
        else if (ransomNote == null || ransomNote.length() == 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // 利用 map 处理 magazine，key 存储字符，value 存储该字符出现的次数
        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 遍历 ransomNote
        for (char ch : ransomNote.toCharArray()) {
            // ransomNote 的某个字符串不存在于 map 中,立即返回 false
            if (!map.containsKey(ch)) {
                return false;
            }
            // 在减 1 之前,如果 value 已经等于 0 了,则立即返回 false
            if (map.get(ch) == 0) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {

        if (magazine == null || magazine.length() == 0) {
            return true;
        }
        else if (ransomNote == null || ransomNote.length() == 0) {
            return false;
        }

        int[] nums = new int[26];

        // 利用 map 处理 magazine，key 存储字符，value 存储该字符出现的次数
        for (char ch : magazine.toCharArray()) {
            nums[ch - 'a'] += 1;
        }

        // 遍历 ransomNote
        for (char ch : ransomNote.toCharArray()) {
            // ransomNote 的某个字符串不存在于 map 中,立即返回 false
            // 在减 1 之前,如果 value 已经等于 0 了,则立即返回 false
            if (nums[ch - 'a'] == 0) {
                return false;
            }

            nums[ch - 'a'] -= 1;
        }

        return true;
    }
}
