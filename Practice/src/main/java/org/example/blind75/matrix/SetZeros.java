package org.example.blind75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SetZeros {
    public static void setZeroes(int[][] matrix) {
        List<int[]> zeros = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    zeros.add(new int[]{i,j});
            }
        }
        for(int[] pos : zeros){
            int row = pos[0];
            int col = pos[1];

            for(int i=0;i<matrix.length;i++){
                matrix[i][col] = 0;
            }
            for(int j=0;j<matrix[0].length;j++){
                matrix[row][j] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("Matrix After Setting Zeroes:");
        printMatrix(matrix);
    }
}
