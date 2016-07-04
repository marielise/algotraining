package com.main.sort;

import com.main.objects.ObjectToCompare;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void testSort() throws Exception {
        Integer []a = {8,5,1,2,4,7,6};
        InsertionSort.sort(a);
        Assert.assertEquals(1, (int) a[0]);
        Integer []out = {1,2,4,5,6,7,8};
        Assert.assertArrayEquals(out,a);
    }

    @Test
    public void testSortWithComparator() throws Exception {
        ObjectToCompare[]a = {new ObjectToCompare(1,1),
                new ObjectToCompare(2,2),
                new ObjectToCompare(9,9),
                new ObjectToCompare(3,5),
                new ObjectToCompare(2,3),
                new ObjectToCompare(4,2),
                new ObjectToCompare(1,7)};

        ObjectToCompare.ObjectComparator c = new ObjectToCompare.ObjectComparator();

        InsertionSort.sort(a, c);
        Assert.assertTrue("1 1 => 1".equals(a[0].toString()));
        Assert.assertTrue("9 9 => 81".equals(a[6].toString()));
    }
}