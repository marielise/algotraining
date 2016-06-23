package com.main.graph;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DepthFirstSearchRTest {

    @Test
    public void testDFS(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());
        try {
            Graph g = new Graph(new Scanner(file));
            DepthFirstSearchR dfs = new DepthFirstSearchR(g, 9);

            StringBuilder strBdr = new StringBuilder();
            for (int v = 0; v < g.V(); v++)
                if (dfs.marked(v))
                    strBdr.append(v + " ");


            Assert.assertEquals("9 10 11 12 ", strBdr.toString());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}