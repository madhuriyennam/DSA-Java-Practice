package com.dsa.practice.arrays;

import java.util.Arrays;

public class ClosestSumToZero {

    static int twoPointer(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, closestSum = Integer.MAX_VALUE;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int currentSum = arr[l] + arr[r];
            if (Math.abs(currentSum) < Math.abs(closestSum)) {
                closestSum = currentSum;
            }
            if (currentSum == 0) {
                return 0;
            } else if (currentSum < 0) {
                l++;
            } else {
                r--;
            }
        }
        return closestSum;
    }

    static int bruteForce(int[] arr) {
        int n = arr.length, closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int currSum = arr[i] + arr[j];
                if (Math.abs(currSum) < Math.abs(closestSum)) {
                    closestSum = currSum;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = {-8, -66, -60};
        System.out.println(bruteForce(arr));
        int[] arr1 = {-2, 9, 6, 1, 2, -5};
        System.out.println(twoPointer(arr));
    }
}
