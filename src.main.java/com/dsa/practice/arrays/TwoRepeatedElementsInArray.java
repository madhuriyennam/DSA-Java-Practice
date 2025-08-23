package com.dsa.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoRepeatedElementsInArray {


    //1. two loops o(nsquare)
    //2. Sort and compare i and i+1 - o(nlogn), o(1)
    //3. HashMap with frequency -o(n), o(n)

    //5. Two Repeated Elements with Indices.(Best)
    //Better to go with this approach
    //TODO: Try to solve duplicate and mising number with this approach
    static List<Integer> twoRepeatedElementsWithIndices(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] > 0)
                arr[index] = -arr[index];
            else
                result.add(index);
            if (result.size() == 2)
                break;
        }
        return result;
    }

    //6. Two Repeated Elements with XOR (Complex)
    /* 1. Take XOR of array 1..n
    *  2. XOR = c (a xor b)
    *  3. Now to seperate out a and b , split into two bucket and reduce the problem to single bucket
    *  4. To seperate and check rightMostSetBit number
    */
    static List<Integer> twoRepeatedElementsWithXOR(int[] arr, int n) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5, 3, 2};
        System.out.println(twoRepeatedElementsWithIndices(arr));
    }
}
