package dfs;

import java.util.Arrays;

/**
 *  @Author chasein
 *  @Date 2020/5/16 10:40
 *  @Description
 *  leetcode 130 被围绕的区域
 *  遍历最外侧的一周，找到边界上的‘O’，以及和边界‘O’相连的‘O’，将找到的这些‘O’先用‘#’进行替换
 *  最后再遍历一遍此board，将‘O’替换成‘X’，将‘#’替换成‘O’
 */
public class SurroundRegion {
    static char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
    };
    int row = board.length;
    int col = board[0].length;
    boolean[][] v = new boolean[row][col];
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        SurroundRegion sr = new SurroundRegion();
        sr.fill(board);
        for (char[] chars : board){
            System.out.println(Arrays.toString(chars));
        }
    }

    void fill(char[][] board){
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O' && v[r][0] == false) dfs(r, 0);
            if (board[r][col - 1] == 'O' && v[r][col - 1] == false) dfs(r, col - 1);
        }

        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O' && v[0][c] == false) dfs(0, c);
            if (board[row - 1][c] == 'O' && v[row - 1][c] == false) dfs(row - 1, c);
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '#') board[r][c] = 'O';
            }
        }
    }

    void dfs(int r, int c){
        if (r < 0 || r >= row || c < 0 || c >= col) return;
        if (board[r][c] == 'X' || v[r][c] == true) return;
        v[r][c] = true;
        board[r][c] = '#';
        for (int[] d : dir) {
            dfs(r + d[0], c + d[1]);
        }
    }
}
