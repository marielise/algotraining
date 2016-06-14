package com.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackArrayTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testIsEmpty() throws Exception {
        StackArray<Integer> st = new StackArray<>();
        Assert.assertEquals(true, st.isEmpty());
    }

    @Test
    public void testPush() throws Exception {
        StackArray<Integer> st = new StackArray<>();
        st.push(15);
        Assert.assertEquals(false, st.isEmpty());
        st.push(20);
        Assert.assertEquals(false, st.isEmpty());
        Assert.assertEquals(2, st.size());
    }

    @Test
    public void testPop() throws Exception {
        StackArray<Integer> st = new StackArray<>();
        st.push(1);
        st.push(2);
        int ret = st.pop();
        Assert.assertEquals(2, ret);
        Assert.assertEquals(false, st.isEmpty());
        ret = st.pop();
        Assert.assertEquals(1, ret);
        Assert.assertEquals(true, st.isEmpty());
    }

    @Test
    public void testPeek() throws Exception {
        StackArray<Integer> st = new StackArray<>();
        st.push(1);
        st.push(2);
        int ret = st.peek();
        Assert.assertEquals(2, ret);
        Assert.assertEquals(false, st.isEmpty());
        ret = st.peek();
        Assert.assertEquals(2, ret);
        Assert.assertEquals(2, st.size());
    }

    @Test
    public void testMultipleObject() throws Exception {
        StackArray<String> st = new StackArray<>();
        st.push("a");
        st.push("b");
        String ret = st.peek();
        Assert.assertTrue("b".equals(ret));
        Assert.assertEquals(false, st.isEmpty());
        Assert.assertEquals(2, st.size());
        ret = st.pop();
        Assert.assertTrue("b".equals(ret));
        Assert.assertEquals(1, st.size());
    }
}