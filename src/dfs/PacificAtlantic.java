package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 逆向思维，从最外一层往里进行dfs
 */
public class PacificAtlantic {
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int rows;
    private static int cols;
    public static void main(String[] args) {
        test();
        test1();
    }

    static void test(){
        int[][] board = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println(pacificAtlantic(board));
    }

    static void test1(){
        int[][] board = {
                {10,10,10},
                {10,1,10},
                {10,10,10}
        };
        System.out.println(pacificAtlantic(board));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean[][] visited1 = new boolean[rows][cols];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            dfs(matrix, i, 0, visited);
            dfs(matrix, i, cols - 1, visited1);
        }
        for (int i = 0; i < cols; i++){
            dfs(matrix, 0, i, visited);
            dfs(matrix, rows - 1, i, visited1);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == true && visited1[i][j] == true){
                    list.add(i);
                    list.add(j);
                    res.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] matrix, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        for (int[] d : dir){
            if (
                    i + d[0] < rows
                    && i + d[0] >= 0
                    && j + d[1] < cols
                    && j + d[1] >= 0
                    && matrix[i + d[0]][j + d[1]] >= matrix[i][j]
                    && visited[i + d[0]][j + d[1]] == false)
            {
                dfs(matrix, i + d[0], j + d[1], visited);
            }
        }
    }
}
