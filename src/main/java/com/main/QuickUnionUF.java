package com.main;

import java.util.Arrays;

/**
 * Created by mlhamel on 2/12/16.
 */
public class QuickUnionUF {

    private int [] ar;
    private int count;

    public QuickUnionUF(int size){
        ar = new int[size];
        Arrays.setAll(ar, index -> index);
        count = size;
    }

    public void union(int p, int q){
        int i = getRoot(p);
        int j = getRoot(q);
        ar[i] = j;
        count--;
    }

    public int find(int p){
        return ar[p];
    }

    public boolean connected(int p, int q){

        return getRoot(p) == getRoot(q);
    }
/*
    private int getRoot(int p){

        if(p == ar[p]) return p;

        return getRoot(ar[p]);
    }*/

    /* careful, p, modified */
      private int getRoot(int p){

        while (p != ar[p]) p = ar[p];
        return p;
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        //read file

    }

}
