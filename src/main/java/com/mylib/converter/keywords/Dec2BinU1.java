package com.mylib.converter.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

/**
 * Created by paverell on 1/6/14.
 */

@RobotKeywords
public class Dec2BinU1 extends Dec2Bin{

    @RobotKeyword
    @ArgumentNames({"decimalValue","numberOfBits"})
    public String dec2binU1(int dec, int numberOfBits) {
        StringBuilder bin = new StringBuilder();
        int minNumberOfBits = minimumNumberOfBits(Math.abs(dec))+1;
        properNumberOfBits(numberOfBits,minNumberOfBits);

        if (dec >= 0)
            bin.append(dec2bin(dec,numberOfBits));
        else
            bin.append(dec2bin(enableAllBits(numberOfBits)^Math.abs(dec)));

        return bin.toString();
    }

    @Override
    public String dec2bin(int dec, int numberOfBits){
        return super.dec2bin(dec,numberOfBits);
    }

    @Override
    public String dec2bin(int dec){
        return super.dec2bin(dec);
    }

    private int enableAllBits(int numberOfBits) {
        int number=0;

        for(int bit = 0; bit < numberOfBits ; bit++)
            number+=(int)Math.pow(2,bit);
        return number;
    }
}
