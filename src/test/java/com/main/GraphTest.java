package com.main;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void testV() throws Exception {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        Assert.assertEquals(5,g.V());
    }

    @Test
    public void testAddEdge() throws Exception {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        Assert.assertEquals(3,g.E());

        g.addEdge(3,4);
        Assert.assertEquals(4,g.E());
        Graph g2 = new Graph(1);
        Assert.assertEquals(0,g2.E());
    }

    @Test
    public void testAdjDegree() throws Exception {
        Graph g = new Graph(6);
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
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(4,5);
        g.addEdge(1,4);

        Assert.assertEquals(3,Graph.maxDegree(g));
    }

    @Test
    public void testCountSelfLoops() throws Exception {
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);

        Assert.assertEquals(0, Graph.countSelfLoops(g));
        g.addEdge(1,1);
        g.addEdge(2,2);
        Assert.assertEquals(2, Graph.countSelfLoops(g));
    }

}