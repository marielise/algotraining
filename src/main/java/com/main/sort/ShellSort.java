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
/*
    private static void show(double[] a, int k, String message) {
        for (int i = 0; i < a.length; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(i, FF*k, i, FF*k + a[i]*(FF-1));
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.text(0, FF*k - 0.3, message);
    }
     public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] a = new double[n];
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
    */
}
