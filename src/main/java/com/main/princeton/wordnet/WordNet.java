package com.main.princeton.wordnet;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

/**---------------------------------------------------------------
 *  Author:        Marie-Lise Hamel
 *  Written:       01/28/2020
 *  Last updated:  01/28/2020
 *
 *  Compilation:   javac WordNet.java
 *  Dependencies: Digraph, LinearProbingHashST, ResizableArrayList, SAP
 *
 *  Execution:     java WordNet arguments files
 *
 *  Implement an immutable data type WordNet
 *
 *  % java WordNet file1.txt file2.txt
 *  >
 *
 *----------------------------------------------------------------*/
public class WordNet {

  private final LinearProbingHashST<String, Bag<Integer>> nounMap;
  private final ST<Integer, String> synsetsList;
  private final SAP sap;

  // constructor takes the name of the two input files
  public WordNet(String synsets, String hypernyms) {

    if (synsets == null || hypernyms == null) {
      throw new IllegalArgumentException();
    }

    synsetsList = new ST<>();
    nounMap = new LinearProbingHashST<>();

    readCsvSynset(synsets);
    sap = new SAP(readHypernyms(hypernyms));

  }
  // returns all WordNet nouns
  public Iterable<String> nouns() {
    return nounMap.keys();
  }

  // is the word a WordNet noun?
  public boolean isNoun(String word) {
    if (word == null) {
      throw new IllegalArgumentException();
    }
    return nounMap.contains(word);
  }

  // distance between nounA and nounB (defined below)
  public int distance(String nounA, String nounB) {
    checkNoun(nounA);
    checkNoun(nounB);

    return sap.length(nounMap.get(nounA), nounMap.get(nounB));
  }

  // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
  // in a shortest ancestral path (defined below)
  public String sap(String nounA, String nounB) {
    checkNoun(nounA);
    checkNoun(nounB);
    int ancestor = sap.ancestor(nounMap.get(nounA), nounMap.get(nounB));
    return synsetsList.get(ancestor);
  }

  // do unit testing of this class
  public static void main(String[] args) {
    WordNet n = new WordNet(args[0], args[1]);
    while (!StdIn.isEmpty()) {
      String nounA = StdIn.readString();
      String nounB = StdIn.readString();
      String ancestor = n.sap(nounA, nounB);
      int length = n.distance(nounA, nounB);
      StdOut.printf("length = %s, ancestor = %s\n", length, ancestor);
    }
  }

  /* --------------------------------------------
   * Private tools methods
   *---------------------------------------------*/

  private void checkNoun(String noun) {
    if (noun == null || noun.isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (!isNoun(noun)) {
      throw new IllegalArgumentException();
    }
  }

  // Rooted DAG => only one vertice with no outdegree
  private boolean isRooted(Digraph digraph) {
    boolean isRooted = false;
    for (int v = 0; v < digraph.V(); v++) {
      if (digraph.outdegree(v) == 0) {
        if (isRooted) {
          return false;
        }
        isRooted = true;
      }
    }
    return isRooted;
  }

  private void readCsvSynset(String fileName) {

    In in = new In(fileName);

    while (in.hasNextLine()) {
      String line = in.readLine();
      String[] tokens = line.split(",");
      int lineNumber = Integer.parseInt(tokens[0]);
      String value = tokens[1];

     synsetsList.put(lineNumber, value);

      String[] values = value.split(" ");
      for (String val:values) {
        Bag<Integer> listValues;
        if (!nounMap.contains(val)) {
          listValues = new Bag<>();
          nounMap.put(val, listValues);
        } else {
          listValues = nounMap.get(val);
        }

        listValues.add(lineNumber);
      }

    }
  }

  private Digraph readHypernyms(String fileName) {
    Digraph digraph = new Digraph(synsetsList.size());

    In in = new In(fileName);
    while (in.hasNextLine()) {
      String line = in.readLine();
      String[] tokens = line.split(",");
      int v = Integer.parseInt(tokens[0]);

      if (tokens.length > 1) { // check if we do not have an alone thing
        for (int i = 1; i < tokens.length; i++) {
          int w = Integer.parseInt(tokens[i]);
          digraph.addEdge(v, w);
        }
      }
    }
    Topological tp = new Topological(digraph);

    if (!tp.hasOrder() || !isRooted(digraph)) {
      throw new IllegalArgumentException();
    }
    return digraph;
  }

}

/**
 * ROOT of DAG
 * 38003,entity,that which is perceived or known or inferred to have its own distinct existence (living or nonliving)
 */
