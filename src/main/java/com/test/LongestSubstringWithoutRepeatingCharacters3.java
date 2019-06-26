package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/24 18:39
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String s = "abcabcbbdef";
        System.out.println(lengthOfLongestSubstring3(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            Set<Character> characters = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!characters.contains(chars[j])) {
                    characters.add(chars[j]);
                } else {
                    break;

                }
            }
            if (length < characters.size()) {
                length = characters.size();

            }

        }

        return length;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int n = chars.length;
        while (i < n && j < n) {
            if (!set.contains(chars[j++])) {
                set.add(chars[j - 1]);
            } else {
                set.remove(chars[i]);//弹出左边的
            }
        }
        return set.size();
    }

    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
