package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/20 10:46
 */
public class Text448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] temp = new int[n+1];
        for(int i=0;i<n+1;i++){
            temp[i] = 0;
        }
        for(int i=0;i<n;i++){
            int number = nums[i];
            temp[number] = 1;
        }
        for(int i=1;i<n+1;i++){
            if(temp[i]==0){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,1};
        System.out.println(Arrays.toString(findDisappearedNumbers(a).toArray()));
    }
}
