package com.main.sort;

/**
 * Created by mlhamel on 7/11/16.
 */
public class ShellSort extends Sort {

    public static void sort(Comparable []a){
        int n = a.length;

        int h = 1;
        //create gap
        while(h < n/3) {
            h = h *3 +1;
        }

        while(h >=1) {
            for(int i = h; i < n; i++) {

                for(int j = i ; j >= h && less(a[j], a[j-h]); j -= h) {
                        swap(a, j, j-h);
                }
                h /=3;
            }
        }
        assert isSorted(a);
    }
}
