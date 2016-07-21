/*************************************************************************
 *  Compilation:  javac BubbleSort.java
 *  Execution:    java BubbleSort k
 *  Dependencies:  StdOut.java StdIn.java 
 *
 *  Description to do to change
 *
 *  % java BubbleSort 3
 *  A B C D E F
 *************************************************************************/
package com.train.sort;

import com.main.sort.Sort;

import java.util.Arrays;

/**
 * @author Marie-Lise HAMEL
 */
public class BubbleSort extends Sort {

    public static void sort(Comparable []a){
        int N = a.length;
        for(int i = N-1; i >= 0; i--){
            boolean sorted = true;
            for(int j = 1; j < N; j++){
                if(less(a[j],a[j-1])){
                    swap(a, j, j-1);
                    sorted = false;
                    show(a);
                }
            }
            if(sorted) break;
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer []a = {8,5,1,2,4,7,6};
        BubbleSort.sort(a);
        assert isSorted(a);
        Integer []out = {1,2,4,5,6,7,8};
        assert Arrays.deepEquals(out, a);
        Integer []b = {4,3,2,7,1};
        BubbleSort.sort(b);
        Integer []c = {7,1,2,3,4,5};
        BubbleSort.sort(c);
    }
}
