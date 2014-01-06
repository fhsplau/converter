package com.mylib.converter.keywords;

import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.robotframework.javalib.annotation.ArgumentNames;

/**
 * Created by kacprzakp on 1/2/14.
 */
@RobotKeywords
public class Bin2Dec{

    @RobotKeyword("Launches application with the given arguments.\n\n"
            + "Example:\n"
            + "| Launch Application | _com.acme.myapplication.MyApp_ | _--data-file_ | _C:\\data.txt_ |\n")
    @ArgumentNames({"binaryValue"})
    public int bin2dec(String bin) {

        String[] bitArr = bin.split("(?!^)");
        properValue(bitArr);
        return bin2decConversion(bitArr);

    }

    private void properValue(String[] bitArr) {
        for (String bit : bitArr)
            if (!bit.equals("0") && !bit.equals("1"))
                throw new IllegalArgumentException("Bad Value");
    }

    private int bin2decConversion(String[] bitArr){
        int dec=0;
        int numberOfBits = bitArr.length;

        if (numberOfBits==1)
            return Integer.parseInt(bitArr[0]);
        else{
            for(int bitNumber=0,exponent=numberOfBits-1;bitNumber<numberOfBits && exponent>=0;bitNumber++,exponent--)
                dec += bitArr[bitNumber].equals("0") ? 0:(int) Math.pow(2, exponent);
            return dec;
        }
    }
}
