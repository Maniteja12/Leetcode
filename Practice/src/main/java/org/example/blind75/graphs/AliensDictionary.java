package org.example.blind75.graphs;

import java.util.*;

public class AliensDictionary {
    public static String findOrder(String[] dict, int k, int n){
        List<List<Integer>> adjL = new ArrayList<>();
        for(int i=0;i<k;i++){
            adjL.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int min = Math.min(s1.length(), s2.length());
            for(int p =0;p<min;p++) {
                if (s1.charAt(p) - 'a' != s2.charAt(p) - 'a'){
                    adjL.get(s1.charAt(p) - 'a').add(s2.charAt(p) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topo(k, adjL);
        String ans = " ";
        for(int i=0;i<n;i++){
            for(int it : topo){
                ans = ans + (char)(it + 'a');
            }
        }
        return ans;
    }
    private static List<Integer> topo(int k, List<List<Integer>> adjL) {
        //List<List<Integer>> adjL = new ArrayList<>();
        int[] indegree = new int[k];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);

            for(int it: adjL.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }/* // Use this if u have to return boolean for topo sort
        if(topo.size() == k)
            return true;
        return false;
        */
        return topo;
    }

    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"baa","abcd","abca","cab","cad"},4,5));
    }
}
