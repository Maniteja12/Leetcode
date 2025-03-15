package org.example.blind75.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        int[][] vis = new int[n][m];
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(vis[r][c] == 0 && grid[r][c] == '1'){
                    count++;
                    bfs(r,c,vis,grid);
                }
            }
        }
        return count;
    }
    public void bfs(int row, int col, int[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] =1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            //traverse in its neighbors
            int[] drow = {-1, 1, 0, 0};
            int[] dcol = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow >= 0 && nrow<n && ncol >=0 && ncol< m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }

    }
}
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
