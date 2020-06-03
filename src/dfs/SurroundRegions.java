package dfs;

import java.util.Arrays;

public class SurroundRegions {
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        test();
        test1();
    }

    static void test(){
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        fill(board);
        for (char[] chs : board){
            System.out.println(Arrays.toString(chs));
        }
        System.out.println();
    }

    static void test1(){
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','O','X'}
        };
        fill(board);
        for (char[] chs : board){
            System.out.println(Arrays.toString(chs));
        }
    }


    static void fill(char[][] board){
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O'){
                dfs(board, i, 0, visited);
            }
            if (board[i][cols - 1] == 'O'){
                dfs(board, i, cols - 1, visited);
            }
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O'){
                dfs(board, 0, i, visited);
            }
            if (board[rows - 1][i] == 'O'){
                dfs(board, rows - 1, i, visited);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    static void dfs(char[][] board, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        board[i][j] = '#';
        for(int[] d : dir) {
            if (i + d[0] >= 0 && i + d[0] < rows && j + d[1] >= 0 && j + d[1] < cols
                && !visited[i + d[0]][j + d[1]] && board[i + d[0]][j + d[1]] == 'O'){
                dfs(board, i + d[0], j + d[1], visited);
            }
        }
    }
}
