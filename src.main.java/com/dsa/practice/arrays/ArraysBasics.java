package com.dsa.practice.arrays;

//Arrays contigous location - If size increasing dynmamically if no space available entire array will be copied to a different memory location
//Index (zero based)
//1D array int[] arr = new int[n+1];
//2D array int[][] arr = new int[m][n]
public class ArraysBasics {

    static int recursiveFactorial(int n) {
        if(n==1) return 1;
        return n * recursiveFactorial(n - 1);
    }//1. Base condition is important
     //2. Recursive stack - space complexity will increase
     //3. Recursive TC-O(n), SC-O(n) Iterative TC-O(n), SC-O(1)
     //4. With different size of recursive stack built other cases SC can be O(logn)

    public static void main(String[] args) {
        System.out.println(recursiveFactorial(5));
    }
}
