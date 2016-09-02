package com.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by marie-lisehamel on 24/07/2016.
 */
public class StringConstruction {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        test();
//        int n = in.nextInt();
//        for(int a0 = 0; a0 < n; a0++){
//            String s = in.next();
//        }
    }

    public static int findSub(String s) {
        char characters[] = s.toCharArray();
        int countUnique = s.length();
        for (int i = 0; i < characters.length; i++) {
            if (i != s.indexOf(characters[i])) {
                countUnique--;
            }
        }
        return countUnique;

    }

    public static void test(){
        String a = "abcdabcd";
        assert (4 == findSub(a));
        String b = "aa";
        assert (1 == findSub(b));
        String b1 = "aaa";
        assert (1 == findSub(b1));
        String c = "abab";
        assert (2 == findSub(c));

        String d = "ababc";
        assert (3 == findSub(d));

        String e = "ababcc";
        assert (3 == findSub(e));

        String f = "abdabc";
        assert (4 == findSub(f));

        String g = "abacadabaeaff";
        assert (6 == findSub(g));


    }

}
