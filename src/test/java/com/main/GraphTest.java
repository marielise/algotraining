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
    public void testE() throws Exception {
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
    public void testAddEdge() throws Exception {

    }

    @Test
    public void testAdj() throws Exception {

    }

    @Test
    public void testDegree() throws Exception {

    }

    @Test
    public void testMaxDegree() throws Exception {

    }

    @Test
    public void testCountSelfLoops() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }
}