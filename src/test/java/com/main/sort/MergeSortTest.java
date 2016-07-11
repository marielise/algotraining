package com.main.sort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testSort() throws Exception {
        Integer []a = {8,5,1,2,4,7,6};
        MergeSort.sort(a);
        Assert.assertEquals(1, (int) a[0]);
        Integer []out = {1,2,4,5,6,7,8};
        Assert.assertArrayEquals(out,a);
    }
}