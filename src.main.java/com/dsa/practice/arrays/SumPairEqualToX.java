package com.dsa.practice.arrays;

import java.util.Arrays;
import java.util.List;

public class SumPairEqualToX {

    //o(nlogn)+o(n)
    static void pairs(int[] arr, int x) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int pairSum = arr[l] + arr[r];
            if (pairSum == x) {
                System.out.println("First:" + arr[l] + ",Second:" + arr[r]);
                l++;
            } else if (pairSum < x) {
                l++;
            } else {
                r--;
            }
        }
    }

    //Approach 2 with HashMap - O(n), O(n)

    public static void main(String[] args) {
        int[] arr = {-2, 4, -1, 3, 4, 9};
        pairs(arr, 7);
    }
}
