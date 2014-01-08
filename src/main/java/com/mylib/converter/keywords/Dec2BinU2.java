package com.mylib.converter.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

/**
 * Created by kacprzakp on 1/3/14.
 */

@RobotKeywords
public class Dec2BinU2 extends Dec2Bin{

    private static final int numberOfBitsForSign = 1;
    private int sign = 0;

    @RobotKeyword
    @ArgumentNames({"decimalValue","numberOfBits="})
    public String dec2binU2(int dec, int numberOfBits) {
        String bin;
        StringBuilder binU2 = new StringBuilder();
        int numberOfExtraBits;
        int minNumberOfBits = minimumNumberOfBits(dec) + numberOfBitsForSign;

        properNumberOfBits(numberOfBits, minNumberOfBits);
        setSign(dec);

        bin = dec2binU2Conversion(dec, numberOfBits);
        numberOfExtraBits = numberOfBits - bin.length() - 1;

        return binU2.
                append(sign).
                append(extraBits(numberOfExtraBits)).
                append(bin).
                toString();
    }

    private String dec2binU2Conversion(int dec, int numberOfBits) {
        if (sign == 0)
            return  dec2bin(dec);
        else
            return  dec2bin(enableMostSignificantBit(numberOfBits) + dec);
    }


    private void setSign(int dec){
        if (dec <0)
            sign = 1;
    }
}
