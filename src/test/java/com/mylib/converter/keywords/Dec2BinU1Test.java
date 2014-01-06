package com.mylib.converter.keywords;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kacprzakp on 1/6/14.
 */
public class Dec2BinU1Test {
    private Dec2BinU1 newInstance;

    @Before
    public void setUp() throws Exception {
        newInstance = new Dec2BinU1();
    }

    @Test
    public void input_positiveDecNumber_output_properBin(){
        assertEquals("0000",newInstance.dec2binU1(0, 4));
        assertEquals("01010",newInstance.dec2binU1(10, 5));
        assertEquals("001010",newInstance.dec2binU1(10,6));
    }

    @Test
    public void input_negativeDecNumber_output_properBin(){
        //assertEquals("1110",newInstance.dec2binU1(-1, 4));
        assertEquals("1010",newInstance.dec2binU1(-5, 4));
        assertEquals("10001110",newInstance.dec2binU1(-113, 8));
        assertEquals("11111110",newInstance.dec2binU1(-1, 8));
    }
}
