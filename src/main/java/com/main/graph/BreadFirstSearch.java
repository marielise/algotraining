package com.main.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mlhamel on 6/13/16.
 * Non recursive method
 */
public class BreadFirstSearch extends Search {

    private Queue<Integer> q;

    public BreadFirstSearch(Graph g, int s){
        super(g,s);
        q = new LinkedList<Integer>();

    }




}
