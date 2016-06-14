package com.main;

import java.util.Scanner;

/**
 * Created by mlhamel on 4/25/16.
 */
public class FindSquare {

    static long goodMask; // 0xC840C04048404040 computed below
    {
        for (int i=0; i<64; ++i) goodMask |= Long.MIN_VALUE >>> (i*i);
    }

    public static boolean isSquare(long x) {
        // This tests if the 6 least significant bits are right.
        // Moving the to be tested bit to the highest position saves us masking.
        if (goodMask << x >= 0) return false;
        final int numberOfTrailingZeros = Long.numberOfTrailingZeros(x);
        // Each square ends with an even number of zeros.
        if ((numberOfTrailingZeros & 1) != 0) return false;
        x >>= numberOfTrailingZeros;
        // Now x is either 0 or odd.
        // In binary each odd square ends with 001.
        // Postpone the sign test until now; handle zero in the branch.
        if ((x&7) != 1 | x <= 0) return x == 0;
        // Do it in the classical way.
        // The correctness is not trivial as the conversion from long to double is lossy!
        final long tst = (long) Math.sqrt(x);
        return tst * tst == x;
    }

    public final static boolean isPerfectSquare(long n)
    {
        if (n < 0)
            return false;

        switch((int)(n & 0xF))
        {
            case 0: case 1: case 4: case 9:
            long tst = (long)Math.sqrt(n);
            return tst*tst == n;

            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nb = in.nextInt();

        while (--nb > -1){
            int l1 = in.nextInt();
            int l2 = in.nextInt();
            int small = (int)Math.ceil(Math.sqrt(l1));
            int high = (int)Math.floor(Math.sqrt(l2));
            int count = high - small+1;

            System.out.println(count);
        }
    }
}
