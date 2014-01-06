package com.mylib.converter.keywords;

/**
 * Created by kacprzakp on 1/3/14.
 */
public class Dec2BinU2 extends Dec2Bin{

    public Dec2BinU2(){
        super();
    }

    public String dec2binu2(int dec, int numberOfBits) {
        StringBuilder binU2 = new StringBuilder();
        int minNumberOfBits = this.minimumNumberOfBits(dec);
        properNumberOfBits(numberOfBits, minNumberOfBits);
        if (dec >= 0){
            if (dec == 0 || dec == 1){
                return binU2.append(extraBits(numberOfBits,minNumberOfBits-1,0)).append(dec).toString();
            }

        }
        else{
            if (dec == -1)
                return binU2.append(extraBits(numberOfBits, 1)).toString();

        }
        return binU2.append("0000").toString();
    }

    @Override
    protected int minimumNumberOfBits(int dec){
        return super.minimumNumberOfBits(dec)+1;
    }

    @Override
    protected StringBuilder extraBits(int numberOfBits, int flag){
        StringBuilder extraBits = new StringBuilder();
        if (flag != 1 && flag != 0)
            throw new IllegalArgumentException("Bad flag");
        for(int i = 0; i < numberOfBits; i++)
            extraBits.append(flag);
        return extraBits;
    }

    protected StringBuilder extraBits(int numberOfBits, int minNumberOfBits, int flag){
        StringBuilder extraBits = new StringBuilder();
        if (flag != 1 && flag != 0)
            throw new IllegalArgumentException("Bad flag");
        for(int i = 0; i < numberOfBits - minNumberOfBits; i++)
            extraBits.append(flag);
        return extraBits;
    }
}
