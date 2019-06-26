package com.test;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/25 17:03
 */
public class LongestPalindromicSubstring5 {

    public static void main(String[] args) {
        String s = "abcda";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String r = "";
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            int j = i + 1;
            String f;
            for (; j < s.length(); j++) {
                if (x == s.charAt(j)) {
                    f = s.substring(i, j + 1);
                    if (f.length() > r.length()) {
                        r = f;
                    }
                } else if (j == s.length()-1) {
                    f = String.valueOf(x);
                    if (f.length() > r.length()) {
                        r = f;
                    }

                }
            }

        }
        return r;
    }
}
