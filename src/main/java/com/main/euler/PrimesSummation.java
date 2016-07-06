package com.main.euler;

import java.util.BitSet;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by marie-lisehamel on 05/07/2016.
 * Project Euler 10
 *
 The sum of the primes below  is .

 Find the sum of all the primes not greater than given .

 Input Format
 The first line contains an integer  i.e. number of the test cases.
 The next  lines will contains an integer .

 Output Format
 Print the value corresponding to each test case in seperate line.

 Constraint
 1 <= T <= 10^4
 1 <= N <= 10^6

 In
 2
 5
 10

 Out
 10
 17

 python solution timeout
 def _prime_sieve_eratosthenes(n):
 composites = set()
 for i in xrange(2, n):
 if i not in composites:
 composites.update(set(xrange(i*i, n, i)))
 yield i

 t = int(raw_input())

 for a0 in range(t):
 print sum(list(_prime_sieve_eratosthenes(int(raw_input())+1)))

 *
 */
public class PrimesSummation {

    private static final int limit = 1_000_000;
    private static BitSet sieve = new BitSet(limit+1);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        computePrimesOfEratosthenes(0,0);
    }

    public static void computePrimesOfEratosthenes(int begin, int end){

        final IntSummaryStatistics stats = IntStream.rangeClosed(2, limit)
                .filter(x -> !sieve.get(x))
                .peek(x -> {
                    if ((long)x*x < limit)
                        for(long i = x*x; i <= limit; i+=x)
                            sieve.set((int)i);
                })
                .summaryStatistics();
        System.out.printf("%d", stats.getCount(), stats.getSum());
    }

}
