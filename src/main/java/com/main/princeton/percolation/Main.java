package com.main.princeton.percolation;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    String path = args[0];

    File dir = new File(path);
    File[] files = dir.listFiles();

    for (File f : files) {

      if (f.getName().endsWith(".txt")) {
        System.out.println(f.getName());
        Stopwatch timer1 = new Stopwatch();
        In in = new In(f.getAbsolutePath());
        int n = in.readInt();

        Percolation percolation = new Percolation(n);

        int steps = 0;
        while (!in.isEmpty()&& !percolation.percolates()) {

          int row = in.readInt();
          int col = in.readInt();

          //StdOut.println(row + " " + col);

          if (!percolation.isOpen(row, col)) {
            percolation.open(row, col);
            steps++;
          }

        }

        StdOut.println("took " + timer1.elapsedTime());

        if (percolation.percolates()) {
          StdOut.println("the system percolates after " + steps + " / " + n * n);
        } else {
          StdOut.println("the system does not percolates" );
        }

      }
    }
  }

}
