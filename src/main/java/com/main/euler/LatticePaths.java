package com.main.euler;

import java.util.Scanner;

/**
 * Created by marie-lisehamel on 21/07/2016.
 * Eurler #15
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a  grid? As number of ways can be very large, print it modulo 10^9 + 7.
 * Input Format
    The first line contains an integer  , i.e., number of test cases.
    Next  lines will contain integers  and .

    Output Format
    Print the values corresponding to each test case.

 Constraints
 1 ≤ T ≤ 10^3
 1 ≤ N ≤ 500
 1 ≤ M ≤ 500

 Sample in
 3
 2 2
 3 2
 500 500

 Sample out
 6
 10
 159835829

 */
public class LatticePaths {

    /**
     * The number of lattice paths from  (0,0) to (n,k) is equal to the binomial coefficient (n+k)
     *                                                                                         n
     *  The number of connections can be arranged in a Pascal Triangle
     *  or
     *  (n+k)!/(n+k)!n!
     */

    public final static int MAX_N = 500;
    public final static int MAX_M = 500;
    public final static int MOD = 1000000007;
    public static int [][]triangle = new int[MAX_N+1][MAX_M+1];

    public static void main(String[] args) {
        initPascalTriangle();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(triangle[n][m]);
        }

    }


    public static void initPascalTriangle(){
        for(int i = 0; i <= MAX_N; i++) {
            triangle[i][0] = 1;
            triangle[0][i] = 1;
        }
        for(int i = 1; i <= MAX_N; i++){
            for(int j = 1; j <= MAX_M; j++){
                triangle[i][j] = (triangle[i-1][j] + triangle[i][j-1])%MOD;
            }
        }
    }


}
