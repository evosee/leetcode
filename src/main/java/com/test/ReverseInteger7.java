package com.test;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/26 11:00
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        int x = 964632435;

        System.out.println(reverse(x));

    }

    public static int reverse(int x) {
        if(x==0) return 0;
        int temp = x;
        if(x<0){
            temp = -x;
        }
        String s = String.valueOf(temp);
        char[] chars = s.toCharArray();

        int n = s.length();
        int i = 0;

        int end = n - 1;
        n = n / 2;
        while (i < n) {
            char t = chars[i];
            chars[i] = chars[end];
            chars[end] = t;
            i++;
            end--;
        }
        int k = 0;
        int r = 0;
        while (chars[k++] == '0') r++;
        String result = new String(chars, r, s.length()-r);
        int y =  Integer.parseInt(result);
        if(x<0){
            y = -y;
        }
        return y;

    }
}
