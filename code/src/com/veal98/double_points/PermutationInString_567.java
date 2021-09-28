package com.veal98.double_points;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationInString_567 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) {
            return false;
        }

        // 记录 s1 中的字符及其对应的个数
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < s1.length(); i ++){
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        // 表示窗口中满足 need 条件的字符个数
        int vaild = 0;

        while (right < s2.length()) {
            char newChar = s2.charAt(right);
            // 扩大窗口
            right ++;
            // 如果该字符存在于字符串 s1 中，则更新窗口数据以及 vaild (不存在的话没有更新的必要)
            if (need.containsKey(newChar)) {
                window.put(newChar, window.getOrDefault(newChar, 0) + 1);
                // 若窗口中的该字符满足 need 条件，则 vaild ++
                if (window.get(newChar).equals(need.get(newChar))) {
                    vaild ++;
                }
            }


            // 窗口中的字符数量等于 need 的大小(s1 中不同字符的个数), 则收缩窗口
            while (right - left == s1.length()) {
                if (vaild == need.size()) {
                    return true;
                }

                // 收缩窗口
                char removeChar = s2.charAt(left);
                left ++;

                // 如果被移除掉的字符存在于字符串 s1 中，则更新窗口数据以及 vaild (不存在的话没有更新的必要)
                if (need.containsKey(removeChar)) {
                    if (window.get(removeChar).equals(need.get(removeChar))) {
                        vaild --;
                    }
                    window.put(removeChar, window.get(removeChar) - 1);
                }
            }
        }

        return false;
    }
}
