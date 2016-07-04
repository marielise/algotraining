package com.main.sort;

import java.util.Comparator;

/**
 * Created by marie-lisehamel on 28/06/2016.
 * 1/4 N^2 compare - 1/4 N^2 exchange
 */
public class InsertionSort extends Sort {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        if (a == null) return;

        int N = a.length;

        for(int i = 1; i <= N-1; i++) {
            Comparable x = a[i];
            int j = i;
            while ( j > 0 && less(x,a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = x;
        }

        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c) {
        if (a == null || c == null) return;

        int N = a.length;

        for(int i = 1; i <= N-1; i++) {
            Object x = a[i];
            int j = i;
            while ( j > 0 && less(c, x,a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = x;
        }

        assert isSorted(a, c);

    }

}
