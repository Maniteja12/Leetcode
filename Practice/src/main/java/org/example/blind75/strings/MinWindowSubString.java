package org.example.blind75.strings;

import java.util.HashMap;

public class MinWindowSubString {
     public static String minWindow(String s, String t) {
          if (s.length() < t.length())
               return "";
          HashMap<Character, Integer> map = new HashMap<>();
          for (int i = 0; i < t.length(); i++)
               map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

               int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE, count = 0;
               HashMap<Character, Integer> res = new HashMap<>();
               while (right < t.length()) {
                    char c = s.charAt(right);
                    res.put(c, res.getOrDefault(c, 0) + 1);
                    if (map.containsKey(c) && res.get(c).equals(map.get(c))) {
                         count++;
                    }
                    while (left <= right && count == map.size()) {
                         c = s.charAt(left);
                         if (right - left + 1 < minLen) {
                              minLen = right - left + 1;
                              start = left;
                         }
                         res.put(c, res.get(c) - 1);
                         if (map.containsKey(c) && res.get(c) < map.get(c)) {
                              count--;
                         }
                         left++;
                    }
                    right++;
               }
          return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
     }
     public static boolean isPalindrome(int x) {
          if (x < 0 || (x % 10 == 0 && x != 0)) {
               return false;
          }
          int reversedHalf = 0;
          while (x > reversedHalf) {
               reversedHalf = reversedHalf * 10 + x % 10;
               x /= 10;
          }return x == reversedHalf || x == reversedHalf / 10;
     }
     public static void main(String[] args) {
          //System.out.println(minWindow( "ADOBECODEBANC", "ABC"));
          System.out.println(isPalindrome(121));
     }
}
