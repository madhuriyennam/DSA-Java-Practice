package com.dsa.practice.arrays.assignments;

import java.util.List;

public class SortArray012 {

    public static List<Integer> sort_an_array(int n, List<Integer> arr) {
        // Write your code here
        Integer l=0, m=0, r= arr.size()-1;
        while(m<=r){
            if(arr.get(m)==0){
                swap(arr, l, m);
                l++;
                m++;
            } else if(arr.get(m)==1){
                m++;
            } else if(arr.get(m)==2){
                swap(arr, m, r);
                r--;
            }
        }
        return arr;

    }
    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
