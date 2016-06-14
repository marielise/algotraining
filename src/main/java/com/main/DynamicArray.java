package com.main;

import java.util.Scanner;

/**
 * Created by mlhamel on 5/3/16.
 */
public class DynamicArray {

    public static int lastAns = 0;
    /*

    2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1

7
3
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nb = in.nextInt();

        int[][] seqList = new int[n][];
        for(int i = 0; i < nb; i++){
            int q = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int seq = ((x^lastAns) %n);

            if(q == 1) addSeq(seq, seqList, y);
            else printSeq(seq, seqList, y);
        }
    }

    public static void addSeq(int seq, int[][] seqList, int toAdd){
        if(seqList[seq] == null) {
            int [] innerSeq = new int[1];
            innerSeq[0] = toAdd;
            seqList[seq] = innerSeq;
        } else {
            //resize array
            int []oldSeq = seqList[seq];
            int []newSeq = new int[oldSeq.length+1];
            for(int i = 0; i < oldSeq.length; i++){
                newSeq[i] = oldSeq[i];
            }

            newSeq[oldSeq.length] = toAdd;
            seqList[seq] = newSeq;
        }
    }

    public static void printSeq(int seq, int[][] seqList, int y){
        int []oldSeq = seqList[seq];
        int index = y % oldSeq.length;

        lastAns = oldSeq[index];
        System.out.println(lastAns);
    }

}
