package com.main.princeton.percolation;/*----------------------------------------------------------------
 *  Author:        Marie-Lise Hamel
 *  Written:       01/07/2015
 *  Last updated:  05/07/2015
 *
 *  Compilation:   javac Percolation.java
 *  Dependencies: WeightedQuickUnionUF, Stopwatch, StdOut
 *  Execution:     java Percolation
 *
 *  Compute percolation of a matrix with size N * N
 *  Print result of percolation
 *  Take N integer on standard input
 *
 *  % java Percolation
 *  > 10
 *
 *----------------------------------------------------------------*/

import edu.princeton.cs.algs4.*;

/**
 * Percolation class
 * the matrix status (open, blocked) is represented by a one dimension boolean array
 * Use 2 union find algorithms to manage percolation and full sites
 * first contains 2 additional nodes on top and bottom
 * the full UF contains only one additional top node
 *
 * The main program takes the grid size N as a standard input.
 * And randomly open sites until it percolates
 *
 * @author Marie-Lise HAMEL
 */
public class Percolation {

    private boolean [] status;   // contains status of the sites
    private int N;              // size of the side of the matrix
    private int matrixSize;     // stock total size of the matrix
    private WeightedQuickUnionUF uf;    // Weighted union find for percolation
    private WeightedQuickUnionUF ufFull; // Weighted union find for full connection

    /**
     * Constructor : init status to blocked, init quick union algorithm
     * with size N * N +2 to manage global top and bottom nodes
     * @param N size of the side of the matrix
     * @throws java.lang.IllegalArgumentException if N is <= 0
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be > 0");
        }

        this.N = N;
        matrixSize = N * N;
        status = new boolean[matrixSize]; // by default all sites are blocked = false

        // add 2 nodes : first is for top row, last is for bottom row
        uf = new WeightedQuickUnionUF(matrixSize +2);
        // add only 1 global node at the top
        ufFull = new WeightedQuickUnionUF(matrixSize+1);
    }

    /**
     * Method used to open a site on the matrix
     * Check the limit, change the status of the site and connect the site
     * to his neighbors except the corners
     * @param i row of the matrix
     * @param j column of the matrix
     * @throws java.lang.IndexOutOfBoundsException if i or j are not on the grid
     */
    public void open(int i, int j) {
        checkMatrixBoundaries(i, j);
        int index = convert2Dto1D(i, j);

        // if already opened, return
        if (status[index-1])
            return;

        // open site
        status[index-1] = true;

        // first row, connect to global first node for full and connect
        if (i == 1) {
            uf.union(0, index);
            ufFull.union(0, index);
        }
        // manage bottom row
        if (i == N) {
            //connect to the bottom node for connect
            uf.union(matrixSize+1, index);
        }

        // connected to neighbors
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue; // main node
                }
                // avoid corners
                if (Math.abs(x) + Math.abs(y) > 1) {
                    continue;
                }

                // extract neighbor position to avoid multiple computation
                int posX = j + x;
                int posY = i + y;

                // check if candidate to union
                if (isOnGrid(posY, posX) && isOpen(posY, posX)) {
                    uf.union(index, convert2Dto1D(posY, posX));
                    ufFull.union(index, convert2Dto1D(posY, posX));
                }
            }
        }
    }

    /**
     * Check if the site is open
     * @param i row of the matrix
     * @param j column of the matrix
     * @return boolean true if open
     * @throws java.lang.IndexOutOfBoundsException if i or j are not on the grid
     */
    public boolean isOpen(int i, int j) {
        checkMatrixBoundaries(i, j);
        return status[convert2Dto1D(i, j) -1];
    }

    /**
     * Check if the site is connected to top global node
     * @param i row of the matrix
     * @param j column of the matrix
     * @return boolean tru if connected
     * @throws java.lang.IndexOutOfBoundsException if i or j are not on the grid
     */
    public boolean isFull(int i, int j) {
        checkMatrixBoundaries(i, j);
        return ufFull.connected(0, convert2Dto1D(i, j));
    }

    /**
     * Check if first global node is connected to last global node
     * @return boolean true if system percolates
     */
    public boolean percolates() {
        return uf.connected(0, matrixSize +1);
    }

    /**
     * Reads in an integer (between 1 and N) from standard input
     * Perform random percolation
     * print elapsed time and percolation result
     */
    public static void main(String[] args) {

        int N = StdIn.readInt();

        Stopwatch stopwatch = new Stopwatch();

        Percolation percolation = new Percolation(N);

        int steps = 0;

        while (!percolation.percolates()) {
            int row = StdRandom.uniform(1, N+1);
            int col = StdRandom.uniform(1, N+1);
            StdOut.println(row + " " + col);
            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
                steps++;
            }

        }

        StdOut.println("took " + stopwatch.elapsedTime());

        StdOut.println("the system percolates after " + steps + " / " + N * N);

    }

    /* --------------------------------------------
     * Private tools methods
     *
     * method isOnTheGrid has been separated to be used in close neighbor algorithm
     *---------------------------------------------*/

    /**
     * Check if the site is on the grid
     * @param i row of the matrix
     * @param j column of the matrix
     * @return boolean true if the site is on the grid
     */
    private boolean isOnGrid(int i, int j) {
        return i > 0 && j > 0 && i <= N && j <= N;
    }

    /**
     * to manage exception if i or j are out of the matrix
     * @param i row of the matrix
     * @param j column of the matrix
     * @throws  java.lang.IndexOutOfBoundsException if i or j not on the grid
     */
    private void checkMatrixBoundaries(int i, int j) {
        if (!isOnGrid(i, j))
            throw new IndexOutOfBoundsException("Column or row not in 1 and " + N);

    }

    /**
     * Convert a 2D point into a 1D point
     * @param i row of the matrix
     * @param j column of the matrix
     * @return int 1D point index
     */
    private int convert2Dto1D(int i, int j) {
        // pos on the line + row * size of a row
        return j + ((i-1) * N);
    }

}
