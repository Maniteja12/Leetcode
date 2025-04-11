package org.example.DCApril25;

public class SwapsToMakeStringAlternating {
    public static int minSwaps(String s){
        int zeros=0,ones=0, count=0;
        for(char c: s.toCharArray()){
            if(c=='0')
                zeros++;
            else
                ones++;
        }
        if(Math.abs(zeros-ones)>1)
            return -1;
        if(zeros > ones){
            count = helper(s.toCharArray(), '1');
        }else if(zeros<ones)
            count = helper(s.toCharArray(), '0');
        else
            count =Math.min(helper(s.toCharArray(), '0'), helper(s.toCharArray(), '1'));
        return count;
    }
    private static int helper(char[] charArray, char c) {
        int swaps =0;
        for(int i=0;i<charArray.length;i++){
            if(charArray[i] == c && i%2!= 0)
                swaps++;
        }
        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("010"));
    }
}
