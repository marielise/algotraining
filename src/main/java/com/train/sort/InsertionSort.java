/*************************************************************************
 *  Compilation:  javac InsertionSort.java
 *  Execution:    java InsertionSort k
 *  Dependencies:  StdOut.java StdIn.java 
 *
 *  Description to do to change
 *
 *  % java InsertionSort 3
 *  A B C D E F
 *************************************************************************/
package com.train.sort;

import com.main.sort.Sort;

import java.util.Arrays;

/**
 * @author Marie-Lise HAMEL
 */
public class InsertionSort extends Sort {

    public static void sort(Comparable []a){
        int N = a.length;

        for(int i = 1 ; i < N; i++){
            Comparable key = a[i];
            int j = i;
            while( j > 0 && less(key, a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer []ab = {2, 4, 6, 8, 3};
        InsertionSort.sort(ab);

        Integer []a = {8,5,1,2,4,7,6};
        InsertionSort.sort(a);
        assert isSorted(a);
        Integer []out = {1,2,4,5,6,7,8};
        assert Arrays.deepEquals(out, a);

    }
}
