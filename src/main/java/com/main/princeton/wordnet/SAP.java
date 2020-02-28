package com.main.princeton.wordnet;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**---------------------------------------------------------------
 *  Author:        Marie-Lise Hamel
 *  Written:       01/28/2020
 *  Last updated:  01/28/2020
 *
 *  Compilation:   javac SAP.java
 *  Dependencies: Digraph, StdIn, StdOut
 *  Execution:     java SAP myFile.txt
 *
 *  Implement a shortest ancestral Path algorithm
 *
 *  % java SAP
 *  >
 * https://coursera.cs.princeton.edu/algs4/assignments/wordnet/faq.php
 *----------------------------------------------------------------*/

public class SAP {

  private static final int INFINITY = Integer.MAX_VALUE;

  private final Digraph digraph;
  private final LinearProbingHashST<String, Integer> previousAncestor;
  private final LinearProbingHashST<String, Integer> previousLength;
  private final Bfs bfsv;
  private final Bfs bfsw;

  // constructor takes a digraph (not necessarily a DAG)
  public SAP(Digraph digraph) {
    if (digraph == null) {
      throw new IllegalArgumentException();
    }

    this.digraph = new Digraph(digraph);

    previousAncestor = new LinearProbingHashST<>();
    previousLength = new LinearProbingHashST<>();
    bfsv = new Bfs();
    bfsw = new Bfs();

  }

  // length of shortest ancestral path between v and w; -1 if no such path
  public int length(int v, int w) {
    checkInput(v);
    checkInput(w);

    if (v == w) {
      return 0;
    }

    String key = getKey(v, w);
    if (previousLength.contains(key)) {
      return previousLength.get(key);
    }

    reinitBfs();

    Pair p = multipleBfs(v, w);

    if (p != null) {
      previousLength.put(key, p.length);
      previousAncestor.put(key, p.ancestor);

      return p.length;
    }

    previousAncestor.put(key, -1);
    previousLength.put(key, -1);

    return -1;
  }

  // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
  public int ancestor(int v, int w) {
    checkInput(v);
    checkInput(w);

    if (v == w) {
      return v;
    }

    String key = getKey(v, w);
    if (previousAncestor.contains(key)) {
      return previousAncestor.get(key);
    }

    reinitBfs();

    Pair p = multipleBfs(v, w);

    if (p != null) {
      // save results for another use
      previousLength.put(key, p.length);
      previousAncestor.put(key, p.ancestor);

      return p.ancestor;
    }

    previousAncestor.put(key, -1);
    previousLength.put(key, -1);

    return -1;
  }

  // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
  public int length(Iterable<Integer> v, Iterable<Integer> w) {
    checkIterable(v);
    checkIterable(w);

    int length = INFINITY;

    for (int vi : v) {
      for (int wi: w) {

        int lt = length(vi, wi);

        if (lt != -1) {
          if (lt < length) {
            length = lt;
          }
        }
      }
    }

    if (length != INFINITY) {
      return length;
    }

    return -1;
  }

  // a common ancestor that participates in shortest ancestral path; -1 if no such path
  public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
    checkIterable(v);
    checkIterable(w);

    int curV = -1;
    int curW = -1;
    int length = INFINITY;

    for (int vi : v) {
      for (int wi: w) {

        int lt = length(vi, wi);

        if (lt != -1 && lt < length) {
          length = lt;
          curV = vi;
          curW = wi;
        }
      }
    }

    if (length != INFINITY) {
      return ancestor(curV, curW);
    }

    return -1;
  }

  // do unit testing of this class
  public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    SAP sap = new SAP(G);
    while (!StdIn.isEmpty()) {
      int v = StdIn.readInt();
      int w = StdIn.readInt();
      int length   = sap.length(v, w);
      int ancestor = sap.ancestor(v, w);
      StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
    }
  }

  /**
   * Private tools
   */

  private void checkInput(Integer v) {
    if (v == null || v < 0 || v >= digraph.V()) {
      throw new IllegalArgumentException();
    }
  }

  private void checkIterable(Iterable<Integer> v) {
    if (v == null) {
      throw new IllegalArgumentException();
    }

    for (Integer a: v) {
      checkInput(a);
    }
  }

  private String getKey(int v, int w) {
      return v < w ? v + "-" + w : w + "-" + v;
  }

  private void reinitBfs() {
    bfsv.reinitBfs();
    bfsw.reinitBfs();
  }

  private Pair multipleBfs(int v, int w) {


    Pair currentPair = null;
    int minimalLength = INFINITY;

    bfsv.processBfs(v);
    bfsw.processBfs(w);

    for (int marked: bfsv.quickMark) {
      if (bfsw.hasPath(marked)) {
        int dist = bfsv.distTo[marked] + bfsw.distTo[marked];
        if (dist < minimalLength) {
          currentPair = new Pair();
          currentPair.ancestor = marked;
          currentPair.length = dist;
          minimalLength = dist;
        }
      }
    }

    return currentPair;
  }

  private static class Pair {
    int ancestor = -1;
    int length = -1;
  }

  private class Bfs {
    boolean[] marked;
    Bag<Integer> quickMark;
    int []distTo;

    Bfs() {
      marked = new boolean[digraph.V()];
      distTo = new int[digraph.V()];
      quickMark = new Bag<>();
      for (int v = 0; v < digraph.V(); v++) {
        distTo[v] = INFINITY;
      }
    }

    void reinitBfs() {
      if (!quickMark.isEmpty()) {
        for (int v: quickMark) {
          marked[v] = false;
          distTo[v] = INFINITY;
        }
      }
      quickMark = new Bag<>();
    }

    void processBfs(int v) {
      Bag<Integer> sources = new Bag<>();
      sources.add(v);
      processBfs(sources);
    }

    void processBfs(Iterable<Integer> sources) {
      Queue<Integer> queue = new Queue<>();

      for (int s : sources) {
        queue.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;
        quickMark.add(s);
      }

      while (!queue.isEmpty()) {
        int currentVertex = queue.dequeue();
        for (int v : digraph.adj(currentVertex)) {
          if (!marked[v]) {
            queue.enqueue(v);
            marked[v] = true;
            distTo[v] = distTo[currentVertex] + 1;
            quickMark.add(v);
          }
        }
      }
    }

    boolean hasPath(int w) {
      return marked[w];
    }
  }

}

/**
 * % cat digraph1.txt              % java-algs4 SAP digraph1.txt
 * 13                              3 11
 * 11                              length = 4, ancestor = 1
 *  7  3
 *  8  3                           9 12
 *  3  1                           length = 3, ancestor = 5
 *  4  1
 *  5  1                           7 2
 *  9  5                           length = 4, ancestor = 0
 * 10  5
 * 11 10                           1 6
 * 12 10                           length = -1, ancestor = -1
 *  1  0
 *  2  0
 */
