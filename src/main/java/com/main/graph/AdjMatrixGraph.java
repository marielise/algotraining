package com.main.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by mlhamel on 6/15/16.
 */
public class AdjMatrixGraph {

    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;

    private boolean[][] matrix;

    public AdjMatrixGraph(int v) {
        V = v;
        matrix = new boolean[v][v];
    }

    public AdjMatrixGraph(Scanner in) {
        this(in.nextInt());
        int edgesNb = in.nextInt();

        for (int i = 0; i < edgesNb; i++) {
            addEdge(in.nextInt(), in.nextInt());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= V < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public void addEdge(int be, int ee) {
        validateVertex(be);
        validateVertex(ee);
        E++;
        matrix[be][ee] = true;
        matrix[ee][be] = true;
    }

    public Iterable<Integer> adj(int v) {
        return new MatrixIterator(v);
    }

    public int degree(int b) {
        validateVertex(b);
        int count = 0;

        for (boolean a : matrix[b]) {
            if (a) count++;
        }

        return count;
    }

    public static int maxDegree(AdjMatrixGraph g) {
        int maxDeg = 0;
        for (int i = 0; i < g.V(); i++) {
            int dg = g.degree(i);
            if (dg > maxDeg) {
                maxDeg = dg;
            }
        }
        return maxDeg;
    }

    public static int countSelfLoops(AdjMatrixGraph g) {
        int count = 0;
        for (int i = 0; i < g.V(); i++) {
            for (int v : g.adj(i)) {
                if (i == v) {
                    count++;
                }
            }
        }
        //only once
        return count;
    }

    public boolean contains(int be, int ee) {
        return matrix[be][ee];
    }

    private class MatrixIterator implements Iterator<Integer>, Iterable<Integer> {

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        private int i = 0;
        private int v = 0;
        private int w = 0;


        public MatrixIterator(int v) {
            this.v = v;
        }

        @Override
        public boolean hasNext() {

            while (w < V) {
                if (matrix[v][w])
                    return true;
                w++;
            }
            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ClassLoader classLoader = Graph.class.getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());
        try {
            AdjMatrixGraph g = new AdjMatrixGraph(new Scanner(file));
            System.out.println(g.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
