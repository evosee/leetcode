package com.test;

import java.util.*;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/25 16:12
 */
public class MedianofTwoSortedArrays4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {



        List<Integer> list  = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        int x =  list.size();
        int mid =x/2;

        if(x%2==0){
            return (list.get(mid)+list.get(mid-1))/2.0;
        }else return list.get(mid);
    }
}
