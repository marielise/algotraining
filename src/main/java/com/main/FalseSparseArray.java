package com.main;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mlhamel on 5/4/16.
 */
public class FalseSparseArray {

    //List<String> strList = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).collect(Collectors.toList());

    //Map<String, Integer> counts = list.parallelStream().collect(Collectors.toConcurrentMap( w -> w, w -> 1, Integer::sum));

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Map<String, Integer> counts = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next())
                .collect(Collectors.toConcurrentMap(i -> i, i -> 1, Integer::sum));

        IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).forEach(i -> System.out.println( (int) (counts.containsKey(i) ?  counts.get(i): 0)));

      /*  int testNb = in.nextInt();

        while(--testNb >= 0){
            String search = in.next();
            if(counts.containsKey(search)) {
                System.out.println(counts.get(search));
            } else {
                System.out.println(0);
            }
        }*/
    }
}
