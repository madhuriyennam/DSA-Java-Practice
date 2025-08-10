package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumber {

    //Approach 1 : o(n2)

    //Approach 2
    static void hashingApproach(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>(); //SC - O(N)
        //TC - O(N)
        for (int num : arr) {
            if (freq.containsKey(num)) {
                System.out.println("Duplicate number " + num);
                break;
            }
            freq.put(num, 1);
        }
    }

    //Approach 3 - XOR


    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 4, 6, 5};
        hashingApproach(arr);
    }
}
