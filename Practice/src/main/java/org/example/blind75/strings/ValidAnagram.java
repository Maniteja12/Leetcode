package org.example.blind75.strings;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        else{
            int count[] = new int[26];
            for(int i=0; i< s.length();i++){
                count[s.charAt(i) - 'a']++;
            }
            for(int i=0; i< t.length();i++){
                count[s.charAt(i) - 'a']--;
            }
            for(int n : count){
                if(n!=0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
