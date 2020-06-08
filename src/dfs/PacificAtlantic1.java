package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  @Author chasein
 *  @Date 2020/5/16 11:52
 *  @Description
 *  leetcode 417 太平洋大西洋水流问题
 */
public class PacificAtlantic1 {
    static int[][] board = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
    };
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] p = new boolean[rows][cols];
    boolean[][] a = new boolean[rows][cols];

    public static void main(String[] args) {
        PacificAtlantic1 pa = new PacificAtlantic1();
        System.out.println(pa.pacificAtlantic());
    }

    List<List<Integer>> pacificAtlantic(){
        for (int r = 0; r < rows; r++) {
            if (p[r][0] == false) dfs(r, 0, p);
            if (a[r][cols - 1] == false) dfs(r, cols - 1, a);
        }
        for (int c = 0; c < cols; c++) {
            if (p[0][c] == false) dfs(0, c, p);
            if (a[rows - 1][c] == false) dfs(rows - 1, c, a);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (p[i][j] == true && a[i][j] == true){
                    List<Integer> item = new ArrayList<>(Arrays.asList(i, j));
                    res.add(item);
                }
            }
        }

        return res;
    }

    void dfs(int r, int c, boolean[][] v){
        // 注释掉的原因是因为跟下面的判断重复了
//        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (v[r][c] == true) return;
        v[r][c] = true;
        for (int[] d : dir){
            // 将if判断写在递归之前，一般情况是写在刚进入方法时，像上面注释掉的那个位置。
            if(r + d[0] < rows && r + d[0] >= 0 && c + d[1] < cols && c + d[1] >= 0 && board[r + d[0]][c + d[1]] >= board[r][c]){
                dfs(r + d[0], c + d[1], v);
            }
        }
    }
}
