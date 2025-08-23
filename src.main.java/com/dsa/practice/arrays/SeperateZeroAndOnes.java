package com.dsa.practice.arrays;

public class SeperateZeroAndOnes {

    static void twoPointerApproach(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l<r) {
            while(l<r && arr[l]==0) l++;
            while(l<r && arr[r]==0) r++;
            if(l<r)
                swap(arr, l, r);
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int c = arr[l];
        arr[l] = arr[r];
        arr[r]=c;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1, 0, 0, 1};
        twoPointerApproach(arr);
        for(int i :arr)
            System.out.print(i);
    }
}
