package com.main.graph;

/**
 * Created by mlhamel on 6/17/16.
 */
public class Search {

    protected boolean []visited;
    protected final Graph g;
    protected int count;

    public Search(Graph g, int s){
        this.g = g;
        visited = new boolean[g.V()];
    }

    public boolean marked(int s){
        return visited[s];
    }

    //how many vertices are connected to s
    public int count(){
        return count;
    }

}
