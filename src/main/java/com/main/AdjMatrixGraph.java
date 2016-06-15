package com.main;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mlhamel on 6/15/16.
 */
public class AdjMatrixGraph {

    private int V;
    private int E;

    private boolean[][] matrix;

    public AdjMatrixGraph(int v){
        V = v;
        matrix = new boolean[v][v];
    }

    public AdjMatrixGraph(Scanner in){
        this(in.nextInt());
        int edgesNb = in.nextInt();

        for(int i =0; i < edgesNb; i++){
            addEdge(in.nextInt(), in.nextInt());
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= V < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int be, int ee) {
        validateVertex(be);
        validateVertex(ee);
        E++;
        matrix[be][ee]=true;
        matrix[ee][be]=true;
    }

    public Iterable<Integer> adj(int v){
        return new MatrixIterator(matrix[v]);
    }

    public int degree(int b){
        validateVertex(b);
        int count = 0;

        for(boolean a:matrix[b]){
            if (a) count++;
        }

        return count;
    }

    public boolean contains(int be, int ee){
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


        public MatrixIterator(int v){
            this.v = v;
        }

        @Override
        public boolean hasNext() {

            while (w < V) {

            }
            return i < v;
        }

        @Override
        public Integer next() {
            return vect[i++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
