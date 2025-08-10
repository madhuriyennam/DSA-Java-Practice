package com.dsa.practice.arrays;

public class Searching {

    //Single search + unsorted array → Linear Search
    //Many searches + sorted array → Binary Search (Divide and Search)
    //For unsorted array - Binary sercah will give time complexity of O(nlogn) which is more than linear search

    //TC - O(n), O(1) - Best for unsorted arrays
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == target) {
                return arr[i];
            }
        }
        return -1;
    }

    //TC - O(logn), SC- O(1) - For sorted arrays
    static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            //int mid = l+(r-l)/2; This is best to use to avoid overflow cases where l and  are very large
            if (arr[mid] == target) {
                return arr[mid];
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    //TC - O(logn), SC - O(logn) - For sorted arrays
    static int binarySearchRecursive(int[] arr, int target, int l, int r) {
        if(l>r) return -1; //base case or terminating condition
        int mid = l+(r-l)/2;
        if(arr[mid] == target)
            return target; //element found
        if(target<arr[mid])
            binarySearchRecursive(arr, target, l, mid-1); //reducing right boundary
        return binarySearchRecursive(arr, target, mid+1, r); //reducing left boundary
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        System.out.println(linearSearch(arr, 8));
        System.out.println(binarySearch(arr, 8));
        System.out.println(binarySearchRecursive(arr, 8, 0, arr.length-1));
    }
}
