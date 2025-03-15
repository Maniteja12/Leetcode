package org.example.blind75.strings;

import java.util.ArrayList;
import java.util.List;

public class GeneratePrantheses {
    public static List<String> generate(int n){
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0,0,n);
        return list;
    }
    public static void backtrack(List<String> l, String curr, int openC, int closedC, int n){
        if(openC == n && closedC == n){
            l.add(curr);
            return;
        }
        if(openC < n){
            backtrack(l, curr + "(", openC+1, closedC, n);
        }
        if(closedC < openC){
            backtrack(l, curr + ")", openC, closedC+1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(generate(2));
    }
}
