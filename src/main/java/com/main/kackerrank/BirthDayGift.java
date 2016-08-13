package com.main.kackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created by mlhamel on 8/1/16.
 * Isaac has to buy a new HackerPhone for his girlfriend Amy. He is exploring the shops in the town
 * to compare the prices whereupon he finds a shop located on the first floor of a building, that has a
 * unique pricing policy. There are N steps leading to the shop. A numbered ball is placed on each of the steps.
 The shopkeeper gives Isaac a fair coin and asks him to toss the coin before climbing each step.
 If the result of the toss is a 'Heads', Isaac should pick up the ball, else leave it and proceed to the next step.

 The shopkeeper then asks Isaac to find the sum of all the numbers he has picked up (let's say S).
 The price of the HackerPhone is then the expected value of S. Help Isaac find the price of the HackerPhone.

 Input Format
 The first line of the input contains an integer N, the number of steps. N lines follow, which are the numbers written on the ball on each step.

 Output Format
 A single line containing expected value.

 Note : Expected value must be printed as a decimal number having exactly one digit after decimal. It is guaranteed that the correct answer will have at most one digit after decimal.

 Constraints
 1 <= N <= 40
 1 <= number on any ball <=10^9

 Sample Input #00:

 3
 1
 1
 2

 Sample Output #00:

 2.0
 Sample Input #01:

 4
 1
 2
 2
 2
 Sample Output #01:

 3.5

 Sample Out #03
 38
 83585249
 4730635
 72147488
 61929863
 64304366
 85551769
 55087638
 2094884
 78232644
 45548638
 43504052
 56694287
 72874747
 74114947
 23687041
 8043461
 18204290
 97004955
 33021116
 93183695
 22975859
 24557663
 30955998
 58141954
 56226908
 44335205
 60836538
 85003546
 39120371
 90289960
 69995749
 75221962
 95020585
 42143228
 37151815
 59324942
 80211339
 92239443

 Sample out #03
 1068649415.0
 */
public class BirthDayGift {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double expected = 0.0;
        for(int i = 0; i < N; i++){
            expected += 0.5 * in.nextLong();
        }

        BigDecimal bd = new BigDecimal(expected);
        bd = bd.setScale(1, RoundingMode.HALF_UP);

        System.out.println(bd.toString());
    }

}
