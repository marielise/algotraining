package com.main;

import java.util.Scanner;

/**
 * Created by mlhamel on 5/26/16.
 */
public class DivisibleSumPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        if(a.length <= 1) {
            System.out.println(0);
        }

        int nbPairs = 0;
        for(int i = 0; i < a.length-1; i++){
            for(int j = i+1; j < a.length; j++){
                int sum = a[i]+a[j];
                if(sum%k ==0){
                    nbPairs++;
                }
            }
        }
        System.out.println(nbPairs);
    }

}
