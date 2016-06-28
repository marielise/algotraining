package com.main.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marie-lisehamel on 28/06/2016.
 */
public class StackLinkTest {

    @Test
    public void testIsEmpty() throws Exception {
        StackLink st = new StackLink();
        Assert.assertEquals(true, st.isEmpty());
    }

    @Test
    public void testPush() throws Exception {
        StackLink<Integer> st = new StackLink();
        st.push(1);
        Assert.assertEquals(false, st.isEmpty());
    }

    @Test
    public void testPop() throws Exception {
        StackLink<Integer> st = new StackLink<Integer>();
        st.push(1);
        st.push(2);
        Assert.assertEquals((Integer)2, st.pop());
        st.pop();
        Assert.assertEquals(true, st.isEmpty());
    }

    @Test
    public void testPeek() throws Exception {
        StackLink<Integer> st = new StackLink<Integer>();
        st.push(1);
        st.push(2);
        Assert.assertEquals((Integer)2, st.peek());
        st.pop();
        Assert.assertEquals(false, st.isEmpty());
        Assert.assertEquals((Integer)1, st.peek());
    }

    @Test
    public void testSize() throws Exception {
        StackLink<Integer> st = new StackLink<Integer>();
        st.push(1);
        st.push(2);
        Assert.assertEquals((Integer)2, st.peek());
        st.pop();
        Assert.assertEquals(false, st.isEmpty());
        Assert.assertEquals((Integer)1, st.peek());
        Assert.assertEquals(1, st.size());
    }
}