package com.main.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mlhamel on 6/13/16.
 * Non recursive method
 */
public class BreadFirstSearch extends Search {

    private Queue<Integer> q;

    public BreadFirstSearch(Graph g, int s){
        super(g,s);
        q = new LinkedList<Integer>();
        visited[s] = true;
        q.add(s);
        bfs();
    }

    private void bfs(){
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int next:g.adj(cur)){
                if(!marked(next)){
                    count++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = BreadFirstSearch.class.getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());

        try {
            Graph g = new Graph(new Scanner(file));
            BreadFirstSearch bfs = new BreadFirstSearch(g,0);
            System.out.println(g.toString());

            for (int v = 0; v < g.V(); v++)
                if (bfs.marked(v))
                    System.out.print(v + " ");
            System.out.println();

            if(bfs.count() != g.V())
                System.out.print("Not ");
            System.out.println("connected");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
