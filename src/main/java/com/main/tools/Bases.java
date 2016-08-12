package com.main.tools;

/**
 * Created by mlhamel on 8/11/16.
 */
public class Bases {

    public static void main(String[] args) {

        int beg = 2;

        int tt = (beg&0xff)<<24;

        System.out.println(tt);
        int ret = intLittle2big(tt);
        System.out.println(ret);
        long ll = 0x0200000000000000L;
        System.out.println(ll);
        long fin = 144115188075855872L;
        long ltb = longLittle2Big(fin);
        System.out.println(ltb);
    }

    public static int intLittle2big(int val){
        return (val&0xff)<<24 | (val&0xff00)<<8 | (val&0x00ff0000)>>8 | (val&0xff000000)>>24;
    }

    public static long longLittle2Big(long val) {
        return (val&0xff)<<56 |
                (val&0xff00)<<48 |
                (val&0xff0000)<<40 |
                (val&0xff000000)<<32 |
                (val&0xff00000000000000L)>>56 |
                (val&0x00ff000000000000L)>>48 |
                (val&0x0000ff0000000000L)>>40 |
                (val&0x000000ff00000000L)>>32 ;
    }
}
