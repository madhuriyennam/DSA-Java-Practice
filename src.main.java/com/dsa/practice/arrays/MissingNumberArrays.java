package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MissingNumberArrays {

    public static void main(String[] args) {
        int[] arr = {12,14,17,13};
        int[] brr = {11,12,14,12,13,17,14};
        findMissingNumberWithMap(arr, brr);
        findMissingNumbersUsingFrequencyArrayOptimized(arr, brr);
    }

    private static void findMissingNumberWithMap(int[] arr, int[] brr) {
        Map<Integer, Long> frequencyMap = new HashMap<>();
        for (int i : brr) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0L)+1);
        }
        for(int i : arr) {
            if(frequencyMap.containsKey(i))
                frequencyMap.put(i, frequencyMap.get(i)-1);
            if(frequencyMap.get(i) == 0)
                frequencyMap.remove(i);
        }
        frequencyMap.keySet().stream().sorted().forEach(System.out::println);
    }

    private static void findMissingNumbersUsingFrequencyArrayOptimized(int[] arr, int[] brr) {
        // Step 1: Find min and max value in both arrays
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int num : brr){
            if(num<minValue)
                minValue=num;
            if(num>maxValue)
                maxValue=num;
        }
        // Step 2: Create frequency array only for required range
        int size = maxValue - minValue +1;
        int[] frequencyArray = new int[size];
        // Step 3: Count frequency from brr
        for(int num : brr){
            frequencyArray[num-minValue]++;
        }
        // Step 4: Decrement counts for arr
        for(int num: arr){
            frequencyArray[num-minValue]--;
        }
        // Step 5: Print missing numbers (sorted automatically)
        for (int i = 0; i < size; i++) {
            while (frequencyArray[i] > 0) { // print as many times as it's missing
                System.out.println(i + minValue);
                frequencyArray[i]--;
            }
        }

    }
}
