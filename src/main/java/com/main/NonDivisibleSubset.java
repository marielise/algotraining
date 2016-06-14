package com.main;

import java.util.Scanner;

/**
 * Created by mlhamel on 5/26/16.
 */
public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int []L = new int[k];
        for(int i = 0; i < a.length; i++){
            L[a[i] % k] += 1;
        }

        int next = (k/2)+1;
        int res = 0;
        for(int i = 0; i < next; i++) {
            if (i==0 || k == (i*2)){
                if (L[i] !=0) {
                    res += 1;
                }
            } else {
                res += Math.max(L[i], L[k-i]);
            }
        }

        System.out.println(res);
    }
}

/*
input
4 3
1 7 2 4

output
3

The largest possible subset of integers is , because no two integers will have a sum that is evenly divisible by :

1 + 7 = 8 and  is not evenly divisible by 3.
1 + 4 = 5, and  is not evenly divisible by 3.
7 + 4 = 11, and  is not evenly divisible by 3.
The number 2 cannot be included in our subset because it will produce an integer that is evenly divisible by k=3
when summed with any of the other integers in our set:

1 + 2 = 3
4 + 2 = 6
7 + 2 = 9

print the length of subset + 3

 */