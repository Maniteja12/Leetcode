package org.example.LC;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LC2981 {
    /*public int maximumLength(String s) {
        int n = s.length();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int index=i;
                while(index < n && s.charAt(index) == s.charAt(i)){
                String sub = s.substring(i,index+1);
                hashMap.put(sub,hashMap.getOrDefault(sub,0)+1);
                index++;
            }
        }
        int maxL = -1;
        for(String key :hashMap.keySet()){
            if(hashMap.get(key) >= 3 && key.length() >maxL){
                maxL = key.length();
            }
        }
        return maxL;
    }*/

    //LC3335
    public int lengthAfterTransformations(String s, int t) {
        char ch = 'z';
        int count =0;
        List<Character> arrayList = new ArrayList<>();
        for(int i = 0; i<(Math.min(t, 26)); i++){
            arrayList.add((char) ((char) (Character.toLowerCase(ch) - 'a' + 1 - i) + 'a' -1));
        }
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(arrayList.contains(c))
                count +=2;
            else
                count+=1;
        }
        return count;
    }
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        return Arrays.stream((s1 + " " + s2).split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry :: getKey).toArray(String[] ::new);        //String[] split2 = s1.split(" ");
    }
}

