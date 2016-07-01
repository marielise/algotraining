package com.main.sort;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSort() throws Exception {
        Integer []a = {8,5,1,2,4,7,6};
        SelectionSort.sort(a);
        Assert.assertEquals(1, (int) a[0]);
        Integer []out = {1,2,4,5,6,7,8};
        Assert.assertArrayEquals(out,a);
    }

    @Test
    public void testSort1() throws Exception {

    }
}