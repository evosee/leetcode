package com.test.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/20 11:31
 */
public class Text451 {
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxTime = 0;
        for (int i = 0; i < chars.length; i++) {
            char a = chars[i];
            Integer times = map.get(a);
            if (times == null) {
                times = 1;
                map.put(a, 1);
            } else {
                times = times+1;
                map.put(a, times);
            }
            maxTime = times > maxTime ? times : maxTime;
        }
        ArrayList[] characterList = new ArrayList[maxTime];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character c = entry.getKey();
            Integer value = entry.getValue()-1;
            if (characterList[value] == null) {
                characterList[value] = new ArrayList();
            }
            characterList[value].add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = maxTime; i > 0; i--) {
            ArrayList lists = characterList[i-1];
            if (lists != null) {
                for (int j = 0; j < lists.size(); j++) {
                    for (int m = 0; m < i; m++) {
                        stringBuilder.append(lists.get(j));
                    }
                }
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(frequencySort("cccaaa"));
    }
}
