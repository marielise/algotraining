package com.main.sort;

import java.util.Comparator;

/**
 * Created by mlhamel on 7/1/16.
 */
public class Sort {

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    public static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    public static void swap(Object []a, int i, int j){
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /*=====================================================
        Checking tools
     */


    public static boolean isSorted(Comparable[] a) {
        if (a.length < 2)
            return true;

        for(int i = 0; i < a.length-1; i++){
            if(!less(a[i], a[i+1])) return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        return false;
    }

    // is the array a[] sorted?
    public static boolean isSorted(Object[] a, Comparator c) {
        if (a.length < 2)
            return true;

        for(int i = 0; i < a.length-1; i++){
            if(!less(c, a[i], a[i+1])) return false;
        }
        return true;
    }

    // is the array sorted from a[lo] to a[hi]
    public static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        return false;
    }

    // print array to standard output
    public static void show(Comparable[] a) {

    }
}
