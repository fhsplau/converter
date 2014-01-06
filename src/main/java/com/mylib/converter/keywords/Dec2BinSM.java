package com.mylib.converter.keywords;

/**
 * Created by kacprzakp on 1/6/14.
 */
public class Dec2BinSM extends Dec2Bin{

    private static int sign = 0;

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

    private void setSign(int dec){
        if(dec < 0)
            sign = 1;
    }
}
