package com.main.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mlhamel on 6/13/16.
 */
public class Graph {

    //number of vertices
    private int V;
    //number of edges
    private int e;

    private List<Integer> []adj;

    public Graph(int v){
        this.V = v;
        adj = new List[v];

        for(int i=0; i < v; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public Graph(Scanner in){
        this(in.nextInt());
        int edNb = in.nextInt();
        for(int i = 0; i < edNb; i++) {
            addEdge(in.nextInt(), in.nextInt());
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return e;
    }

    // throw an IndexOutOfBoundsException unless 0 <= V < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int be, int ee){
        validateVertex(be);
        validateVertex(ee);
        e++;
        //add both direction
        adj[be].add(ee);
        adj[ee].add(be);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int degree(int b){
        validateVertex(b);
        return adj[b].size();
    }

    public static int maxDegree(Graph g){
        int maxDeg = 0;
        for(int i = 0; i < g.V(); i++){
            int dg = g.degree(i);
            if(dg > maxDeg){
                maxDeg = dg;
            }
        }
        return maxDeg;
    }

    public static int countSelfLoops(Graph g){
        int count = 0;
        for(int i = 0; i < g.V(); i++){
            for(int v: g.adj(i)){
                if (i == v){
                    count++;
                }
            }
        }

        return count/2;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Vertices => ").append(V).append("    Edges => ").append(e).append("\n");
        for(int i = 0; i < V; i++) {
            str.append(i).append(" => ");
            for(Integer ed:adj(i)) {
                str.append(ed).append(" ");
            }
            str.append("\n");
        }

        return str.toString();
    }


    public static void main(String [] args) {
        ClassLoader classLoader = Graph.class.getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());
        try {
            Scanner in = new Scanner(file);
            Graph g = new Graph(in);
            System.out.println(g.toString());
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }


    }

    /**
     IN:
     13
     13
     0 5
     4 3
     0 1
     9 12
     6 4
     5 4
     0 2
     11 12
     9 10
     0 6
     7 8
     9 11
     5 3

     */

}
