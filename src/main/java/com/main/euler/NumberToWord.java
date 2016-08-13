package com.main.euler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by marie-lisehamel on 23/07/2016.
 * Euler #17
 *
 *
 The numbers 1 to 5 written out in words are One, Two, Three, Four, Five

 First character of each word will be capital letter for example:
 104382426112 is One Hundred Four Billion Three Hundred Eighty Two Million Four Hundred Twenty Six Thousand One Hundred Twelve

 Given a number, you have to write it in words.

 Input Format
 The first line contains an integer T , i.e., number of test cases.
 Next T lines will contain an integer N.

 Constraints
1 <= T <=100
 0<= N <= 10^12

 Sample Input

 2
 10
 17

 Sample Output

 Ten
 Seventeen
 *
 *
 */
public class NumberToWord {

    private final static long[]toTest = {1000001598L, 1000,1010000000,1000010000, 1000000000000L, 14548956378L};

    public final static int[] switchBigBits = {12,9,6,3,0};
    public final static String[] switchBigVals = {" Trillion", " Billion", " Million", " Thousand",""};

    public static final Map<Integer, String> digitMap;
    public static final Map<Integer, String> digitDoubleMap;
    public static final Map<Integer, String> digitTenMap;
    static {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(1, "One");
        aMap.put(2, "Two");
        aMap.put(3, "Three");
        aMap.put(4, "Four");
        aMap.put(5, "Five");
        aMap.put(6, "Six");
        aMap.put(7, "Seven");
        aMap.put(8, "Eight");
        aMap.put(9, "Nine");
        digitMap = Collections.unmodifiableMap(aMap);

        Map<Integer, String> sMap = new HashMap<>();
        sMap.put(2, "Twenty");
        sMap.put(3, "Thirty");
        sMap.put(4, "Forty");
        sMap.put(5, "Fifty");
        sMap.put(6, "Sixty");
        sMap.put(7, "Seventy");
        sMap.put(8, "Eighty");
        sMap.put(9, "Ninety");

        digitDoubleMap = Collections.unmodifiableMap(sMap);

        Map<Integer, String> tMap = new HashMap<>();
        tMap.put(10, "Ten");
        tMap.put(11, "Eleven");
        tMap.put(12, "Twelve");
        tMap.put(13, "Thirteen");
        tMap.put(14, "Fourteen");
        tMap.put(15, "Fifteen");
        tMap.put(16, "Sixteen");
        tMap.put(17, "Seventeen");
        tMap.put(18, "Eighteen");
        tMap.put(19, "Nineteen");

        digitTenMap = Collections.unmodifiableMap(tMap);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        //int t = toTest.length;
        for(int i = 0; i < t; i++){
            long n = in.nextLong();

            //long n = toTest[i];

            if(zero(n))
                continue;

            String str = convert(n);
            System.out.println(str);
        }
    }

    public static boolean zero(long val){
        if (val == 0) {
            System.out.println("Zero");
            return true;
        }
        return false;
    }

    public static String convert(long number){
        long converted = number;
        StringBuffer toPrint = new StringBuffer();
        for(int i = 0; i < switchBigBits.length; i++){
            long toSubstract = bigNumberConvert(converted, switchBigBits[i], switchBigVals[i], toPrint);
            converted -= toSubstract;
        }
        return toPrint.toString().trim();
    }

    public static long bigNumberConvert(long val, int switchBit, String bigVal, StringBuffer ret){
        long div = (long)Math.pow(10,switchBit);
        long convert = val / div;
        if(convert <= 0) return 0;

        ret.append(convertHundred((int)convert));
        ret.append(bigVal);

        return convert * div;
    }

    public static String convertHundred(int  val){
        String str = "";
        if(val <= 0) return str;

        int convert = val / 100;

        if(convert > 0) {
            str = " " + digitMap.get(convert) + " Hundred";
        }
        convert = val - (convert * 100);
        if(convert > 0) {
            str += " " + convertBetween(convert);
        }
        return str;
    }

    public static String convertBetween(int val){
        if(val < 10)
            return digitMap.get(val);
        if(val >=10 && val <=19)
            return digitTenMap.get(val);

        int convert = val /10 ;

        String str = digitDoubleMap.get(convert);
        convert = val - (convert *10);

        if(convert > 0)
            str += " " + digitMap.get(convert);

        return str;
    }


}
