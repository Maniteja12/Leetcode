package org.example.blind75.matrix;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int index =0;
        int m = board.length, n = board[0].length;
        for(int i=0;i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                if(board[i][j] == word.charAt(index)){
                    if(search(board, i, j, index, m, n, word))
                        return true;
                }
            }
        }
        return false;
    }
    public static boolean search(char[][] board, int i, int j, int index, int m, int n, String word){
        if(index == word.length())
            return true;

        if (i < 0 || j < 0 || i == m || j == n || board[i][j] !=
                word.charAt(index) || board[i][j] == '!')
            return false;
        char c = board[i][j];
        board[i][j] = '!';

        boolean top = search(board, i-1, j, index+1, m, n, word);
        boolean left = search(board, i, j-1, index+1, m, n, word);
        boolean right = search(board, i, j+1, index+1, m, n, word);
        boolean bottom = search(board, i+1, j, index+1, m, n, word);
        board[i][j] = c;
        return top || left || right || bottom;
    }
    public static void printmatrix(char[][] matrix){
     for(int i=0;i< matrix.length;i++){
         for(int j=0;j< matrix[0].length;j++)
             System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        printmatrix(board);
        System.out.println(exist(board, "ABCC"));
        printmatrix(board);

    }
}
