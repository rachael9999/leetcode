package com.veal98.string;

public class ImplementStrstr_28 {


    /**
     * @param haystack 文本串(主串)
     * @param needle 模式串(匹配串)
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        // 文本串的下标
        int i = 0;
        // 模式串的下标
        int j = 0;

        int[] next= getNext(needle);

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            } else {
                j = next[j];
            }
        }

        if (j == haystack.length()) {
            return i - j;
        }

        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;

        int i = 0;
        int j = -1;

        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                // 前后缀相同
                i ++;
                j ++;
                next[i] = j;
            } else {
                // 前后缀不相同
                // 因为 next[j] 之前的字符都可以证明是匹配的。所以前边的就可以跳过去了
                j = next[j];
            }
        }

        return next;
    }

}
