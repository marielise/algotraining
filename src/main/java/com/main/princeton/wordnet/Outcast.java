package com.main.princeton.wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**---------------------------------------------------------------
 *  Author:        Marie-Lise Hamel
 *  Written:       01/29/2020
 *  Last updated:  01/29/2020
 *
 *  Compilation:   javac Outcast.java
 *  Dependencies: WordNet, In, StdOut
 *
 *  Execution:     java Outcast arguments files
 *
 *  find outcast words form a Wordnet
 *
 *  % java Outcast synsets.txt hypernyms.txt outcast1.txt ... outcast10.txt
 *  >
 *
 *----------------------------------------------------------------*/
public class Outcast {

  private final WordNet wordnet;

  // constructor takes a WordNet object
  public Outcast(WordNet wordnet) {
    this.wordnet = wordnet;
  }

  // given an array of WordNet nouns, return an outcast
  public String outcast(String[] nouns) {

    String currentOutcast = null;
    int maxDistance = -1;

    for (String nounA: nouns) {
      int nounTotalDistance = 0;
      for (String nounB: nouns) {
        int dist = wordnet.distance(nounA, nounB);
        if (dist == -1) {
          // normally no possible, they all have at least a common ancestor
          throw new IllegalArgumentException();
        }
        nounTotalDistance += dist;

        if (nounTotalDistance > maxDistance) {
          maxDistance = nounTotalDistance;
          currentOutcast = nounA;
        }
      }
    }

    return currentOutcast;
  }


  public static void main(String[] args) {

    WordNet wordnet = new WordNet(args[0], args[1]);
    Outcast outcast = new Outcast(wordnet);

    for (int t = 2; t < args.length; t++) {
      In in = new In(args[t]);
      String[] nouns = in.readAllStrings();
      StdOut.println(args[t] + ": " + outcast.outcast(nouns));
    }
  }

}
