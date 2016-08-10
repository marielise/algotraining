package com.main.sort;

import com.main.tools.StdDraw;
import com.main.tools.StdRandom;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by mlhamel on 7/11/16.
 */
public class ShellSort extends Sort {

    private static final int FF = 4;

    public static void sort(Comparable []a){
        int n = a.length;

        int h = 1;
        int k = 1;
        //create gap
        while(h < n/3) {
            h = h *3 +1;
            k++;
        }

        show(a, k, "input");
        k--;

        while(h >=1) {
            for(int i = h; i < n; i++) {

                for(int j = i ; j >= h && less(a[j], a[j-h]); j -= h) {
                    swap(a, j, j-h);
                    showBars(a, k, j, j-h);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (h < n) show(a, --k, h + "-sorted");
            h /=3;
        }
        assert isSorted(a);
    }

    private static void showBars(Comparable[] a, int k, int i,int j){
        //paint white
        //replace
        //paint white
        //replace
    }

    private static void show(Comparable[] a, int k, String message) {
        for (int i = 0; i < a.length; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(i, FF*k, i, FF*k + (double)a[i]*(FF-1));
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.text(0, FF*k - 0.3, message);
        StdDraw.show();
    }

     public static void main(String[] args) {
         Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
          a[i] = StdRandom.uniform(0.0, 1.0);
        int k = (int) Math.round(Math.log(n) / Math.log(3));  // number of h-increment values

        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(756, 900);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 9));
        StdDraw.setXscale(-1, n+1);
        StdDraw.setYscale(-1, FF*(k+1));
        StdDraw.setPenRadius(0.005);
        sort(a);
        StdDraw.show();
    }

}
