package com.main;

import org.junit.Assert;
import org.junit.Test;

public class QuickFindUFTest {

    @Test
    public void testCount() throws Exception {
        QuickFindUF q = new QuickFindUF(10);
        Assert.assertEquals(10,q.count());
        q.union(0,1);
        Assert.assertEquals(9,q.count());
    }

    @Test
    public void testUnion() throws Exception {
        QuickFindUF q = new QuickFindUF(10);
        q.union(0,1);
        q.union(1,2);
        q.union(2,3);
        Assert.assertEquals(7,q.count());
        Assert.assertTrue(q.connected(0,3));
    }

    @Test
    public void testFind() throws Exception {
        QuickFindUF q = new QuickFindUF(10);
        q.union(0,1);
        q.union(1,2);
        q.union(2,3);

        Assert.assertEquals(q.find(1),q.find(3));
    }

    @Test
    public void testConnected() throws Exception {
        QuickFindUF q = new QuickFindUF(10);
        q.union(0,1);
        q.union(1,2);
        q.union(2,3);
        q.union(4,3);

        Assert.assertFalse(q.connected(0,8));
        Assert.assertTrue(q.connected(4,0));
    }


}