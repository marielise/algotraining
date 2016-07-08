package com.main.euler;

import java.util.BitSet;
import java.util.Scanner;
import java.util.TreeSet;
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
 Print the value corresponding to each test case in separate line.

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

 Maths:
 0 and 1 are not primes numbers

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

    private static TreeSet<Prime> sumSet = new TreeSet();

    private static int begin = 2;
    private static int lastEnd = 0;
    private static int lastSum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNb = in.nextInt();
        while(0 < testNb--) {
            int end = in.nextInt();
            if(lastEnd < end) {
                computePrimesOfEratosthenesWithBitSet(begin, end);
                lastEnd = end;
                begin = end;
            }
            Prime p = new Prime(end, 0);
            Prime psum = sumSet.ceiling(p);
            System.out.println(psum.getSumOfPrime());
        }
    }

    /**
     *
     * @param begin
     * @param end
     */
    public static void computePrimesOfEratosthenesWithBitSet(int begin, int end){

         IntStream.rangeClosed(begin, end)
                .filter(x -> !sieve.get(x))
                .peek(x -> {
                    //manage sum
                    lastSum += x;
                    sumSet.add(new Prime(x,lastSum));
                    if ((long)x*x < end)
                        for(long i = x*x; i <= end; i+=x)
                            sieve.set((int)i);
                });

    }

    public static class Prime implements Comparable<Prime> {
        private int prime;
        private int sumOfPrime;

        public Prime(int prime, int sum){
            this.prime = prime;
            this.sumOfPrime = sum;
        }

        @Override
        public int compareTo(Prime o) {
            if (this.getPrime() < o.getPrime()) return -1;
            if (this.getPrime() > o.getPrime()) return 1;

            return 0;
        }

        public int getPrime() {
            return prime;
        }

        public void setPrime(int prime) {
            this.prime = prime;
        }

        public int getSumOfPrime() {
            return sumOfPrime;
        }

        public void setSumOfPrime(int sumOfPrime) {
            this.sumOfPrime = sumOfPrime;
        }
    }
}
