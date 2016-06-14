package com.main;

import java.util.Arrays;

/**
 * Created by mlhamel on 2/12/16.
 */
public class QuickFindUF {

    private int [] ar;
    private int count;

    public QuickFindUF(int size){
        ar = new int[size];
        Arrays.setAll(ar, index -> index);
        count = size;
    }

    public void union(int p, int q){

        int pid = ar[p];
        int qid = ar[q];

        for(int i =0; i < ar.length; i++){
            if(ar[i] == qid) {
                ar[i] = pid;
            }
        }

        count--;
    }

    public int find(int p){
        return ar[p];
    }

    public boolean connected(int p, int q){
        return ar[p] == ar[q];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        //read file

    }

}
