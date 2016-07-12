package com.main.euler;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marie-lisehamel on 09/07/2016.
 */
public class PrimesSummationTest {

    @Test
    public void testSolve() throws Exception {

        Assert.assertEquals(2174734,PrimesSummation.solve(6000));
        Assert.assertEquals(10,PrimesSummation.solve(5));
        Assert.assertEquals(17,PrimesSummation.solve(10));
        Assert.assertEquals(381,PrimesSummation.solve(53));

    }
}