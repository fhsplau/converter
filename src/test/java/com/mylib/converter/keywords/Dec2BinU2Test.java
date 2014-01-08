package com.mylib.converter.keywords;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Created by kacprzakp on 1/3/14.
 */
public class Dec2BinU2Test {
    private Dec2BinU2 newInstance;

    @Before
    public void setUp() throws Exception {
        newInstance = new Dec2BinU2();
    }

    @Test
    public void input_zeroAndFourBits_output_000000(){
        assertEquals("000000", newInstance.dec2binU2(0, 6));
    }

    @Test
    public void input_oneAndFourBits_output_00001(){
        assertEquals("00001",newInstance.dec2binU2(1, 5));
    }
    @Test
    public void input_twoAndFourBits_output_0010(){
        assertEquals("0010",newInstance.dec2binU2(2, 4));
    }

    @Test
    public void input_sixAndFiveBits_output_00110(){
        assertEquals("00110",newInstance.dec2binU2(6, 5));
    }

    @Test
    public void input_minusEigthAndFourBits_output_1000(){
        assertEquals("1000",newInstance.dec2binU2(-8, 4));
        assertEquals("10000",newInstance.dec2binU2(-16, 5));
    }

    @Test
    public void input_minusOneAndFourBits_output_1111(){
        assertEquals("1111",newInstance.dec2binU2(-1, 4));
        assertEquals("101011",newInstance.dec2binU2(-21, 6));
        assertEquals("11010011",newInstance.dec2binU2(-45, 8));
    }
}
