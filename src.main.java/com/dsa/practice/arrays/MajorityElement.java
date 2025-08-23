package com.dsa.practice.arrays;

public class MajorityElement {

    public static void main(String[] args) {
        //Element which appears more than n/2 times is 5. There can be only one element which appears more than n/2
        int[] arr = {8, 5, 8, 2, 5, 5, 5, 5};
        //int[] arr1 = {3,2,3,2}; --- No majority element in this array
        System.out.println(majorityElementMoreThanNBy2Times(arr));
    }

    //Approach 1 is HashMap approach (Hashing) TC O(n), SC - O(n)

    //Approach 2 - Moore Voting Algorithm TC-  O(n) , SC - O(1)
    private static int majorityElementMoreThanNBy2Times(int[] arr) {
        int candidate = 0;
        int votes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (votes == 0) {
                candidate = arr[i];
                votes++;
            } else {
                if (arr[i] == candidate) {
                    votes++;
                } else {
                    votes--;
                }
            }
        }
        //To check if it appears more than n/2 times
        votes = 0;
        for (int i : arr) {
            if (i == candidate) {
                votes++;
            }
        }
        if (votes > arr.length / 2) {
            return candidate;
        }
        return -1;
    }

    //Approach 2 - Moore Voting Algorithm TC-  O(n), SC - O(1)
    private static int[] majorityElementMoreThanNBy3Times(int[] arr) {
        int candidate1 = 0, candidate2 = 0;
        int votes1 = 0, votes2 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == candidate1) {
                votes1++;
            } else if(arr[i] ==candidate2){
                votes2++;
            } else if (votes1 == 0){
                candidate1 = arr[i];
                votes1++;
            } else if (votes2 == 0){
                candidate2 = arr[i];
                votes2++;
            }

        }
        return null;
    }
}
