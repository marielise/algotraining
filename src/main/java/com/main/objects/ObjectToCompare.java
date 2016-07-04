package com.main.objects;

import java.util.Comparator;

/**
 * Created by mlhamel on 7/4/16.
 */
public class ObjectToCompare implements Comparable<ObjectToCompare> {

    private int a;
    private int b;

    public ObjectToCompare(int a, int b){
        this.setA(a);
        this.setB(b);
    }


    @Override
    public int compareTo(ObjectToCompare o) {
        int mul = getA() * getB();
        int compMul = o.getA() * o.getB();

        if(mul < compMul) return -1;
        if (compMul > mul) return 1;

        return 0;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return a + " " + b + " => " + (a*b);
    }

    public static class ObjectComparator implements Comparator<ObjectToCompare> {

        @Override
        public int compare(ObjectToCompare o1, ObjectToCompare o2) {
            return o1.compareTo(o2);
        }
    }

}
