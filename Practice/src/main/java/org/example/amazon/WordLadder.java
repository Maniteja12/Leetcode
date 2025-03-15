package org.example.amazon;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        int len = wordList.size();
        Set<String> s = new HashSet<>(wordList);
        s.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int count = q.peek().second;
            q.remove();
            if(endWord.equals(word))
                return count;
            for(int i=0;i<word.length();i++){
                for(char c ='a';c<= 'z';c++){
                    char[] charArr = word.toCharArray();
                    charArr[i] = c;
                    String nword = new String(charArr);
                    if(s.contains(nword)){
                        s.remove(nword);
                        q.add(new Pair(nword, count+1));
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        String first;
        int second;
        Pair(String f, int s){
            this.first = f;
            this.second = s;
        }
    }
}
