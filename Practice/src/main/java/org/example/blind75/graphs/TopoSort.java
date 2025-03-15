package org.example.blind75.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSort {
    //Basic impl of topoSort, refer to CourseSchedule class for clear understanding as an example
    public static boolean topoSort(int numCourses){
        List<List<Integer>> adjL = new ArrayList<>();
        int[] indegree = new int[numCourses];
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
        return false;
    }
}
