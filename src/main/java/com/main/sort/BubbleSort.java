package com.main.sort;

import java.util.Comparator;

/**
 * Created by marie-lisehamel on 28/06/2016.
 */
public class BubbleSort extends Sort {

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

        //assert isSorted(a, c, 0, index);
    }


    public static void sortOptimized(Comparable []a) {

    }


}
