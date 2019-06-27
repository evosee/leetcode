package com.test.algorithm;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/27 11:39
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        System.out.println(removeElement2(a, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[r++] = nums[i];
            }
        }
        return r;
    }

    public static int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            }else i++;
        }
        return i;


    }
}
