package com.main.sort;

import java.util.Comparator;

/**
 * Created by marie-lise hamel on 28/06/2016.
 * Use merge sort top down with temp array
 * Running time n log n
 * N log N compares (optimal)
 * but uses 2N space memory => in place marge sort
 *
 * Improvements : to much overhead for small arrays
 * Use insertion sort if array <= 7 items
 * TODO: add cut off
 *
 * Improvements : avoid copying the array
 * Alternate aux and a array between merge and split
 * Do not save space but save time
 * TODO: alternate with temp array
 */
public class MergeSort extends Sort {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * Top down merge sort
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        if (a == null) return;

        int N = a.length;
        int lo = 0;
        int hi = N-1;
        Comparable []aux = new Comparable[N];
        sort(lo, hi, a, aux);
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
        int lo = 0;
        int hi = N-1;
        Object []aux = new Object[N];
        sort(lo, hi, a, aux, c);
        assert isSorted(a, c);
    }


    /* =============================================================
        Sort private methods with comparable
     */

    private static void sort(int lo, int hi, Comparable []a, Comparable []aux){
        if(hi - lo <=0) return;
        int mid = lo + (hi-lo) /2;

        sort(lo, mid, a, aux);
        sort(mid + 1, hi, a, aux);
        //improvement if already sorted
        if(!less(a[mid+1],a[mid])) return;
        merge(lo,mid, hi,a, aux);
    }

    private static void merge(int lo, int mid, int hi, Comparable []a, Comparable []aux) {
        if(hi - lo <=0) return;
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        //Copy
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid +1;
        for(int k = lo; k <= hi; k++){
            //merge the remaining right part
            if (i > mid) a[k] = aux[j++];
            //merge the remaining left part
            else if (j > hi) a[k] = aux[i++];
            //right part less than left
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];

        }
    }

    /* =============================================================
        Sort private methods with comparator
     */

    private static void sort(int lo, int hi, Object []a, Object []aux, Comparator c){
        if(hi - lo <=0) return;
        int mid = lo + (hi-lo) /2;

        sort(lo, mid, a, aux, c);
        sort(mid + 1, hi, a, aux, c);
        //improvement if already sorted
        if(!less(c, a[mid+1],a[mid])) return;
        merge(lo,mid, hi,a, aux, c);
    }

    private static void merge(int lo, int mid, int hi, Object []a, Object []aux, Comparator c) {
        if(hi - lo <=0) return;
        assert isSorted(a,c, lo, mid);
        assert isSorted(a,c, mid+1, hi);

        //Copy
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid +1;
        for(int k = lo; k <= hi; k++){

            //merge the remaining right part
            if (i > mid) a[k] = aux[j++];

            //merge the remaining left part
            else if (j > hi) a[k] = aux[i++];

            //right part less than left
            else if (less(c, aux[j],aux[i])) a[k] = aux[j++];

            else a[k] = aux[i++];

        }
    }

}
