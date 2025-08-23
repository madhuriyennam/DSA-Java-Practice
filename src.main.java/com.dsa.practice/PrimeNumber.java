package com.dsa.practice;

import java.util.*;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 50;
        List<Integer> primes = sieveOfEratosthenes(n);
        System.out.println(primes);
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        // Eliminate non-primes
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect primes
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}

