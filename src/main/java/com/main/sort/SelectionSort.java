package com.main.sort;

import java.util.Comparator;

/**
 * First, find the smallest item in the array, and exchange it with the first entry.
 * N^2/2 compares
 */
public class SelectionSort extends  Sort {

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
            assert isSorted(a, 0, index);
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
                if(!less(c, a[lastMin], a[i])){
                    lastMin = i;
                }
            }
            swap(a,index,lastMin);
            assert isSorted(a,c, 0, index);
            index++;
        }

        assert isSorted(a, c);
    }



    public static void main(String[] args) {

    }
}
