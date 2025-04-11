package org.example.DCApril25;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high){
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            int num =i;
            for(int j=i+1;j<=9;j++){
                num = num*10+j;

                if(num>= low && num <= high)
                    res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100,300));
    }
}
