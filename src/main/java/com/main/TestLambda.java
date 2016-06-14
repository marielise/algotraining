package com.main;


import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mlhamel on 2/4/16.
 */
public class TestLambda {

    public final static ThreadLocal<DateFormatter> formatter =
            ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    interface IntPred {
        boolean test(Integer value);
    }


    public static void main(String[] args) {
        //Test predicate
        Predicate<Integer> atLeast = x -> x > 5;

        System.out.println("args = [" + atLeast.test(4) + "]");
        System.out.println("args = [" + atLeast.test(8) + "]");

        BinaryOperator<String> tt = (x, y) -> {
            return x.length() + "" + y.length();
        };
        String ret = tt.apply("ab", "aret");

        System.out.println(ret);

        //without parameters
        ThreadLocal<DateFormatter> tl = ThreadLocal.withInitial(DateFormatter::new);
        Runnable helloWorld = () -> System.out.println("hello world");
        helloWorld.run();

        JButton button = new JButton();
        button.addActionListener(event ->
                System.out.println(event.getActionCommand()));

        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());

        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter form = builder.appendPattern("yyyy-MM-dd HH:mm:ss").optionalStart().appendPattern(".SSS").optionalEnd().toFormatter();

        String date1 = "2016-10-01 12:15:17.4";
        String date2 = "2016-10-01 12:15:17.42";
        String date3 = "2016-10-01 12:15:17.423";

        LocalDate d1 = LocalDate.parse(date1,form);
        LocalDate d2 = LocalDate.parse(date2,form);
        LocalDate d3 = LocalDate.parse(date3,form);


    }


}
