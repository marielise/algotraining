package com.main.graph;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdjMatrixGraphTest {

    @Test
    public void testV() throws Exception {
        AdjMatrixGraph g = new AdjMatrixGraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        Assert.assertEquals(5, g.V());
    }

    @Test
    public void testAddEdge() throws Exception {
        AdjMatrixGraph g = new AdjMatrixGraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        Assert.assertEquals(3,g.E());

        g.addEdge(3,4);
        Assert.assertEquals(4,g.E());
        AdjMatrixGraph g2 = new AdjMatrixGraph(1);
        Assert.assertEquals(0,g2.E());
    }

    @Test
    public void testAdjDegree() throws Exception {
        AdjMatrixGraph g = new AdjMatrixGraph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(4,5);

        Assert.assertEquals(2, g.degree(0));
        Assert.assertEquals(2, g.degree(1));
        Assert.assertEquals(2, g.degree(2));
        Assert.assertEquals(0, g.degree(3));
        Assert.assertEquals(1, g.degree(5));
    }

    @Test
    public void testMaxDegree() throws Exception {
        AdjMatrixGraph g = new AdjMatrixGraph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(4,5);
        g.addEdge(1,4);

        Assert.assertEquals(3,AdjMatrixGraph.maxDegree(g));
    }

    @Test
    public void testCountSelfLoops() throws Exception {
        AdjMatrixGraph g = new AdjMatrixGraph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);

        Assert.assertEquals(0, AdjMatrixGraph.countSelfLoops(g));
        g.addEdge(1, 1);
        g.addEdge(2,2);
        Assert.assertEquals(2, AdjMatrixGraph.countSelfLoops(g));
    }

    @Test
    public void testNewGraphFromFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("tinyG.txt").getFile());

        try {
            AdjMatrixGraph g = new AdjMatrixGraph(new Scanner(file));
            Assert.assertEquals(13,g.V());
            Assert.assertEquals(13,g.E());
            Assert.assertEquals(3, g.degree(9));
            Assert.assertEquals(4, g.degree(0));
            Assert.assertEquals(4, AdjMatrixGraph.maxDegree(g));
            Assert.assertEquals(0, AdjMatrixGraph.countSelfLoops(g));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}