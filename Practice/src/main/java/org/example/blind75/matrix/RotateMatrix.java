package org.example.blind75.matrix;

import java.util.*;
import java.util.stream.Collectors;
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //loop for elements for transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //loop for swapping the elements at row level
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
    public boolean detectCycle(int src, int n, List<List<Integer>> adjL, boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        vis[src] = true;
        q.add(new Pair(src, -1));
        while(!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            for (int neighbor : adjL.get(src)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(new Pair(neighbor, node));
                }
                else if(neighbor != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
class Pair{
    int node;
    int parent;
    public Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}
