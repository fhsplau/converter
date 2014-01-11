package com.mylib.converter.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

/**
 * Created by paverell on 1/6/14.
 */
@RobotKeywords
public class Dec2BinSM extends Dec2Bin{

    private static int sign = 0;

    @RobotKeyword
    @ArgumentNames({"decimalValue","numberOfBits"})
    public String dec2binSM(int dec, int numberOfBits) {
        StringBuilder binU2 = new StringBuilder();
        String bin;
        int minNumberOfBits;

        setSign(dec);
        dec = Math.abs(dec);
        minNumberOfBits = minimumNumberOfBits(dec)+1;//Check value
        properNumberOfBits(numberOfBits, minNumberOfBits);

        bin = dec2bin(dec);
        return binU2.append(sign).append(extraBits(numberOfBits - bin.length() - 1)).append(bin).toString();
    }

    @Override
    public String dec2bin(int dec, int numberOfBits){
        return super.dec2bin(dec,numberOfBits);
    }

    @Override
    public String dec2bin(int dec){
        return super.dec2bin(dec);
    }

    private void setSign(int dec){
        if(dec < 0)
            sign = 1;
    }
}
