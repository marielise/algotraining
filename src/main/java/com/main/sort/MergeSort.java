package com.main.sort;

/**
 * Created by marie-lisehamel on 28/06/2016.
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

    private static void sort(int lo, int hi, Comparable []a, Comparable []aux){
        if(hi - lo <=0) return;
        int mid = lo + (hi-lo) /2;

        sort(lo, mid, a, aux);
        sort(mid +1, hi, a, aux);
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

}
