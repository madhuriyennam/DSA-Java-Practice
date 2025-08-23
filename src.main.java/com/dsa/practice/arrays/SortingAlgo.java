package com.dsa.practice.arrays;

import java.util.Arrays;

public class SortingAlgo {

    private static void swap(int[] arr, int l, int r) {
        int c = arr[l];
        arr[l] = arr[r];
        arr[r] = c;
    }

    //TC: o(n2) if not sorted array, if sorted array o(n)
    static void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean swapped = false;//To check if already sorted, break the loop
        for (int i = 0; i < length; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    //TC - o(n2)
    static void selectionSort(int[] arr) {
        int length = arr.length;
        int min_index;
        for (int i = 0; i < length; i++) {
            min_index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            swap(arr, i, min_index);
        }
    }

    static void insertionSort(int[] arr) {
        int length = arr.length;
        int value, hole;
        for(int i=1;i<length;i++) {
            value = arr[i];
            hole= i-1;
            while(hole>=0 && arr[hole]>=value){
                arr[hole+1] = arr[hole];
                hole--;
            }
            arr[hole+1] = value;
        }
    }

    static void mergeSort(int[] arr) {
        int l=0, r=arr.length-1, mid;
        if(l<r){
            mid = l+(r-l)/2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 9, 3};
        //bubbleSort(arr);
        //selectionSort(arr);
        insertionSort(arr);
        for(int num:arr){
            System.out.println(num);
        }
    }
}
