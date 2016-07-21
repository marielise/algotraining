/*************************************************************************
 *  Compilation:  javac SelectionSort.java
 *  Execution:    java SelectionSort k
 *  Dependencies:  StdOut.java StdIn.java 
 *
 *  Description to do to change
 *
 *  % java SelectionSort 3
 *  A B C D E F
 *************************************************************************/
package com.train.sort;

import com.main.sort.Sort;

import java.util.Arrays;

/**
 * @author Marie-Lise HAMEL
 */
public class SelectionSort extends Sort {

    public static void sort(Comparable []a){
        int N = a.length;
        int indexMin;
        for(int i = 0; i < N-1; i++){
            indexMin = i;
            for(int j = i+1; j < N; j++) {
                if (less(a[j], a[indexMin]))
                    indexMin = j;
            }
            swap(a,indexMin,i);
        }

    }

    public static void main(String[] args) {
        Integer []a = {8,5,1,2,4,7,6};
        SelectionSort.sort(a);
        assert isSorted(a);
        Integer []out = {1,2,4,5,6,7,8};
        assert Arrays.deepEquals(out, a);

    }


}
