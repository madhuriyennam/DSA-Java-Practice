package com.dsa.practice.arrays;

public class MissingNumber {

    static int missingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    //TC: O(n)
    static int XORApproach(int[] arr) {
        int xorAll  = 0;
        int xorArray = 0;
        // XOR all numbers from 0 to n
        for(int i=0;i<=arr.length-1;i++){
            xorAll ^=i;
        }
        // XOR all numbers in the array
        for (int num : arr) {
            xorArray ^= num;
        }
        // Missing number is xorAll ^ xorArray
        return xorAll ^ xorArray;
    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(XORApproach(arr));
    }
}
