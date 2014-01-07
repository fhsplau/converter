package com.mylib.converter.keywords;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by kacprzakp on 1/6/14.
 */
public class Dec2BinSMTest {
    private Dec2BinSM newInstance;

    @Before
    public void setUp(){
        newInstance = new Dec2BinSM();
    }

    @Test
    public void input_positiveNumber_output_properBin(){
        assertEquals("0000",newInstance.dec2binSM(0, 4));
        assertEquals("0001",newInstance.dec2binSM(1, 4));
        assertEquals("001000",newInstance.dec2binSM(8, 6));
    }

    @Test
    public void input_negativeNumber_output_properBin(){
        assertEquals("1001",newInstance.dec2binSM(-1, 4));
        assertEquals("1111",newInstance.dec2binSM(-7, 4));
        assertEquals("1101",newInstance.dec2binSM(-5, 4));
    }

    @Test
    public void input_outpu(){
        assertEquals("1111",newInstance.dec2binSM(-7, 4));
    }

    @Test
    public void input_output(){
        assertEquals("10000101",newInstance.dec2binSM(-5, 8));
    }
}
