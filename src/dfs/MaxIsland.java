package dfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  @Author chasein
 *  @Date 2020/5/15 17:11
 *  @Description
 *  leetcode 695 岛屿的最大面积
 *  跟类 MaxAreaOfIsland相比，此类的解法要更清晰简洁
 */
public class MaxIsland {
     int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
    };
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] v = new boolean[row][col];
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        MaxIsland maxIsland = new MaxIsland();
        int max = maxIsland.maxArea(maxIsland.grid);
        System.out.println(max);
    }

    int maxArea(int[][] grid){
        int area = 0;
        int maxArea = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1 && v[r][c] == false){
                    area = dfs(r, c);
                }
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }

    int dfs(int r, int c){
        if (r < 0 || r >= row || c < 0 || c >= col) return 0;
        if (grid[r][c] == 0 || v[r][c] == true) return 0;
        v[r][c] = true;
        int area = 1;
        for (int[] d : dir) {
            area += dfs(r + d[0], c + d[1]);
        }

        return area;
    }
}


