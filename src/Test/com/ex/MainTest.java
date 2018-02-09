package com.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void sort() {
        Main m = new Main();
        int[] expected = new int[]{1,1,2,4};
        int[] example = new int[]{1,4,2,1};
        Assert.assertArrayEquals(expected,m.sort(example));
    }
}