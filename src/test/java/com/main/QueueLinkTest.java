package com.main;

import org.junit.Assert;
import org.junit.Test;

public class QueueLinkTest {

    @Test
    public void testIsEmpty(){
        QueueLink<Integer> queue = new QueueLink<>();
        Assert.assertTrue(queue.isEmpty());
        queue.enqueue(1);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void testSize(){
        QueueLink<Integer> queue = new QueueLink<>();
        Assert.assertEquals(0,queue.size());
        queue.enqueue(1);
        Assert.assertEquals(1,queue.size());
    }

    @Test
    public void testEnqueue() {
        QueueLink<Integer> queue = new QueueLink<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertEquals(2,queue.size());
    }

    @Test
    public void testDequeue(){
        QueueLink<Integer> queue = new QueueLink<>();
        queue.enqueue(1);
        queue.enqueue(2);
        int ret = queue.dequeue();
        Assert.assertEquals(1,ret);
        ret = queue.dequeue();
        Assert.assertEquals(2,ret);
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueDequeue(){
        QueueLink<Integer> queue = new QueueLink<>();
        queue.enqueue(1);
        queue.enqueue(2);
        int ret = queue.dequeue();
        Assert.assertEquals(1,ret);
        ret = queue.dequeue();
        Assert.assertEquals(2,ret);
        Assert.assertTrue(queue.isEmpty());
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        ret = queue.dequeue();
        Assert.assertEquals(3,ret);
        Assert.assertEquals(2,queue.size());
        queue.enqueue(6);
        ret = queue.dequeue();
        Assert.assertEquals(4,ret);
        ret = queue.dequeue();
        Assert.assertEquals(5,ret);
        ret = queue.dequeue();
        Assert.assertEquals(6,ret);
        Assert.assertEquals(0,queue.size());
    }

}