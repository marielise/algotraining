package com.main;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by mlhamel on 4/25/16.
 */
public class BigDecimalExo {

    public static void main(String []argh)
    {
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.next();
        }

        //Write your code here
        List<String> listBig = new ArrayList<String>(Arrays.asList(s));

        //sort by age
        Collections.sort(listBig, new Comparator<String>() {
            @Override
            public int compare(String b1, String b2) {
                int res = (new BigDecimal(b1)).compareTo(new BigDecimal(b2));
                return res * (-1);
            }
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(listBig.get(i));
        }

    }
}
