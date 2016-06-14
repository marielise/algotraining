package com.main;

/**
 * Created by mlhamel on 3/22/16.
 */
public class MathExercice {

    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public MathExercice(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        compute();
    }

    private void compute(){
        double slope = (y1-y2)/(x1-x2);

        double b = y1 - (slope * x1);

        System.out.println("Slope= " + slope);
        System.out.println("b= " + b);
    }

    public static void main(String[] args) {
        MathExercice e1 = new MathExercice(0,2,4,10);
    }
}
