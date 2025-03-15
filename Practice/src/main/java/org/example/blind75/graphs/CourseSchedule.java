package org.example.blind75.graphs;

import java.util.*;

public class CourseSchedule {
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] restack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isCycle(i,visited,restack,adj)) return false;
        }
        return true;
    }
    public boolean isCycle(int node,boolean[] visited, boolean[] restack, ArrayList<ArrayList<Integer>> adj){
        if (restack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        restack[node] = true;

        for (int nextNode : adj.get(node)) {
            if (isCycle(nextNode, visited, restack, adj)) return true;
        }

        restack[node] = false;
        return false;
    }
    */
    //Other IMPL
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();
        for(int i =0;i<numCourses; i++){
            adjL.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adjL.get(prereq[0]).add(prereq[1]);
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it: adjL.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
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
        }
        if(topo.size() == numCourses)
            return true;
        // it you have to return the list then return topo
        return false;
    }

}
