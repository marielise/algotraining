/*************************************************************************
 *  Compilation:  javac MergeSort.java
 *  Execution:    java MergeSort k
 *  Dependencies:  StdOut.java StdIn.java 
 *
 *  Description to do to change
 *
 *  % java MergeSort 3
 *  A B C D E F
 *************************************************************************/
package com.train.sort;

import com.main.sort.Sort;

import java.util.Arrays;

/**
 * @author Marie-Lise HAMEL
 */
public class MergeSort extends Sort {

    public static void sort(Comparable []a){
        int lo = 0;
        int hi = a.length-1;
        Comparable []aux = new Comparable[a.length];
        sort(a, aux, lo, hi);
        assert isSorted(a);
    }

    private static void sort(Comparable []a,Comparable []aux,int lo, int hi){
        if(hi-lo <= 0 ) return;
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1,hi);
        merge(a, aux,lo, mid, hi);
    }

    private static void merge(Comparable []a,Comparable []aux,int lo, int mid, int hi){
        for(int i = lo; i <= hi; i++){
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid +1;
        for(int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi)  a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];

        }

    }

    public static void main(String[] args) {
        Integer []ab = {2, 4, 6, 8, 3, 9, 1, 10, 7, 5, 2, 5, 11};
        MergeSort.sort(ab);
        MergeSort.show(ab);

        Integer []a = {8,5,1,2,4,7,6};
        MergeSort.sort(a);
        assert isSorted(a);
        Integer []out = {1,2,4,5,6,7,8};
        assert Arrays.deepEquals(out, a);
    }
}
