package org.example.blind75.strings;

import java.util.*;

public class LongestSubWithoutRepeatingCh {
        public static int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int maxLength = 0;
            int[] lastIndex = new int[128];

            for (int start = 0, end = 0; end < n; end++) {
                char currentChar = s.charAt(end);
                start = Math.max(start, lastIndex[currentChar]);
                maxLength = Math.max(maxLength, end - start + 1);
                lastIndex[currentChar] = end + 1;
            }

            return maxLength;
        }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0)
                System.out.println("[]");
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(a->a.val));
            for(ListNode l :lists){
                if(l!= null){
                    pq.add(l);
                }
            }
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;
            while(!pq.isEmpty()){
                ListNode min = pq.poll();
                temp.next = min;
                temp = temp.next;
                if(min.next!= null)
                   pq.add(min.next);
            }
        return dummy.next;
        }
    }
    public int trap(int[] height){
            int lmax =0, rmax =0, total=0, l=0, r = height.length-1;
            while(l<r){
                if(height[l] < height[r]){
                    if(lmax > height[l]){
                        total += lmax - height[l];
                    }
                    else
                        lmax=height[l];
                    l+=1;
                }else{
                    if(rmax > height[r]){
                        total += rmax-height[r];
                    }else
                        rmax= height[r];
                    r-=1;
                }
            }
            return total;
    }

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


