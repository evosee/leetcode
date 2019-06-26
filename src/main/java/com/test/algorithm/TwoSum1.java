package com.test.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 17:57
 *
 * 两数之和
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};

        System.out.println(Arrays.toString(sum3(a,22)));
    }
    public static int[] sum(int[] nums,int target){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[] sum2(int[] a,int t){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<a.length;i++){
            map.put(a[i],i);
        }
        for(int i=0;i<a.length;i++){
            int x = a[i];
            if(map.containsKey(t-x)&&map.get(t-x)!=i){
                return new int[]{map.get(t-x),i};
            }
        }
        return new int[0];

    }
    public static int[] sum3(int[] a,int t){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            int x = a[i];
            int r = t-x;
            if(map.containsKey(r)){
                return new int[]{map.get(r),i};
            }else {
                map.put(x,i);
            }

        }
        return new int[0];

    }
}
