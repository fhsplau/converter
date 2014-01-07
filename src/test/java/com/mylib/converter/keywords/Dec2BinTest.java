package com.mylib.converter.keywords;

import com.mylib.converter.keywords.Dec2Bin;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by paverell on 12/19/13.
 */
public class Dec2BinTest {
    private Dec2Bin newInstance;

    @Before
    public void setUp(){
        newInstance = new Dec2Bin();
    }

    @Test
    public void inputZeroOrOne_returnZeroOrOne(){
        assertEquals("0", newInstance.dec2bin(0));
        assertEquals("1",newInstance.dec2bin(1));
    }

    @Test
    public void input_dec_return_properBin(){
        assertEquals("10",newInstance.dec2bin(2));
        assertEquals("1010",newInstance.dec2bin(10));
        assertEquals("11010",newInstance.dec2bin(26));
        assertEquals("1000011010",newInstance.dec2bin(538));
    }

    @Test
    public void input_ZeroOrOne_and_numberOfExtraBits_return_properBinWithExtraBits(){
        assertEquals("00",newInstance.dec2bin(0,2));
        assertEquals("0000",newInstance.dec2bin(0,4));
        assertEquals("01",newInstance.dec2bin(1,2));
        assertEquals("000001",newInstance.dec2bin(1,6));
    }

    @Test
    public void input_dec_and_numberOfExtraBits_return_properBinWithExtraBits(){
        assertEquals("010",newInstance.dec2bin(2,3));
        assertEquals("00001010",newInstance.dec2bin(10,8));
        assertEquals("0000011010",newInstance.dec2bin(26,10));
    }
    @Test(expected = IllegalArgumentException.class)
    public void input_dec_and_numberOfExtraBits_thatIsLessThanMinNumberOfBits_ExceptionIsThrown(){
        newInstance.dec2bin(2,1);
        newInstance.dec2bin(26,4);
    }

}
