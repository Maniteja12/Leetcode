package org.example.blind75.graphs;

import java.util.*;

public class ConnectedGraphs {
    public static int numberOfConnectedComponents(List<List<Integer>> adjL, int n) {
        boolean[] vis = new boolean[n + 1]; // Adjusted to 1-based indexing
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                count++;
                bfs(adjL, vis, i);
            }
        }
        return count;
    }

    public static void bfs(List<List<Integer>> adjL, boolean[] vis, int node) {
        Queue<Integer> q = new LinkedList<>();
        vis[node] = true;
        q.add(node);
        while (!q.isEmpty()) {
            int val = q.poll();
            for (int neighbor : adjL.get(val)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 10; // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 1-based indexing
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(5).add(6);
        adj.get(5).add(7);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(7).add(5);
        adj.get(7).add(6);
        adj.get(8).add(9);
        System.out.println("Number of connected components: " + numberOfConnectedComponents(adj, n));

        System.out.println("------------------");
        System.out.println((Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))));
        }
        public static int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                return new int[]{i, map.get(target - arr[i])};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
        }
}
