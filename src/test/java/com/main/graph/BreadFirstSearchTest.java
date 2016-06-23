package com.main.graph;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BreadFirstSearchTest {

    @Test
    public void testBFS(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());
        try {
            Graph g = new Graph(new Scanner(file));
            BreadFirstSearch bfs = new BreadFirstSearch(g, 9);

            StringBuilder strBdr = new StringBuilder();
            for (int v = 0; v < g.V(); v++)
                if (bfs.marked(v))
                    strBdr.append(v + " ");


            Assert.assertEquals("9 10 11 12 ", strBdr.toString());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}