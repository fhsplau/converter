package com.mylib.converter.keywords;

import com.mylib.converter.keywords.Bin2Dec;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by paverell on 1/2/14.
 */
public class Bin2DecTest {
    private Bin2Dec newInstance;

    @Before
    public void setUp(){
        newInstance = new Bin2Dec();
    }

    @Test
    public void input_ZeroOrOne_to_bin2dec_output_ZeroOrOne(){
        assertEquals(0,newInstance.bin2dec("0"));
        assertEquals(1,newInstance.bin2dec("1"));
    }

    @Test
    public void input_10_to_bin2dec_output_2(){
        assertEquals(2,newInstance.bin2dec("10"));
    }

    @Test
    public void input_properBinVariable_to_bin2dec_output_properDecVariable(){
        assertEquals(9,newInstance.bin2dec("1001"));
        assertEquals(10,newInstance.bin2dec("1010"));
        assertEquals(10,newInstance.bin2dec("01010"));
        assertEquals(24,newInstance.bin2dec("11000"));
        assertEquals(538,newInstance.bin2dec("1000011010"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void input_binVariableWithImproperVariables(){
        newInstance.bin2dec("1200");
        newInstance.bin2dec("pa100");
    }
}
