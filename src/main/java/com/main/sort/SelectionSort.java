package com.main.sort;

import java.util.Comparator;

/**
 * First, find the smallest item in the array, and exchange it with the first entry.
 */
public class SelectionSort {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        if (a == null)
            return;
        int N = a.length;

        if(N < 2) {
            return;
        }

        int index = 0;

        while(index < N) {
            int lastMin = index;
            for (int i = index +1; i < N; i++) {
                if(!less(a[lastMin], a[i])){
                    lastMin = i;
                }
            }
            swap(a,index,lastMin);
            index++;
        }

        assert isSorted(a);
    }


    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c) {

    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void swap(Object []a, int i, int j){
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /*=====================================================
        Checking tools
     */


    private static boolean isSorted(Comparable[] a) {
        if (a.length < 2)
            return true;

        Comparable prev = a[0];
        for(int i = 1; i < a.length; i++){
                if(!less(prev, a[i])) return false;
            prev = a[i];
        }
        return true;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        return false;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator c) {
        return false;
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        return false;
    }

    // print array to standard output
    private static void show(Comparable[] a) {

    }
}
