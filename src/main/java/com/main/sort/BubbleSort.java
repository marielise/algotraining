package com.main.sort;

import java.util.Comparator;

/**
 * Created by marie-lisehamel on 28/06/2016.
 */
public class BubbleSort extends Sort {

    /**
     * Bubble sort array : not optimized version
     * @param a comparable array
     */
    public static void sort(Comparable []a){
        int N = a.length;

        for (int i = N-1; i > 0; i--){
            for(int j = 0; j <= i-1; j++){
                if(less(a[j+1], a[j])) {
                    swap(a, j+1, j);
                }
            }
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * Bubble sort array : not optimized version
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c) {
        int N = a.length;

        for (int i = N-1; i > 0; i--){
            for(int j = 0; j <= i-1; j++){
                if(less(c, a[j+1], a[j])) {
                    swap(a, j+1, j);
                }
            }
        }
        assert isSorted(a,c);

    }

    /**
     * Rearranges the array in ascending order.
     * This is the bubble sort optimized : if no swap during the loop
     * so the array is already sorted
     * @param a the array
     */
    public static void sortOptimized(Comparable []a) {

        int N = a.length;
        for (int i = N-1; i > 0; i--){
            boolean isSorted = true;
            for (int j = 0; j <= i-1; j++) {
                if (less(a[j+1], a[j])) {
                    swap(a, j+1, j);
                    isSorted = false;
                }
            }
            if(isSorted)
                return;
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * This is the bubble sort optimized : if no swap during the loop
     * so the array is already sorted
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sortOptimized(Object[] a, Comparator c) {
        int N = a.length;

        for (int i = N-1; i > 0; i--){
            boolean isSorted = true;
            for(int j = 0; j <= i-1; j++){
                if(less(c, a[j+1], a[j])) {
                    swap(a, j+1, j);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
        assert isSorted(a,c);
    }

}
