package com.main;

import java.util.Scanner;

/**
 * Created by marie-lisehamel on 24/07/2016.
 * input
 * thisIsMyString
 * ouput
 * 4
 */
public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        String[] r = s.split("(?=\\p{Lu})");

        System.out.println(r.length);
    }
}
