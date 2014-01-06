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
    public void input_zeroAndFourBits_output_0000(){
        assertEquals("0000", newInstance.dec2binu2(0, 4));
    }

    @Test
    public void input_oneAndFourBits_output_0001(){
        assertEquals("0001",newInstance.dec2binu2(1,4));
    }

    @Test
    public void input_minusOneAndFourBits_output_1111(){
        assertEquals("1111",newInstance.dec2binu2(-1,4));
    }
}
