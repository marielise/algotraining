package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by mlhamel on 4/26/16.
 */
public class CutTheStick {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nb = in.nextInt();

        ArrayList<Integer> first = new ArrayList<>();
        for(int i = 0; i < nb; i++) {
            first.add(in.nextInt());
        }

        Collections.sort(first);
        cutStick(first);

    }

    public static void cutStick(ArrayList<Integer> tab){
        while (tab.size() > 0) {
            System.out.println(tab.size());
            int cut = tab.get(0);
            ArrayList<Integer> res = new ArrayList<>();
            for(int i = 0; i < tab.size(); i++){
                int cutted = tab.get(i) - cut;
                if(cutted > 0 ) {
                    res.add(cutted);
                }
            }
            tab = res;
        }
    }


}
