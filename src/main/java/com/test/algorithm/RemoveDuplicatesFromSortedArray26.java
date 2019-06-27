package com.test.algorithm;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/27 15:16
 */
public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(a));
    }
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        int s = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=s){
                nums[j++] =nums[i];
                s = nums[i];
            }
        }
        return j;
    }

    public static int removeDuplicates2(int[] nums) {
        int j = 0;
        for(int i=j+1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                nums[++j] =nums[i];
            }
        }
        return j+1;
    }
}
