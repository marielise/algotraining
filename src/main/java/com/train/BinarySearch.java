package com.train;

/**
 * Created by mlhamel on 6/13/16.
 */
public class BinarySearch {

    private BinarySearch(){

    }

    public static int search (int []a, int key){

        int lo = 0;
        int hi = a.length -1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(a[mid] < key) {
                lo = mid +1;
            } else if(a[mid] > key) {
                hi = mid -1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int []a = { 1, 4, 8, 9, 11, 13, 14, 16, 18, 19};

        int res = search(a,8);
        System.out.println(res);
        assert res == 2;

        res = search(a,7);
        System.out.println(res);
        assert res == -1;

        res = search(a,19);
        System.out.println(res);
        assert res == 9;

        res = search(a,15);
        System.out.println(res);
        assert res == -1;

        res = search(a,13);
        System.out.println(res);
        assert res == 5;
    }
/*
    2
    -1
    9
    -1
    5
    */
}
