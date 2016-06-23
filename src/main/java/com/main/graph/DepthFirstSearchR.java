package com.main.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mlhamel on 6/23/16.
 */
public class DepthFirstSearchR extends Search {

    public DepthFirstSearchR(Graph g, int s){
        super(g, s);
        visited[s]= true;
        dfs(s);
    }

    private void dfs(int s) {
        for(int child : g.adj(s)){
            if(!marked(child)) {
                visited[child] = true;
                dfs(child);
            }
        }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = BreadFirstSearch.class.getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());

        try {
            Graph g = new Graph(new Scanner(file));
            DepthFirstSearchR bfs = new DepthFirstSearchR(g, 0);
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
