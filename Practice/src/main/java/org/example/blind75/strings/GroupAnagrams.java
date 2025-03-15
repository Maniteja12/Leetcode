package org.example.blind75.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagram(String[] strings){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strings){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagram(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
