package com.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mlhamel on 4/29/16.
 */
public class TestRegexp {

    public static void main(String[] args) {

        TestRegexp t = new TestRegexp();
        t.checker();

    }

    public void checker(){

        Scanner Input = new Scanner(System.in);
        String Test_String = Input.nextLine();

        String Regex_Pattern = "(([aA])\\2?\\2?(?!\\2))*";

        Pattern p = Pattern.compile("(([aA])\\2?\\2?(?!\\2))*");
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }
}
