package com.mylib.converter.keywords; /**
 * Created by paverell on 12/19/13.
 */
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import java.lang.String;

@RobotKeywords
public class Dec2Bin{

    @RobotKeyword
    @ArgumentNames({"decimalValue","numberOfBits="})
    public String dec2bin(int dec) {
        StringBuilder bin = new StringBuilder();
        int minNumberOfBits = minimumNumberOfBits(dec);
        if(dec == 0 || dec == 1)
            return bin.
                    append(dec).
                    toString();
        else
            return bin.
                    append(dec2binConversion(dec, minNumberOfBits)).
                    toString();
    }

    @RobotKeywordOverload
    public String dec2bin(int dec, int numberOfBits) {
        StringBuilder bin = new StringBuilder();
        int minNumberOfBits = minimumNumberOfBits(dec);
        properNumberOfBits(numberOfBits, minNumberOfBits);
        int numberOfExtraBits = numberOfBits - minNumberOfBits;

        if(dec == 0 || dec == 1)
            return bin.
                    append(extraBits(numberOfExtraBits)).
                    append(dec).
                    toString();
        else
            return bin.
                    append(extraBits(numberOfExtraBits)).
                    append(dec2binConversion(dec, minNumberOfBits)).
                    toString();
    }

    protected int minimumNumberOfBits(int dec) {
        int minNumberOfBits=0;
        for(int i = dec; i > 0; i >>= 1)
            minNumberOfBits++;
        return dec!=0 ? minNumberOfBits:1;
    }

    protected void properNumberOfBits(int desirableNumberOfBits, int minNumberOfBits) {
        if(desirableNumberOfBits < minNumberOfBits)
            throw new IllegalArgumentException("To less number of bits");
    }

    protected StringBuilder extraBits(int numberOfExtraBits) {
        StringBuilder extraBits= new StringBuilder();
        for(int i = 0; i < numberOfExtraBits; i++)
            extraBits.append(0);
        return extraBits;
    }

    protected StringBuilder dec2binConversion(int dec, int minimumNumberOfBits) {
        StringBuilder bin = new StringBuilder();
        for(int i = enableMostSignificantBit(minimumNumberOfBits); i > 0; i >>= 1)
            bin = (dec & i) == 0 ? bin.append(0) : bin.append(1);
        return bin;
    }

    protected int enableMostSignificantBit(int bitNumber) {
        int mostSignificantBit=1;
        for(int i = 1; i < bitNumber; i++)
            mostSignificantBit *= 2;
        return mostSignificantBit;
    }
}