package com.veal98.double_points;

public class TiHuanKongGe_Icof05 {

    public String replaceSpace(String s) {
        if (s == null || s.length() < 0) {
            return s;
        }

        // 空格的长度
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                count ++;
            }
        }

        char[] newStr = new char[s.length() + count * 2];
        for (int i = 0; i < s.length(); i ++) {
            newStr[i] = s.charAt(i);
        }
        int left = s.length() - 1;
        int right = newStr.length - 1;

        while (left < right) {
            if (s.charAt(left) == ' ') {
                newStr[right--] = '0';
                newStr[right--] = '2';
                newStr[right] = '%';
            } else {
                newStr[right] = s.charAt(left);
            }
            left --;
            right --;
        }

        return new String(newStr);
    }

}
