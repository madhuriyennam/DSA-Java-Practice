package com.dsa.practice.arrays.assignments;

import java.util.*;

public class LargestZeroSumSubarray {

    /**
     * Optimal Solution using HashMap - O(n) time, O(n) space
     *
     * Key Insight: If cumulative sum at two different indices is same,
     * then the subarray between those indices has sum = 0
     */
    public static int findLargestZeroSumLength(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int cumulativeSum = 0;
        int maxLength = 0;

        // Handle case where subarray starts from index 0
        sumIndexMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (sumIndexMap.containsKey(cumulativeSum)) {
                // Found same cumulative sum before
                int prevIndex = sumIndexMap.get(cumulativeSum);
                int currentLength = i - prevIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Store first occurrence of this sum
                sumIndexMap.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }

    /**
     * Returns the actual subarray indices with largest zero sum
     */
    public static int[] findLargestZeroSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return new int[]{-1, -1};

        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int cumulativeSum = 0;
        int maxLength = 0;
        int startIndex = -1, endIndex = -1;

        sumIndexMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (sumIndexMap.containsKey(cumulativeSum)) {
                int prevIndex = sumIndexMap.get(cumulativeSum);
                int currentLength = i - prevIndex;

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startIndex = prevIndex + 1;
                    endIndex = i;
                }
            } else {
                sumIndexMap.put(cumulativeSum, i);
            }
        }

        return maxLength > 0 ? new int[]{startIndex, endIndex} : new int[]{-1, -1};
    }

    /**
     * Brute Force Solution - O(n²) time, O(1) space
     * Useful for understanding the problem
     */
    public static int findLargestZeroSumLengthBruteForce(int[] arr) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    /**
     * Alternative implementation with cleaner handling of edge cases
     */
    public static int findLargestZeroSumOptimized(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                // Entire subarray from 0 to i has sum 0
                maxLen = i + 1;
            } else if (map.containsKey(sum)) {
                // Found duplicate sum, subarray between has sum 0
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // First time seeing this sum
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Basic case
        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Length: " + findLargestZeroSumLength(arr1));
        System.out.println("Indices: " + Arrays.toString(findLargestZeroSumSubarray(arr1)));
        System.out.println();

        // Test Case 2: Entire array sums to 0
        int[] arr2 = {1, -1, 0, 2, -2};
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Length: " + findLargestZeroSumLength(arr2));
        System.out.println("Indices: " + Arrays.toString(findLargestZeroSumSubarray(arr2)));
        System.out.println();

        // Test Case 3: No zero sum subarray
        int[] arr3 = {1, 2, 3, 4};
        System.out.println("Array 3: " + Arrays.toString(arr3));
        System.out.println("Length: " + findLargestZeroSumLength(arr3));
        System.out.println("Indices: " + Arrays.toString(findLargestZeroSumSubarray(arr3)));
        System.out.println();

        // Test Case 4: Array with zeros
        int[] arr4 = {0, 1, -1, 0};
        System.out.println("Array 4: " + Arrays.toString(arr4));
        System.out.println("Length: " + findLargestZeroSumLength(arr4));
        System.out.println("Indices: " + Arrays.toString(findLargestZeroSumSubarray(arr4)));

        // Performance comparison
        System.out.println("\n=== Performance Comparison ===");
        int[] largeArr = generateRandomArray(100000);

        long start = System.currentTimeMillis();
        int result1 = findLargestZeroSumLength(largeArr);
        long time1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        int result2 = findLargestZeroSumOptimized(largeArr);
        long time2 = System.currentTimeMillis() - start;

        System.out.println("HashMap approach: " + result1 + " (Time: " + time1 + "ms)");
        System.out.println("Optimized approach: " + result2 + " (Time: " + time2 + "ms)");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(201) - 100; // Random numbers between -100 and 100
        }
        return arr;
    }
}
